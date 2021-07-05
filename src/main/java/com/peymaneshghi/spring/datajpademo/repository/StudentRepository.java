package com.peymaneshghi.spring.datajpademo.repository;

import com.peymaneshghi.spring.datajpademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    Student findStudentByFirstName(String firstName);

    List<Student> findByFirstNameIsContaining(String name);

//    List<Student> findByLastNotNull();

    List<Student> findStudentByGuardianName(String name);

    Student findByFirstNameAndLastName(String firstName,
                                       String lastName);

    Student findByEmailId(String emailIAddress);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);


    //Native Query
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIAddress(String emailId);

    //Native Named Param
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailIAddressNativeNameParam(
            @Param("emailId")String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateSudentNameByEmailId(String firstName, String emailId);
}
