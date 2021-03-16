package org.sg.campus.dao.impl.vtd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DaoVtdTest {
    
    private final String PATH = "src/test/resources/";
    private final String filePath = "test_campus_data.xml";
    private final String changedFilePath = "test_campus_data_backup.xml";

    private StudentDao studentDao ;
    
    @Before
    public void setUp() throws Exception {
        System.out.println("Cleaned up: restoring initial xml file");
        FileChannel src = new FileInputStream(PATH + changedFilePath).getChannel();
        FileChannel dest = new FileOutputStream(PATH + filePath).getChannel();
        dest.transferFrom(src, 0, src.size());

        studentDao = new StudentDaoImpl(PATH + filePath);
    }
    
    @After
    public void cleanUp() throws IOException {
    }
    
    @Test
    public void test_getAll() throws Exception {
        List<Student> studentList = studentDao.getAll();
        System.out.print("ALL students: " + studentList);
        assertNotNull(studentList);
    }
    
    @Test
    public void test_get() throws Exception {
        Student student = studentDao.get(101);
        System.out.print("GET student: " + student);
        assertNotNull(student);
    }
    
    @Test
    public void test_create() throws Exception {
        // Given
        final int studentId = 10001;
        
        //When
        studentDao.create(studentId, "ermal2", "aliraj2", null);
        
        //Then
        Student student = studentDao.get(studentId);
        assertNotNull(student);
        assertEquals(studentId, student.getId());
    }
}
