package com.mm.springbootmvc.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mm.springbootmvc.course.Course;
import com.mm.springbootmvc.course.CourseService;



@Controller
public class MainController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping(value="/")
	public String init(HttpServletRequest req) {
		req.setAttribute("courses",courseService.getAllCourses());
		req.setAttribute("mode", "VIEW");
		return "index";
	}
	@GetMapping(value="/edit")
	public String init(@RequestParam String id, HttpServletRequest req) {
		req.setAttribute("course",courseService.getCourse(id));
		req.setAttribute("mode","EDIT");
		return "index";
	}
	@PostMapping(value="/save")
	public String init(@ModelAttribute Course course,HttpServletRequest req) {
		try {
		courseService.saveCourse(course);
		req.setAttribute("courses",courseService.getAllCourses());
		req.setAttribute("mode", "VIEW");
		return "index";
		}catch (Exception e) {
			req.setAttribute("ERROR",e.getMessage());
			req.setAttribute("course",courseService.getCourse(course.getId()));
			req.setAttribute("mode","EDIT");
			return "index";
		}
	}
	
	@GetMapping(value="/new")
	public String newCourse(HttpServletRequest req) {
		req.setAttribute("mode", "NEW");
		return "index";
	}
	
	@GetMapping(value="/delete")
	public String deleteCourse(@RequestParam String id, HttpServletRequest req) {
		courseService.deleteCourse(id);
		req.setAttribute("courses",courseService.getAllCourses());
		req.setAttribute("mode","VIEW");
		return "index";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor( Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
	
	
}
