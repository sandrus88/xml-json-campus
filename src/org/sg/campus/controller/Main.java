package org.sg.campus.controller;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
//n - new student
//r - read student by id
//ra - read all students
//u - update student by id
//d - delete student
public class Main {
	public static void main(String[] args) throws Exception {
		StudentService studentService = new StudentServiceImpl();
		CourseService courseService = new CourseServiceImpl();
		TopicService topicService = new TopicServiceImpl();
		InputStreamReader inputStream = new InputStreamReader(in);
		BufferedReader bufferReader = new BufferedReader(inputStream);

		System.out.println("Benventuo nel xml-xsd-campus");
		
		System.out.println("Cosa vorresti maneggiare? Premi 's' per studenti, 'c' per corsi, 't' per topics oppure 'e' per uscire");
		String inputLine = bufferReader.readLine();
		while (true) {
//			System.out.println("Inserisci l'operazione da eseguire: \nn - new element" + "\nr - read element by id"
//					+ "\nra - read all elements" + "\nu - update element by id" + "\nd - delete element"
//					+ "\ne - esc per uscire");
			if (inputLine.equals("s")) {
				inputLine = chooseOperationStudent(studentService, bufferReader);
			} else if (inputLine.equals("c")) {
				inputLine = chooseOperationCourse(courseService, bufferReader);
			} else if (inputLine.equals("t")) {
				inputLine = chooseOperationTopic(topicService, bufferReader);
			} else if (inputLine.equals("e")) {
				break;
			} else {
				System.out.println("Argomento non trovato... prova ancora!!!");
			}
			
			System.out.println("Cosa vorresti maneggiare? Premi 's' per studenti, 'c' per corsi, 't' per topics oppure 'e' per uscire");
			inputLine = bufferReader.readLine();
		}
	}

	private static String chooseOperationTopic(TopicService topicService, BufferedReader bufferReader)
			throws IOException, Exception {
		String inputLine;
		String id = null;
		String name = null;
		String description = null;
		String course = null;

		while (true) {
			System.out.println("Inserisci l'operazione da eseguire: \nn - new topic" + "\nr - read topic by id"
					+ "\nra - read all topics" + "\nu - update topic by id" + "\nd - delete topic"
					+ "\ne2 - esc by topics");
			inputLine = bufferReader.readLine();
			try {
				if (inputLine.equals("n")) {
					topicService.create(id, name, description, course);
				} else if (inputLine.equals("r")) {
					topicService.get(id);
				} else if (inputLine.equals("d")) {

				} else if (inputLine.equals("u")) {
					topicService.update(id, name, description, course);
				} else if (inputLine.equals("ra")) {
					List<Topic> topicsList = topicService.getAll();
					SGUtil.printList(topicsList);
					System.out.println();
				} else if (inputLine.equals("e2")) {
					break;
				} else {
					System.out.println("Non e' stata trovata nessuna operazione: Riprova!\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return inputLine;
	}

	private static String chooseOperationCourse(CourseService courseService, BufferedReader bufferReader)
			throws IOException, Exception {
		String inputLine;
		String id = null;
		String name = null;
		String description = null;
		
		while (true) {
			System.out.println("Inserisci l'operazione da eseguire: \nn - new course" + "\nr - read course by id"
					+ "\nra - read all courses" + "\nu - update course by id" + "\nd - delete course"
					+ "\ne2 - esc by courses");
			inputLine = bufferReader.readLine();
			try {
				if (inputLine.equals("n")) {
					courseService.create(id, name, description);
				} else if (inputLine.equals("r")) {
					courseService.get(id);
				} else if (inputLine.equals("d")) {

				} else if (inputLine.equals("u")) {
					courseService.update(id, name, description);
				} else if (inputLine.equals("ra")) {
					List<Course> coursesList = courseService.getAll();
					SGUtil.printList(coursesList);
					System.out.println();
				} else if (inputLine.equals("e2")) {
					break;
				} else {
					System.out.println("Non e' stata trovata nessuna operazione: Riprova!\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return inputLine;
	}

	private static String chooseOperationStudent(StudentService studentService, BufferedReader bufferReader)
			throws IOException, Exception {
		String inputLine;
		String id = null;
		String name = null;
		String surname = null;
		String jobTitle = null;
	
		while (true) {
			System.out.println("Inserisci l'operazione da eseguire: \nn - new student" + "\nr - read student by id"
					+ "\nra - read all students" + "\nu - update student by id" + "\nd - delete student"
					+ "\ne2 - esc by students");
			inputLine = bufferReader.readLine();
			try {
				if (inputLine.equals("n")) {
					studentService.create(id, name, surname, jobTitle);
				} else if (inputLine.equals("r")) {
					studentService.get(id);
				} else if (inputLine.equals("d")) {

				} else if (inputLine.equals("u")) {
					studentService.update(id, name, surname, jobTitle);
				} else if (inputLine.equals("ra")) {
					List<Student> studentsList = studentService.getAll();
					SGUtil.printList(studentsList);
					System.out.println();
				} else if (inputLine.equals("e2")) {
					break;
				} else {
					System.out.println("Non e' stata trovata nessuna operazione: Riprova!\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return inputLine;
	}
}
