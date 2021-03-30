package org.sg.campus.dao.impl.sax;

import org.sg.campus.model.Campus;
import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class FullCampusHandler extends DefaultHandler {
    
    private static final String STUDENTS = "students";
    private static final String STUDENT = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String JOB_TITLE = "jobTitle";
    private static final String PAYMENT_TYPE = "paymentType";
    
    private Campus campus;
    private String elementValue;
    
    int depth;
    
    @Override
    public void characters(char[] ch, int start, int length) {
        elementValue = new String(ch, start, length);
        System.out.println(padd() + "value: " + elementValue);
    }
    
    @Override
    public void startDocument() {
        campus = new Campus();
    }
    
    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) {
        System.out.println(padd() + "START " + qName);
        depth++;
        
        switch (qName) {
            case STUDENTS:
                campus.setStudentList(new ArrayList<>());
                break;
            case STUDENT:
                String idStr = attr.getValue(ID);
                campus.getStudents().add(new Student(Integer.parseInt(idStr)));
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) {
        depth--;
        System.out.println(padd() + "END " + qName);
        switch (qName) {
            case NAME:
                latestStudent().setName(elementValue);
                break;
            case SURNAME:
                latestStudent().setSurname(elementValue);
                break;
            case JOB_TITLE:
                latestStudent().setJobTitle(elementValue);
                break;
            case PAYMENT_TYPE:
                latestStudent().setPaymentType(PaymentType.valueOf(elementValue));
                break;
        }
    }
    
    private String padd() {
        String sep = "\t";
        String rv = "";
        for (int i = 0; i < depth; i++) {
            rv = rv + sep;
        }
        return rv;
    }
    
    private Student latestStudent() {
        List<Student> studentList = campus.getStudents();
        int latestStudentIndex = studentList.size() - 1;
        return studentList.get(latestStudentIndex);
    }
    
    public Campus getCampus() {
        return campus;
    }
}