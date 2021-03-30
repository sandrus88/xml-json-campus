package org.sg.campus.dao.impl.stax;

import org.sg.campus.model.Campus;
import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class StAXHandler extends DefaultHandler {
    
    private static final String STUDENTS = "students";
    private static final String STUDENT = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String JOB_TITLE = "jobTitle";
    private static final String PAYMENT_TYPE = "paymentType";
    
   
}