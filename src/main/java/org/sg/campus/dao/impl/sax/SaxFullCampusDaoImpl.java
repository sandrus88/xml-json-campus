package org.sg.campus.dao.impl.sax;

import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.Student;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

public class SaxFullCampusDaoImpl implements StudentDao {
    
    private FullCampusHandler campusHandler;
    
    public SaxFullCampusDaoImpl(String filePath) {
        try {
            campusHandler = new FullCampusHandler();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(filePath, campusHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Student> getAll() {
        return campusHandler.getCampus().getStudents();
    }
    
    @Override
    public Student get(int id) {
        return campusHandler.getCampus()
                .getStudents()
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .get();
    }
    
    @Override
    public int count() {
        return 0;
    }
    
    @Override
    public void create(int id, String name, String surname, String jobTitle) {
    
    }
    
    @Override
    public void update(int id, String name, String surname, String jobTitle) {
    
    }
    
    
}