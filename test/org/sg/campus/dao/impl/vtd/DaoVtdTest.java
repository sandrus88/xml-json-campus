package org.sg.campus.dao.impl.vtd;

import org.junit.jupiter.api.Test;
import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;
import org.sg.util.SGUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DaoVtdTest {
    
    @Test
    public void test_getAll() throws Exception {
        StudentDao dao = new StudentDaoImpl("./xml/campus_list.xml");
        List<Student> studentList = dao.getAll();
        SGUtil.printList(studentList);
        assertNotNull(studentList);
    }
    
    @Test
    public void test_get() throws Exception {
        StudentDao dao = new StudentDaoImpl("./xml/campus_list.xml");
        Student student = dao.get(101);
        System.out.print(student);
        assertNotNull(student);
    }
    
    @Test
    public void test_create() throws Exception {
        // Given
        final int studentId = 201;
        StudentDao dao = new StudentDaoImpl("./xml/campus_list.xml");
        
        //When
        dao.create(studentId, "ermal2", "aliraj2", null);
    
        //Then
        Student student = dao.get(studentId);
        System.out.print(student);
        assertNotNull(student);
        assertEquals(studentId, student.getId());
    }
}
