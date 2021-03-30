package org.sg.campus.dao.impl.xerces;

import org.junit.Before;
import org.junit.Test;
import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.Student;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class XercesStudentDaoTest {
    
    private final String PATH = "src/test/resources/";
    private final String filePath = "test_campus_data.xml";
    
    private StudentDao studentDao;
    
    @Before
    public void setUp() {
        studentDao = new XercesStudentDaoImpl(PATH + filePath);
    }
    
    @Test
    public void test_getAll() throws Exception {
        List<Student> students = studentDao.getAll();
        System.out.println(students);
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
        System.out.println(student);
    }
    
    @Test
    public void test_count() throws Exception {
        int count = studentDao.count();
        System.out.println(count);
    }
}
