package com.IRDMechAnalysis.eLearn.GetTopics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicservice;

	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicservice.getAllTopics();

	}

	@RequestMapping("/topics/{id}")
	public Topic getByid(@PathVariable String id) {
		return topicservice.getById(id);

	}

	@PostMapping("/topics")
	public ResponseEntity<String> addTopic(@RequestBody Topic tp) {
		/*Boolean u = topicservice.addNewTopic(tp);
		String report = "Successfully added";
		if (u) {
			report = "Id already exists";
		}*/
		topicservice.addNewTopic(tp);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@PutMapping("/topics/{id}")
	public void updateTopic(@RequestBody Topic tp, @PathVariable String id) {
		
		topicservice.updateTopic(tp);
	}

	@DeleteMapping("/topics/delete/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicservice.deleteTopic(id);
	}

}
