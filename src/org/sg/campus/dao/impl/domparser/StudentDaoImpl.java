package org.sg.campus.dao.impl.domparser;

import java.util.ArrayList;
import java.util.List;

import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StudentDaoImpl extends DOMParserDao implements StudentDao {

	public StudentDaoImpl() throws Exception {
		super();
	}

	public List<Student> getAll() throws Exception {
		List<Student> students = new ArrayList<Student>();
		NodeList studentsList = document.getElementsByTagName("student");
		for (int i = 0; i < studentsList.getLength(); i++) {
			Student dto = new Student();
			Node studentNode = studentsList.item(i);
			NodeList studentFieldsList = studentNode.getChildNodes();
			for (int j = 1; j < studentFieldsList.getLength(); j++) {
				Node fieldElement = studentFieldsList.item(j);
				String attrId = fieldElement.getAttributes().getNamedItem("id").getTextContent();
				if (fieldElement.getNodeType() == Node.ELEMENT_NODE) {
					String nodeName = fieldElement.getNodeName();
					String nodeContent = fieldElement.getTextContent();
					if (nodeName.equalsIgnoreCase("id")) {
						dto.setId(Integer.parseInt(attrId));
					} else if (nodeName.equals("name")) {
						dto.setName(nodeContent);
					} else if (nodeName.equals("surname")) {
						dto.setSurname(nodeContent);
					} else if (nodeName.equals("jobTitle")) {
						dto.setJobTitle(nodeContent);
					} else if (nodeName.equals("paymentType")) {
						dto.setPaymentType(PaymentType.valueOf(nodeContent));
					}
				}
			}
			students.add(dto);
		}
		return students;
	}

	@Override
	public Student get(int id) {
		Student student = new Student();
		return student;
	}

	@Override
	public void create(int id, String name, String surname, String jobTitle) {
		throw new IllegalArgumentException("Metodo \"create\" non implementato usando il DOMParser\n");

	}

	@Override
	public void update(int id, String name, String surname, String jobTitle) {
		throw new IllegalArgumentException("Metodo \"update\" non implementato usando il DOMParser\n");

	}

	public void delete(int id) {
		throw new IllegalArgumentException("Metodo \"delete\" non implementato usando il DOMParser\n");
	}
}