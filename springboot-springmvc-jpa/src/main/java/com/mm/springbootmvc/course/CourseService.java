package com.mm.springbootmvc.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	public List<Course> getCourseByTopicId(String topicId){
		List<Course> courses=new ArrayList<>();
		courseRepository.findBytopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public List<Course> getAllCourses(){
		List<Course> courses=new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(String id,Course course) {
		course.setId(id);
		courseRepository.save(course);
	}
	public void saveCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}

	
}