package org.sg.campus.dao.impl.vtd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.Student;
import org.sg.util.SGUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DaoVtdTest {
    
    final String filePath = "./test/resources/test_campus_data.xml";
    final String changedFilePath = "./test/resources/test_campus_data_backup.xml";
    
    @Before
    public void setUp(){
//        System.out.println("Set up");
    }
    
    @After
    public void cleanUp() throws IOException {
        System.out.println("Cleaned up: restoring initial xml file");
        FileChannel src = new FileInputStream(changedFilePath).getChannel();
        FileChannel dest = new FileOutputStream(filePath).getChannel();
        dest.transferFrom(src, 0, src.size());
    }
    
    @Test
    public void test_getAll() throws Exception {
        StudentDao dao = new StudentDaoImpl(filePath);
        List<Student> studentList = dao.getAll();
        SGUtil.printList(studentList);
        assertNotNull(studentList);
    }
    
    @Test
    public void test_get() throws Exception {
        StudentDao dao = new StudentDaoImpl(filePath);
        Student student = dao.get(101);
        System.out.print(student);
        assertNotNull(student);
    }
    
    @Test
    public void test_create() throws Exception {
        // Given
        final int studentId = 10001;
        StudentDao dao = new StudentDaoImpl(filePath);
        
        //When
        dao.create(studentId, "ermal2", "aliraj2", null);
        
        //Then
        Student student = dao.get(studentId);
        assertNotNull(student);
        assertEquals(studentId, student.getId());
    }
}
