package org.sg.campus.dao.impl.sax;

import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class SaxGetElementByIdHandler extends DefaultHandler {
    
    private static final String STUDENT = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String JOB_TITLE = "jobTitle";
    private static final String PAYMENT_TYPE = "paymentType";
    
    private Stack<String> elementStack = new Stack<>();
    private Stack<Student> objectStack = new Stack<>();
    private String elementValue;
    int depth;
    
    private Student student;
    private int studentID;
    
    public SaxGetElementByIdHandler(int id) {
        studentID = id;
    }
    
    @Override
    public void startDocument() {
    }
    
    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) {
        System.out.println(padd() + "START " + qName);
        depth++;
        elementStack.push(qName);
        
        switch (qName) {
            case STUDENT:
                if (attr != null) {
                    int id = Integer.parseInt(attr.getValue(ID));
                    if (id == studentID) {
                        student = new Student();
                        student.setId(id);
                    }
                }
                objectStack.push(student);
                break;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) {
        depth--;
        System.out.println(padd() + "END " + qName);
        
        elementStack.pop();
        
        //Student instance has been constructed so pop it from object stack and push in studentList
        if (STUDENT.equals(qName)) {
            Student student = objectStack.pop();
            this.student = student;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) {
        elementValue = new String(ch, start, length);
        System.out.println(padd() + "value: " + elementValue);
        
        if (!objectStack.empty()) {
            if (elementValue.length() == 0) {
                return; // ignore white space
            }
            
            if (NAME.equals(currentElement())) {
                Student student = objectStack.peek();
                student.setName(elementValue);
            } else if (SURNAME.equals(currentElement())) {
                Student student = objectStack.peek();
                student.setSurname(elementValue);
            } else if (JOB_TITLE.equals(currentElement())) {
                Student student = objectStack.peek();
                student.setJobTitle(elementValue);
            } else if (PAYMENT_TYPE.equals(currentElement())) {
                Student student = objectStack.peek();
                student.setPaymentType(PaymentType.valueOf(elementValue));
            }
        }
    }
    
    private String currentElement() {
        return elementStack.peek();
    }
    
    private String padd() {
        String sep = "\t";
        String rv = "";
        for (int i = 0; i < depth; i++) {
            rv = rv + sep;
        }
        return rv;
    }
    
    public Student getStudent() {
        return student;
    }
}