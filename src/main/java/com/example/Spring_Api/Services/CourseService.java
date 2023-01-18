package com.example.Spring_Api.Services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.example.Spring_Api.Entities.Courses;

public interface CourseService {
	
	public List<Courses>  GetCourses();
	
	public Courses GetcoCoursess(long courseId); 
	
	public Courses AddCourse(Courses course);
	public Courses UpdateCourse(Courses course);
	public void DeleteCourse(long  parseLong); 
	
	
}
