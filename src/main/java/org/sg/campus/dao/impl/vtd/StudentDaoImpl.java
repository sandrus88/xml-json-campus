package org.sg.campus.dao.impl.vtd;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;

import com.ximpleware.AutoPilot;
import com.ximpleware.ModifyException;
import com.ximpleware.NavException;
import com.ximpleware.TranscodeException;
import com.ximpleware.VTDNav;
import com.ximpleware.XMLModifier;

public class StudentDaoImpl extends DaoVtdImpl implements StudentDao {

//    public static final String ELEMENT_NAME = "student";
//    public static final String STUDENT_FIELD_ID = "id";
//    public static final String STUDENT_FIELD_NAME = "name";
//    public static final String STUDENT_FIELD_SURNAME = "surname";
//    public static final String STUDENT_FIELD_JOB_TITLE = "jobTitle";
//    public static final String STUDENT_FIELD_PAYMENT_TYPE = "paymentType";
    
    public StudentDaoImpl(String filePath) throws Exception {
        super(filePath);
    }
    
    @Override
    public List<Student> getAll() throws Exception {
        VTDNav vtdNav = setupVTDNav();
        List<Student> students = new ArrayList<>();
        AutoPilot autoPilot = new AutoPilot(vtdNav);
        autoPilot.selectElement("student");
        int currentIndex;
        while (autoPilot.iterate()) {  //each student
            Student student = new Student();
            student.setId(getAttributeId(vtdNav));
            
            currentIndex = vtdNav.getCurrentIndex();
            if (vtdNav.toElement(VTDNav.FIRST_CHILD)) { //first field of student
                String tagName = vtdNav.toString(vtdNav.getCurrentIndex());
                String val = getValue(vtdNav);
//                System.out.println("tagName: " + tagName + ", val: " + val);
                enrichStudent(student, tagName, val);
                
                while (vtdNav.toElement(VTDNav.NEXT_SIBLING)) {  // the remaining fields of student
                    tagName = vtdNav.toString(vtdNav.getCurrentIndex());
                    val = getValue(vtdNav);
//                    System.out.println("tagName: " + tagName + ", val: " + val);
                    enrichStudent(student, tagName, val);
                }
                students.add(student);
            }
            vtdNav.recoverNode(currentIndex);
        }
        return students;
    }
    
    protected String getValue(VTDNav vtdNav) throws Exception {
        return new String(vtdNav.getXML().getBytes((int) vtdNav.getContentFragment(), (int) (vtdNav.getContentFragment() >> 32)));
    }
    
    @Override
    public Student get(int id) throws Exception {
        VTDNav vtdNav = setupVTDNav();
        AutoPilot autoPilot = new AutoPilot(vtdNav);
        String xPath = "//campus/students/student[@id='" + id + "']";
        autoPilot.selectXPath(xPath);
        Student student = null;
        if (autoPilot.evalXPath() != -1) {
            student = new Student();
            student.setId(getAttributeId(vtdNav));
            
            if (vtdNav.toElement(VTDNav.FIRST_CHILD)) {  //first field of student
                String tagName = vtdNav.toString(vtdNav.getCurrentIndex());
                String val = getValue(vtdNav);
                enrichStudent(student, tagName, val);
                
                while (vtdNav.toElement(VTDNav.NEXT_SIBLING)) {  // the remaining field of student
                    tagName = vtdNav.toString(vtdNav.getCurrentIndex());
                    val = getValue(vtdNav);
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
            student.setPaymentType(PaymentType.valueOf(val));
        }
    }
    
    public static int getAttributeId(VTDNav vtdNav) throws NavException {
        int originAttrIndex = vtdNav.getAttrVal("id");// trova indice dell'attributo id
        String attrVal = vtdNav.toString(originAttrIndex);// prende il valore 
        return Integer.parseInt(attrVal);
    }
    
    @Override
    public void create(int id, String name, String surname, String jobTitle) throws Exception {
        String newStudentTemplate = getNewStudentTemplate(id, name, surname, jobTitle);

        VTDNav vtdNav = setupVTDNav();
        AutoPilot autoPilot = new AutoPilot(vtdNav);
        autoPilot.selectElement("students");
        if (autoPilot.iterate()) {
            XMLModifier xmlModifier = new XMLModifier();
            xmlModifier.bind(vtdNav);
            xmlModifier.insertBeforeTail(newStudentTemplate);
            byte[] newXmlContent = toByteArray(xmlModifier);
            Files.write(Paths.get(filePath), newXmlContent);
        }
    }
    
    static byte[] toByteArray(XMLModifier xmlModifier) throws ModifyException, TranscodeException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        xmlModifier.output(baos);
        return baos.toByteArray(); // get the updated XML content
    }
    
    private String getNewStudentTemplate(int id, String name, String surname, String jobTitle) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t<student id='").append(id).append("'").append(">")
                .append("<name>").append(name).append("</name>")
                .append("<surname>").append(surname).append("</surname>")
                .append("<jobTitle>").append(jobTitle).append("</jobTitle>")
                .append("<paymentType>").append(PaymentType.UNKNOWN).append("</paymentType>")
                .append("</student>\n\t");
        return sb.toString();
    }
    
    @Override
    public void update(int id, String name, String surname, String jobTitle) {
    
    }
}
