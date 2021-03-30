package org.sg.campus.dao.impl.domparser;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static org.sg.util.StudentBuilder.enrichStudent;

public class StudentDaoImpl extends DOMParserDao implements StudentDao {

	public StudentDaoImpl() throws Exception {
		super();
	}

	public List<Student> getAll() throws Exception {
		List<Student> students = new ArrayList<Student>();
		NodeList studentsList = document.getElementsByTagName("student");
		for (int i = 0; i < studentsList.getLength(); i++) {
			Node studentNode = studentsList.item(i);
			String s = studentNode.getAttributes().getNamedItem("id").getTextContent();
			NodeList studentFieldsList = studentNode.getChildNodes();
			Student dto = new Student();
			for (int j = 0; j < studentFieldsList.getLength(); j++) {
				Node fieldElement = studentFieldsList.item(j);
				if (fieldElement.getNodeType() == Node.ELEMENT_NODE) {
					String nodeName = fieldElement.getNodeName();
					String nodeContent = fieldElement.getTextContent();
					dto.setId(Integer.parseInt(s));
					enrichStudent(dto, nodeName, nodeContent);
				}
			}
			students.add(dto);
		}
		return students;
	}

	@Override
	public Student get(int id) {
		throw new IllegalArgumentException("Metodo \"get\" non implementato usando il DOMParser\n");
		
	}

	@Override
	public void create(int id, String name, String surname, String jobTitle) {
		throw new IllegalArgumentException("Metodo \"create\" non implementato usando il DOMParser\n");

	}

	@Override
	public void update(int id, String name, String surname, String jobTitle) {
		throw new IllegalArgumentException("Metodo \"update\" non implementato usando il DOMParser\n");

	}
	
	@Override
	public int count() throws Exception {
		return 0;
	}
	
	public void delete(int id) {
		throw new IllegalArgumentException("Metodo \"delete\" non implementato usando il DOMParser\n");
	}
}