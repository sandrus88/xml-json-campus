package org.sg.campus.dao.impl.sax;

import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SaxGetAllHandler extends DefaultHandler {
    
    private static final String STUDENTS = "students";
    private static final String STUDENT = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String JOB_TITLE = "jobTitle";
    private static final String PAYMENT_TYPE = "paymentType";
    
    //This is the list which shall be populated while parsing the XML.
    private List<Student> studentList = new ArrayList<>();
    //As we read any XML element we will push that in this stack
    private Stack<String> elementStack = new Stack<>();
    //As we complete one user block in XML, we will push the User instance in userList
    private Stack<Student> objectStack = new Stack<>();
    
    int depth;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(padd() + "START " + qName);
        depth++;
        // add element under processing in the elementStack
        elementStack.push(qName);
        
        //If this is start of 'student', create new Student and push it in the object stack
        if (STUDENT.equals(qName)) {
            Student student = new Student();
            if (attributes != null) {
                student.setId(Integer.parseInt(attributes.getValue(ID)));
            }
            objectStack.push(student);
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        depth--;
        System.out.println(padd() + "END " + qName);
        elementStack.pop();
        
        //Student instance has been constructed so pop it from object stack and push in studentList
        if (STUDENT.equals(qName)) {
            Student student = objectStack.pop();
            studentList.add(student);
        }
    }
    
    /**
     * This will be called everytime parser encounter a value node
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        System.out.println(padd() + "value: " + value);
        
        if (value.length() == 0) {
            return; // ignore white space
        }
        
        if (NAME.equals(currentElement())) {
            Student student = objectStack.peek();
            student.setName(value);
        } else if (SURNAME.equals(currentElement())) {
            Student student = objectStack.peek();
            student.setSurname(value);
        } else if (JOB_TITLE.equals(currentElement())) {
            Student student = objectStack.peek();
            student.setJobTitle(value);
        } else if (PAYMENT_TYPE.equals(currentElement())) {
            Student student = objectStack.peek();
            student.setPaymentType(PaymentType.valueOf(value));
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
    
    /**
     * Utility method for getting the current element in processing
     */
    private String currentElement() {
        return elementStack.peek();
    }
    
    public List getStudents() {
        return studentList;
    }
    
}