package com.example.Spring_Api.Excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Spring_Api.Dao.CourseDao;
import com.example.Spring_Api.Entities.Courses;
import com.example.Spring_Api.Services.CourseService;
@Service
public class ReportService {
	@Autowired
	private CourseDao courseservice; 
	@GetMapping("/Excel")
	public void generatedExcel(HttpServletResponse response) throws IOException {
		List<Courses>courses=courseservice.findAll();
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("CoursesInfo");
		HSSFRow row=sheet.createRow(0);
		
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Course");
		row.createCell(2).setCellValue("Description");
		
		int datarowindex=1;
		for(Courses course:courses) {
			HSSFRow datarow=sheet.createRow(datarowindex);
			datarow.createCell(0).setCellValue(course.getId());
			datarow.createCell(1).setCellValue(course.getCourse());
			datarow.createCell(2).setCellValue(course.getDescription());
			
			datarowindex ++;
			 
		}
		ServletOutputStream ops= response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();
	}
	
}
