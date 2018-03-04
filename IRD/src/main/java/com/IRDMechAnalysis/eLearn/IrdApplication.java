package com.IRDMechAnalysis.eLearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.IRDMechAnalysis.eLearn.GetTopics.Topic;
import com.IRDMechAnalysis.eLearn.GetTopics.TopicRepository;

@SpringBootApplication
public class IrdApplication implements CommandLineRunner{

	@Autowired
	private TopicRepository topicrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(IrdApplication.class, args);

			  }
		
@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		topicrepository.save(new Topic("1","java","java basics"));
		topicrepository.save(new Topic("2","java","java advanced"));
		topicrepository.save(new Topic("3","spring","spring boot"));

		
	}
	
	
}
