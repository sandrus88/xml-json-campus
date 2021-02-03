package org.sg.campus.dao;

import java.util.List;

import com.ximpleware.NavException;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;
import org.sg.campus.model.Student;

public interface StudentDao {
	
	List<Student> getAll() throws Exception;
	Student get(int id) throws XPathParseException, NavException, XPathEvalException;
	void create(int id, String name, String surname, String jobTitle);
	void update(int id, String name, String surname, String jobTitle);
}
