package com.mm.springbootmvc.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	//Get all topics
/*	@RequestMapping("/topics/{tId}/courses")
	public List<Course> getAllCourses(@PathVariable String tId){
		 return courseService.getCourseByTopicId(tId);
	}
		
	@RequestMapping("/topics/{tId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{tId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String tId) {
		courseService.addCourse(course,tId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{tId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String id) {
		courseService.updateCourse(id, course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{tId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	*/
}
