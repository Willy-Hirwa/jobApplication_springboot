package com.mhwc.jobPlatform;

import com.mhwc.jobPlatform.dao.JobRepository;
import com.mhwc.jobPlatform.dao.UserDao;
import com.mhwc.jobPlatform.model.Job;
import com.mhwc.jobPlatform.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class JobBoardPlatformForConnectingJobSeekersWithEmployersApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobBoardPlatformForConnectingJobSeekersWithEmployersApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner mappingDemo(JobRepository jobRepository,
//										 UserDao userDao) {
//		return args -> {
//
//			// create a job
////			Student student = new Student("John Doe", 15, "8th");
//			Job j = new Job("Developer","nyanza","developing");
//
//
//			// save the student
//
////			studentRepository.save(student);
//
//			// create three courses
////			Course course1 = new Course("Machine Learning", "ML", 12, 1500);
////			Course course2 = new Course("Database Systems", "DS", 8, 800);
////			Course course3 = new Course("Web Basics", "WB", 10, 0);
//			User u1 = new User("peace","crai","crai@gmail.com","cra","200","0780048769");
//			User u2 = new User("mugisha","para","parfait@gmail.com","pa","134","0792018769");
//
//			// save courses
//            j.addUser(u1);
//			j.addUser(u2);
//			u1.addJob(j);
//
//
//
//			userDao.save(u1);
////			userDao.save(u2);
//			jobRepository.save(j);
//
//			// add courses to the student
////			student.getCourses().addAll(Arrays.asList(course1, course2, course3));
////			j.getUsers().addAll(Arrays.asList(u1,u2));
////			j.getUsers().add(u1);
////			j.getUsers().add(u2);
//
//
//			// update the student
////			studentRepository.save(student);
////			jobRepository.save(j);
//		};
//	}
}



