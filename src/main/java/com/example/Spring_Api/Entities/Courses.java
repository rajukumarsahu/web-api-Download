package com.example.Spring_Api.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;
@NoArgsConstructor
@Entity
public class Courses {
	@Id
	private long id; 
	private String course;
	private String Description;
	
	public Courses(long id, String course, String Description) {
		super();
		this.id = id;
		this.course = course;
		this.Description = Description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", course=" + course + ", Description=" + Description + "]";
	}
	
}
