package org.sg.campus.dao.impl.vtd;

import com.ximpleware.AutoPilot;
import com.ximpleware.NavException;
import com.ximpleware.VTDNav;
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
            int id = -1;
            String name = null;
            String surname = null;
            String jobTitle = null;
            String paymentType = null;
            
            currentIndex = vtdNav.getCurrentIndex();
            String tagName = vtdNav.toString(vtdNav.getCurrentIndex());
            System.out.println("in index: " + currentIndex + " found tag: " + tagName + ", going to read his children");
            
            if (vtdNav.toElement(VTDNav.FIRST_CHILD)) {
                tagName = vtdNav.toString(vtdNav.getCurrentIndex());
//              System.out.println("FIRST_CHILD found tag: " + tagName);
                String val = getValue(vtdNav);
//              System.out.println("val: " + val);
                
                if (tagName.equalsIgnoreCase("id")) {
                    id = Integer.parseInt(val);
                } else if (tagName.equals("name")) {
                    name = val;
                } else if (tagName.equals("surname")) {
                    surname = val;
                } else if (tagName.equals("jobTitle")) {
                    jobTitle = val;
                } else if (tagName.equals("paymentType")) {
                    paymentType = val;
                }

                while (vtdNav.toElement(VTDNav.NEXT_SIBLING)) {  //each field of student
                    tagName = vtdNav.toString(vtdNav.getCurrentIndex());
//                  System.out.println("NEXT_SIBLING found tag: " + tagName);
                    val = getValue(vtdNav);
//                  System.out.println("val: " + val);
    
                    if (tagName.equalsIgnoreCase("id")) {
                        id = Integer.parseInt(val);
                    } else if (tagName.equals("name")) {
                        name = val;
                    } else if (tagName.equals("surname")) {
                        surname = val;
                    } else if (tagName.equals("jobTitle")) {
                        jobTitle = val;
                    } else if (tagName.equals("paymentType")) {
                        paymentType = val;
                    }
                }
    
                Student student = new Student(id, name, surname, jobTitle, paymentType);
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
    public Student get(int id) {
        AutoPilot autoPilot = new AutoPilot(vtdNav);
        autoPilot.selectElement("student");
        
        return null;
    }
    
    @Override
    public void create(int id, String name, String surname, String jobTitle) {
    
    }
    
    @Override
    public void update(int id, String name, String surname, String jobTitle) {
    
    }
}
