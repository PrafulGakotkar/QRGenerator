package com.Numitry.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Numitry.in.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
