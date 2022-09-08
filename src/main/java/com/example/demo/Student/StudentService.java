package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        this.studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exist = this.studentRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException("Student does not Exist");
        }
        this.studentRepository.deleteById(id);

    }

    @Transactional
    public void updateStudent(Long id, String name) {
        Student student = studentRepository.findById(id).orElseThrow(()
                -> new IllegalStateException("student nit found")
        );
        if (name != null && name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
    }
}
