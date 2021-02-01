package org.sg.campus.controller;

import java.util.List;

import org.sg.campus.model.Student;
import org.sg.campus.service.StudentServiceImpl;
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
		StudentServiceImpl studentService = new StudentServiceImpl();
		//se siamo in questo caso l'utente deve inserire quatrro stringhe dove la parima e' l'id, seconda name etc
//		studentService.create("", "", "", "");
//		studentService.get("");
		List<Student> studentsList = studentService.getAll();
		SGUtil.printList(studentsList);
//		studentService.update("", "", "", "");
	}
}
