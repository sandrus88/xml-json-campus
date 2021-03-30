package org.sg.campus.dao.impl.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Enumeration;
import java.util.Hashtable;

public class SaxCountElementNamesHandler extends DefaultHandler {
    
    private Hashtable tags;
    
    public void startDocument() throws SAXException {
        tags = new Hashtable();
    }
    
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        String key = localName;
        Object value = tags.get(key);
        
        if (value == null) {
            tags.put(key, new Integer(1));
        } else {
            int count = ((Integer) value).intValue();
            count++;
            tags.put(key, new Integer(count));
        }
    }
    
    
    public void endDocument() throws SAXException {
        Enumeration e = tags.keys();
        while (e.hasMoreElements()) {
            String tag = (String) e.nextElement();
            int count = ((Integer) tags.get(tag)).intValue();
            System.out.println("Local Name \"" + tag + "\" occurs " + count + " times");
        }
    }
    
    public int getCount() {
        return 0;
    }
}