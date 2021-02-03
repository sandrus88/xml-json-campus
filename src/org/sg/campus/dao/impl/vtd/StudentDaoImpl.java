package org.sg.campus.dao.impl.vtd;

import com.ximpleware.*;
import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends DaoVtdImpl implements StudentDao {

//    public static final String ELEMENT_NAME = "student";
//    public static final String STUDENT_FIELD_ID = "id";
//    public static final String STUDENT_FIELD_NAME = "name";
//    public static final String STUDENT_FIELD_SURNAME = "surname";
//    public static final String STUDENT_FIELD_JOB_TITLE = "jobTitle";
//    public static final String STUDENT_FIELD_PAYMENT_TYPE = "paymentType";
    
    public StudentDaoImpl(String pathFile) throws Exception {
        super(pathFile);
    }
    
    @Override
    public List<Student> getAll() throws Exception {
        List<Student> students = new ArrayList<>();
        AutoPilot autoPilot = new AutoPilot(vtdNav);
        autoPilot.selectElement("student");
        int currentIndex;
        while (autoPilot.iterate()) {  //each student
            Student student = new Student();
            student.setId(getAttribute(vtdNav, "id"));
            
            currentIndex = vtdNav.getCurrentIndex();
            if (vtdNav.toElement(VTDNav.FIRST_CHILD)) { //first field of student
                String tagName = vtdNav.toString(vtdNav.getCurrentIndex());
                String val = getValue(vtdNav);
//                System.out.println("tagName: " + tagName + ", val: " + val);
                enrichStudent(student, tagName, val);
                
                while (vtdNav.toElement(VTDNav.NEXT_SIBLING)) {  // the remaining fields of student
                    tagName = vtdNav.toString(vtdNav.getCurrentIndex());
                    val = getValue(vtdNav);
//                  System.out.println("tagName: " + tagName + ", val: " + val);
                    enrichStudent(student, tagName, val);
                }
                students.add(student);
            }
            vtdNav.recoverNode(currentIndex);
        }
        return students;
    }
    
    protected String getValue(VTDNav vtdNav) throws NavException {
        return new String(vtdNav.getXML().getBytes((int) vtdNav.getContentFragment(), (int) (vtdNav.getContentFragment() >> 32)));
    }
    
    @Override
    public Student get(int id) throws XPathParseException, NavException, XPathEvalException {
        AutoPilot autoPilot = new AutoPilot(vtdNav);
        String xPath = "//campus/students/student[@id='" + id + "']";
        autoPilot.selectXPath(xPath);
        Student student = null;
        if (autoPilot.evalXPath() != -1) {
//            String studentTagFound = vtdNav.toString(vtdNav.getCurrentIndex());
//            String studentValueFound = getValue(vtdNav);
//            System.out.println("studentTagFound: " + studentTagFound + ", studentValueFound: " + studentValueFound);
            
            student = new Student();
            student.setId(getAttribute(vtdNav, "id"));
            
            if (vtdNav.toElement(VTDNav.FIRST_CHILD)) {  //first field of student
                String tagName = vtdNav.toString(vtdNav.getCurrentIndex());
                String val = getValue(vtdNav);
//                System.out.println("tagName: " + tagName + ", val: " + val);
                enrichStudent(student, tagName, val);
    
                while (vtdNav.toElement(VTDNav.NEXT_SIBLING)) {  // the remaining field of student
                    tagName = vtdNav.toString(vtdNav.getCurrentIndex());
                    val = getValue(vtdNav);
//                  System.out.println("tagName: " + tagName + ", val: " + val);
                    enrichStudent(student, tagName, val);
                }
            }
        }
        
        return student;
    }
    
    private void enrichStudent(Student student, String tagName, String val) {
        if (tagName.equals("name")) {
            student.setName(val);
        } else if (tagName.equals("surname")) {
            student.setSurname(val);
        } else if (tagName.equals("jobTitle")) {
            student.setJobTitle(val);
        } else if (tagName.equals("paymentType")) {
            student.setPaymentType(val);
        }
    }
    
    public static int getAttribute(VTDNav vtdNav, String attrName) throws NavException {
        int originAttrIndex = vtdNav.getAttrVal(attrName);
        if (originAttrIndex == -1) {
            throw new IllegalArgumentException("Attribute: " + attrName + " not present");
        }
        String attrVal = vtdNav.toString(originAttrIndex);
        return Integer.parseInt(attrVal);
    }
    
    @Override
    public void create(int id, String name, String surname, String jobTitle) {
    
    }
    
    @Override
    public void update(int id, String name, String surname, String jobTitle) {
    
    }
}
