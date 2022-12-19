package com.example.demo1912.repositories;

import com.example.demo1912.data.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}