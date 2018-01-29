package com.mm.springbootmvc.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,String> {
		
	List<Course> findBytopicId(String topicId);
	
}
