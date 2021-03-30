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
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXStudent2DaoImpl implements StudentDao {
    
    private String filePath;
    private XMLEventReader reader;
    
    private List<Student> students = new ArrayList<>();
    
    @Override
    public List<Student> getAll() throws Exception {
        String fileName = "/Users/pankaj/employee.xml";
        List<Student> empList = parseXML(fileName);
        for(Student emp : empList){
            System.out.println(emp.toString());
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
    
    
    private static List<Student> parseXML(String fileName) {
        List<Student> empList = new ArrayList<>();
        Student emp = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("Student")) {
                        emp = new Student();
                        //Get the 'id' attribute from Employee element
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            emp.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    }
                    //set the other varibles from xml elements
                    else if (startElement.getName().getLocalPart().equals("name")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("surname")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setSurname(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("jobTitle")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setJobTitle(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("paymentType")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        emp.setPaymentType(PaymentType.valueOf(xmlEvent.asCharacters().getData()));
                    }
                }
                //if Employee end element is reached, add employee object to list
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("Employee")) {
                        empList.add(emp);
                    }
                }
            }
            
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return empList;
    }
    
    
}