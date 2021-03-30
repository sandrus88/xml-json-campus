package org.sg.campus.dao.impl.vtd;

import com.ximpleware.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VtdDaoImpl {

    protected VTDNav vtdNav; // index navigator inside xml
    protected Path filePath; // path to physical file
    protected byte[] byteContent; // xml bytes. Letting as instance variable for development putpose

//    public VtdDaoImpl(byte[] byteContent) throws Exception {
//        this.byteContent = byteContent;
//        vtdNav = setupVTDNav(byteContent);
//    }

    public VtdDaoImpl(String filePathString) throws Exception {
        try {
            filePath = Paths.get(filePathString);
            byteContent = Files.readAllBytes(filePath);
            vtdNav = setupVTDNav(byteContent);
        } catch (NoSuchFileException e) {
            throw new IllegalStateException("No file present in filePath: " + filePath + "; absolute path: " + (filePath != null ? filePath.toAbsolutePath() : ""));
        }
    }

    protected VTDNav setupVTDNav(byte[] byteContent) throws ParseException {
        VTDGen vtdGen = new VTDGen();
        vtdGen.setDoc(byteContent);
        vtdGen.parse(false);
        return vtdGen.getNav();
    }

    protected void refreshVtd() throws Exception {
        byteContent = Files.readAllBytes(filePath);
        vtdNav = setupVTDNav(byteContent);
    }

    protected void saveVtdToFile() throws Exception {
        Files.write(filePath, byteContent);
    }

    protected String getVtdNavAsString(VTDNav vtdNav) throws NavException {
        return vtdNav.toString((int) vtdNav.getElementFragment(), (int) (vtdNav.getElementFragment() >> 32));
    }

    protected void printVtdNavAsString(VTDNav vtdNav) throws NavException {
        System.out.println(getVtdNavAsString(vtdNav));
    }

    protected String getValue(VTDNav vtdNav) throws Exception {
        return new String(vtdNav.getXML().getBytes((int) vtdNav.getContentFragment(), (int) (vtdNav.getContentFragment() >> 32)));
    }

    public static int getAttributeId(VTDNav vtdNav) throws NavException {
        int originAttrIndex = vtdNav.getAttrVal("id");// trova indice dell'attributo id
        String attrVal = vtdNav.toString(originAttrIndex);// prende il valore
        return Integer.parseInt(attrVal);
    }

    static byte[] toByteArray(XMLModifier xmlModifier) throws ModifyException, TranscodeException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        xmlModifier.output(baos);
        return baos.toByteArray();
    }

}
