package org.sg.campus.dao.impl.sax;

import org.junit.Before;
import org.junit.Test;
import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.Student;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FullCampusHandlerTest {
    
    private final String PATH = "src/test/resources/";
    private final String filePath = "test_campus_data.xml";
    
    private StudentDao studentDao = new SaxFullCampusDaoImpl(PATH + filePath);
    
    @Before
    public void setUp() throws Exception {

    }
    
    @Test
    public void test_parseDocument() throws Exception {
        List<Student> students = studentDao.getAll();
        assertNotNull(students);
        assertEquals(2, students.size());
        
        Student studentOne = students.get(0);
        assertEquals(101, studentOne.getId());
        assertEquals("Sandro", studentOne.getName());
        assertEquals("Gargano", studentOne.getSurname());
        assertEquals("Waiter", studentOne.getJobTitle());
        assertEquals("NOTOK", studentOne.getPaymentType().name());
    }
    
    @Test
    public void test_get() throws Exception {
        Student student = studentDao.get(101);
        assertEquals(101, student.getId());
        assertEquals("Sandro", student.getName());
        assertEquals("Gargano", student.getSurname());
        assertEquals("Waiter", student.getJobTitle());
        assertEquals("NOTOK", student.getPaymentType().name());
    }
    
}
