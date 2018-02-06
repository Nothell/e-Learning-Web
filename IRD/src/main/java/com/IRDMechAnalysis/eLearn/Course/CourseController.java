package com.IRDMechAnalysis.eLearn.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IRDMechAnalysis.eLearn.GetTopics.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseservice;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourse(@PathVariable String id) {
		return courseservice.getAllCourses(id);

	}

	@RequestMapping("/topics/{topicid}/course/{id}")
	public Course getByid(@PathVariable Long id) {
		return courseservice.getById(id);

	}

	@PostMapping("/topics/{topicid}/course")
	public void addCourse(@RequestBody Course course,@PathVariable String topicid) {
		course.setTopic(new Topic(topicid,"",""));
		courseservice.addNewCourse(course);
	}

	@PutMapping("/topics/{topicid}/course/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String topicid) {
		course.setTopic(new Topic(topicid,"",""));
		courseservice.updateCourse(course);
	}

	@DeleteMapping("/topics/{topicid}/delete/course/{id}")
	public void deleteTopic(@PathVariable Long id) {
		courseservice.deleteCourse(id);
	}

}
