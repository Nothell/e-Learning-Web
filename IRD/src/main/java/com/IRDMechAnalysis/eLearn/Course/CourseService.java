package com.IRDMechAnalysis.eLearn.Course;

import java.util.ArrayList;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class CourseService {

	@Autowired
	private CourseRepository courserepository;

	public List<Course> getAllCourses(String id) {
		List<Course> course = new ArrayList<>();
		courserepository.findByTopicId(id).forEach(course::add);
		return course;

	}

	public Course getById(Long id) {
		return courserepository.findOne(id);
	}

	public void addNewCourse(Course tp) {
		courserepository.save(tp);
	}

	public void updateCourse(Course tp) {
		courserepository.save(tp);

	}

	public void deleteCourse(Long id) {
		courserepository.delete(id);
	}
}