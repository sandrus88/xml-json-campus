package org.sg.campus.dao.impl.stax;

import org.sg.campus.dao.StudentDao;
import org.sg.campus.dao.impl.sax.SaxGetElementByIdHandler;
import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXStudentDaoImpl implements StudentDao {
    
    private String filePath;
    private XMLEventReader reader;
    
    private List<Student> students = new ArrayList<>();
    
    public StAXStudentDaoImpl(String filePath) {
        try {
            this.filePath = filePath;
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Student> getAll() throws Exception {
        Student student = null;
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                final String elementName = startElement.getName().getLocalPart();
                System.out.println(elementName);
                switch (elementName) {
                    case "students":
                        students = new ArrayList<>();
                        break;
                    case "student":
                        student = new Student();
                        Attribute id = startElement.getAttributeByName(new QName("id"));
                        if (id != null) {
                            student.setId(Integer.parseInt(id.getValue()));
                        }
                        break;
                    case "name":
                        nextEvent = reader.nextEvent();
                        student.setName(nextEvent.asCharacters().getData());
                        break;
                    case "surname":
                        nextEvent = reader.nextEvent();
                        student.setSurname(nextEvent.asCharacters().getData());
                        break;
                    case "jobTitle":
                        nextEvent = reader.nextEvent();
                        student.setJobTitle(nextEvent.asCharacters().getData());
                        break;
                    case "paymentType":
                        nextEvent = reader.nextEvent();
                        student.setPaymentType(PaymentType.valueOf(nextEvent.asCharacters().getData()));
                        break;
                }
            }
            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("student")) {
                    students.add(student);
                }
            }
        }
        
        return students;
    }
    
    @Override
    public Student get(int id) throws Exception {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        SaxGetElementByIdHandler handler = new SaxGetElementByIdHandler(id);
        parser.setContentHandler(handler);
        parser.parse(new InputSource(new FileInputStream(new File(filePath))));
        
        return handler.getStudent();
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