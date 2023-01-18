package com.example.Spring_Api.controler;

import java.io.IOException;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring_Api.Entities.Courses;
import com.example.Spring_Api.Excel.ReportService;
import com.example.Spring_Api.Services.CourseService;

 
///@Controller
@RestController
public class MyController {
	@Autowired
	private CourseService courseservice; 
	
	@Autowired
	private ReportService reportService;
	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerkey="Content-Disposition";
		String headerValue="Attachment;filename=Courses.xls";
		
		response.setHeader(headerkey, headerValue);
		
		reportService.generatedExcel(response);
		
	}
	
	
	
	
	@GetMapping("/home")
	public String home() {
		return "This is my home";
	}
	
	
	@GetMapping("/Courses")
	public List<Courses> GetCourses() {
		
		return this.courseservice.GetCourses();
	}
	@GetMapping("/Courses/{courseId}")
	public Courses GetCourse(@PathVariable String courseId) {
		
		return this.courseservice.GetcoCoursess(Long.parseLong(courseId));
		
	}
	@PostMapping("/Courses")
	public Courses AddCourse(@RequestBody Courses course)
	{
	
		return this.courseservice.AddCourse(course);
	}
	@PutMapping("/Courses")
	public Courses UpdateCourse(@RequestBody Courses course) {
	
		return this.courseservice.UpdateCourse(course);	
	}
	@DeleteMapping("/Courses/{courseId}")
	public ResponseEntity<HttpStatus> DeleteCourse(@PathVariable String courseId) {
		try {
			  this.courseservice.DeleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
