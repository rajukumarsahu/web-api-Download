
package com.example.Spring_Api.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring_Api.Entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long> {

}
