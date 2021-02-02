package org.sg.campus.controller;

import static java.lang.System.in;

import java.io.BufferedReader;
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
		InputStreamReader inputStream = new InputStreamReader(in);
		BufferedReader bufferReader = new BufferedReader(inputStream);

		System.out.println("Benventuo nel xml-xsd-campus");
		System.out.println("Cosa vorresti maneggiare? Premi 's' per studenti, 'c' per corsi oppure 't' per topics");
		
		String inputLine = bufferReader.readLine();
		while (true) {
			if (inputLine.equals("s")) {
				System.out.println("Inserisci l'operazione da eseguire: ");
				inputLine = bufferReader.readLine();
				while (true) {
					if (inputLine.equals("ra")) {
						List<Student> studentsList = studentService.getAll();
						SGUtil.printList(studentsList);
						inputLine = bufferReader.readLine();
					} else if (inputLine.equals("e")) {
						break;
					} else {
						System.out.println("Non e' stata trovata nessuna operazione: Riprova!");
						inputLine = bufferReader.readLine();
					}
				}
			} else if (inputLine.equals("c")) {
				System.out.println("Inserisci l'operazione da eseguire: ");
				inputLine = bufferReader.readLine();
				while (true) {
					if (inputLine.equals("ra")) {
						List<Course> coursesList = courseService.getAll();
						SGUtil.printList(coursesList);
						inputLine = bufferReader.readLine();
					} else if (inputLine.equals("e")) {
						break;
					} else {
						System.out.println("Non e' stata trovata nessuna operazione: Riprova!");
						inputLine = bufferReader.readLine();
					}
				}
			} else if (inputLine.equals("t")) {
				System.out.println("Inserisci l'operazione da eseguire: ");
				inputLine = bufferReader.readLine();
				while (true) {
					if (inputLine.equals("ra")) {
						List<Topic> topicsList = topicService.getAll();
						SGUtil.printList(topicsList);
						inputLine = bufferReader.readLine();
					} else if (inputLine.equals("e")) {
						break;
					} else {
						System.out.println("Non e' stata trovata nessuna operazione: Riprova!");
						inputLine = bufferReader.readLine();
					}
				}
			} else if (inputLine.equals("e")) {
				break;
			} else {
				System.out.println("Argomento non trovato... prova ancora!!!");
				inputLine = bufferReader.readLine();
			}
		}
	}
}
