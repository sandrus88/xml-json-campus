package org.sg.campus.controller;

import java.util.List;

import org.sg.campus.model.Course;
import org.sg.campus.model.Student;
import org.sg.campus.model.Topic;
import org.sg.campus.service.CourseService;
import org.sg.campus.service.CourseServiceImpl;
import org.sg.campus.service.StudentService;
import org.sg.campus.service.StudentServiceImpl;
import org.sg.campus.service.TopicService;
import org.sg.campus.service.TopicServiceImpl;
import org.sg.util.SGUtil;

//main la classe si avvia e chiede un comando 
//Benventuo nel xml-xsd-campus   CRUD
//Cosa vorresti maneggiare? Premi "s" per studenti, "c" per courses oppure "t" per topics
//Inserisci l'operazione da eseguire:  
//c - create student
//r - read student by id
//ra - read all students
//u - update student by id
//d - delete student
public class Main {
	public static void main(String[] args) throws Exception {
		StudentService studentService = new StudentServiceImpl();
		CourseService courseService = new CourseServiceImpl();
		TopicService topicService = new TopicServiceImpl();
		//se siamo in questo caso l'utente deve inserire quatrro stringhe dove la parima e' l'id, seconda name etc
//		studentService.create("", "", "", "");
//		studentService.get("");
		List<Student> studentsList = studentService.getAll();
		SGUtil.printList(studentsList);
		List<Course> coursesList = courseService.getAll();
		SGUtil.printList(coursesList);
		List<Topic> topicsList = topicService.getAll();
		SGUtil.printList(topicsList);
//		studentService.update("", "", "", "");
	}
}
