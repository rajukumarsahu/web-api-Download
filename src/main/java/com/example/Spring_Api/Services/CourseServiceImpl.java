package com.example.Spring_Api.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring_Api.Dao.CourseDao;
import com.example.Spring_Api.Entities.Courses;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	// List<Courses>list;
	 
 
	 
	@Override
	public List<Courses> GetCourses() {
		return courseDao.findAll();
	}

	@Override
	public Courses GetcoCoursess(long courseId)
	{
//		 Courses c=null;
//		 for( Courses courses:list) 
//		 {
//			 if(courses.getId()==courseId) 
//			 {
//				 c=courses;
//				 break;
//			 }
//		 }
		return courseDao.getOne(courseId);
	}

	@Override
	public Courses AddCourse(Courses course) {
		 courseDao.save(course);
 		return course;
	}

	@Override
	public Courses UpdateCourse(Courses course) {
//		list.forEach(e->{
//			if(e.getId()==course.getId()) {
//				e.setCourse(course.getCourse());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
 		return course;
	}

	@Override
	public void DeleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		Courses entities=courseDao.getOne(parseLong);
		courseDao.delete(null);
	}

 

}
