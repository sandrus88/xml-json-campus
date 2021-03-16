package org.sg.campus.dao.impl.vtd;

import com.ximpleware.AutoPilot;
import com.ximpleware.VTDNav;
import com.ximpleware.XMLModifier;
import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.sg.util.StudentBuilder.enrichStudent;

public class StudentDaoImpl extends DaoVtdImpl implements StudentDao {

    public StudentDaoImpl(String filePath) throws Exception {
        super(filePath);
    }

    @Override
    public List<Student> getAll() throws Exception {
        refreshVtd();

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

    @Override
    public Student get(int id) throws Exception {
        refreshVtd();

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

    @Override
    public void create(int id, String name, String surname, String jobTitle) throws Exception {
        String newStudentTemplate = getNewStudentTemplate(id, name, surname, jobTitle);

        AutoPilot autoPilot = new AutoPilot(vtdNav);
        autoPilot.selectElement("students");
        if (autoPilot.iterate()) {
            XMLModifier xmlModifier = new XMLModifier();
            xmlModifier.bind(vtdNav);
            xmlModifier.insertBeforeTail(newStudentTemplate);
            byteContent = toByteArray(xmlModifier);
            saveVtdToFile();
        }
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
