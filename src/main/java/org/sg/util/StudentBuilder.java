package org.sg.util;

import org.sg.campus.model.PaymentType;
import org.sg.campus.model.Student;

public class StudentBuilder {

    public static void enrichStudent(Student dto, String nodeName, String nodeContent) {
        if (nodeName.equals("name")) {
            dto.setName(nodeContent);
        } else if (nodeName.equals("surname")) {
            dto.setSurname(nodeContent);
        } else if (nodeName.equals("jobTitle")) {
            dto.setJobTitle(nodeContent);
        } else if (nodeName.equals("paymentType")) {
            dto.setPaymentType(PaymentType.valueOf(nodeContent));
        }
    }
}
