package org.sg.campus.dao.impl.sax;

import org.sg.campus.dao.StudentDao;
import org.sg.campus.model.Student;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class SaxStudentDaoImpl implements StudentDao {
    
    private SaxGetAllHandler campusHandler;
    private String filePath;
    
    public SaxStudentDaoImpl(String filePath) {
        try {
            this.filePath = filePath;
            campusHandler = new SaxGetAllHandler();
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setContentHandler(campusHandler);
            parser.parse(new InputSource(new FileInputStream(new File(filePath))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Student> getAll(){
        return campusHandler.getStudents();
    }
    
    @Override
    public Student get(int id) throws Exception {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        SaxGetElementByIdHandler handler = new SaxGetElementByIdHandler(id);
        parser.setContentHandler(handler);
        parser.parse(new InputSource(new FileInputStream(new File(filePath))));
        
        return handler.getStudent();
    }
    
    @Override
    public int count() throws Exception {
        SaxCountElementNamesHandler handler = new SaxCountElementNamesHandler();
        
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(new InputSource(new FileInputStream(new File(filePath))));

//        XMLReader parser = XMLReaderFactory.createXMLReader();
//        parser.setContentHandler(handler);
//        parser.parse(new InputSource(new FileInputStream(new File(filePath))));
        
        return handler.getCount();
    }
    
    @Override
    public void create(int id, String name, String surname, String jobTitle) throws Exception {
    
    }
    
    @Override
    public void update(int id, String name, String surname, String jobTitle) {
    
    }
    
    
}