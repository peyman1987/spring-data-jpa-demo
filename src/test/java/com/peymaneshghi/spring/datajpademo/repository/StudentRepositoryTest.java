package com.peymaneshghi.spring.datajpademo.repository;

import com.peymaneshghi.spring.datajpademo.entity.Guardian;
import com.peymaneshghi.spring.datajpademo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saneStudent() {
        Student student = Student.builder()
                .emailId("peymam@email.com")
                .firstName("Peyman")
                .lastName("Eshghi Malayeri")
                //.guardianName("Pey")
                //.guardianEmail("pey@gmail.com")
                //.guardianMobile("333888")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Pey")
                .email("pey@gmail.com")
                .mobile("333999")
                .build();

        Student student = Student.builder()
                .emailId("peyman@email.com")
                .firstName("Peyman")
                .lastName("Eshghi")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("srtudentList = " + studentList);

    }

    @Test
    public void printStudentBasedOnGuardianName() {

        List<Student> students =
                studentRepository.findStudentByGuardianName("Pey");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnFirstNameAndLastName(){
        Student student =
                studentRepository.findByFirstNameAndLastName("Peyman", "Eshghi");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFindByEmailId(){
        Student student =
                studentRepository.findByEmailId("peyman@email.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentGetStudentByEmailId(){
        Student student =
                studentRepository.getStudentByEmailId("peyman@email.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailId(){
        String studentFirstName =
                studentRepository.getStudentFirstNameByEmailId("peyman@email.com");
        System.out.println("studentFirstName = " + studentFirstName);
    }

    @Test
    public void printStudentGetStudentByEmailIdNative(){
        Student student =
                studentRepository.getStudentByEmailIAddress("peyman@email.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentGetStudentByEmailIAddressNativeNameParam(){
        Student student =
                studentRepository.getStudentByEmailIAddressNativeNameParam("peyman@email.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateSudentNameByEmailId(){
        studentRepository.updateSudentNameByEmailId("Niki","niki@email.com");
    }


}