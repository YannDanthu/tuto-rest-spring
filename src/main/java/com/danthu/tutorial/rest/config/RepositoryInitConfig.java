package com.danthu.tutorial.rest.config;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import repository.CourseMemoryRepository;
import repository.CourseRepository;

import com.danthu.tutorial.rest.model.Course;

@Configuration
public class RepositoryInitConfig {

	@Bean
	public CourseRepository createRepo() {
		Course course = new Course();
		course.setId(UUID.randomUUID().toString());
		course.setName("Test");
		course.setDescription("Test course description");
		HashMap<String, Course> initList = new HashMap<String, Course>();
		initList.put(course.getId(), course);
		return new CourseMemoryRepository(initList);
	}

}
