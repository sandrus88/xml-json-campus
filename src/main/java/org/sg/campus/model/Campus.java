package org.sg.campus.model;

import java.util.List;

public class Campus {
    
    public List<Student> getStudents() {
        return studentList;
    }
    
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    
    private List<Student> studentList;
}
