package org.sg.campus.dao.impl.xerces;

import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XercesStudentDaoImpl implements StudentDao {
    
    private String filePath;
    private Document doc;
    
    private List<Student> students = new ArrayList<>();
    
    public XercesStudentDaoImpl(String filePath) {
        try {
            this.filePath = filePath;
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.parse(new File(filePath));
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Student> getAll()  {
        List<Student> students = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("student");
        
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node first = nodeList.item(i);
            if (first.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(first.getNodeName() + ": " + first.getTextContent());
                nodeList = first.getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    System.out.println(first.getNodeName() + ": " + first.getTextContent());
                    first = nodeList.item(j);
                    Student s = new Student();
                    students.add(s);
                }
            }
        }
        
        return students;
    }
    
    @Override
    public Student get(int id) throws Exception {
        return null;
    }
    
    @Override
    public int count() throws Exception {
        return 0;
    }
    
    @Override
    public void create(int id, String name, String surname, String jobTitle) throws Exception {
    
    }
    
    @Override
    public void update(int id, String name, String surname, String jobTitle) {
    
    }
    
    
}