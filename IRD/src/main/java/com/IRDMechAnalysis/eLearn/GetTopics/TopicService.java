package com.IRDMechAnalysis.eLearn.GetTopics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class TopicService {
	
	@Autowired
	private TopicRepository topicrepository;

	/*
	 * @SuppressWarnings({ "unchecked", "rawtypes" }) private List<Topic> getTopics
	 * = new ArrayList<>(Arrays.asList(new Topic("1", "rohan", "junior Consultant"),
	 * new Topic("2", "Pritish", "Consultant"), new Topic("3", "Srikant", "MD")));
	 */
	public List<Topic> getAllTopics() {
//		return getTopics;
		List<Topic> topics=new ArrayList<>();
		topicrepository.findAll().forEach(topics::add);
		return topics;
		
	}

	public Topic getById(String id) {
		//return getTopics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicrepository.findOne(id);
	}

	public void addNewTopic(Topic tp) {
		/*Boolean u = false;
		u = getTopics.stream().filter(t -> t.getId().equals(tp.getId())).findFirst().isPresent();
		if (u == false) {
			getTopics.add(tp);
		}
		return u;*/
		topicrepository.save(tp);
	}

	public void updateTopic(Topic tp) {

		/*for (int i = 0; i < getTopics.size(); i++) {
			Topic t = getTopics.get(i);
			if (t.getId().equals(id)) {
				getTopics.set(i, tp);
				return;
			}
		}*/
		topicrepository.save(tp);

	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		//getTopics.removeIf(t -> t.getId().equals(id));
topicrepository.delete(id);
	}
}