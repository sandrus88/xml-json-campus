package org.sg.campus.dao.impl.vtd;

import com.ximpleware.NavException;
import com.ximpleware.ParseException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DaoVtdImpl {
    
    //    protected VTDNav vtdNav; //index navigator inside xml
    protected String filePath;

//    public DaoVtdImpl(byte[] byteContent) throws Exception {
//        setupVTDNav(byteContent);
//    }
    
    public DaoVtdImpl(String filePath) throws Exception {
        this.filePath = filePath;
//        this(Files.readAllBytes(Paths.get(filePath)));
    }
    
    protected VTDNav setupVTDNav() throws ParseException, IOException {
        byte[] byteContent = Files.readAllBytes(Paths.get(filePath));
        VTDGen vtdGen = new VTDGen();
        vtdGen.setDoc(byteContent);
        vtdGen.parse(false);
        return vtdGen.getNav();
    }
    
    
    protected String getVtdNavAsString(VTDNav vtdNav) throws NavException {
        return vtdNav.toString((int) vtdNav.getElementFragment(), (int) (vtdNav.getElementFragment() >> 32));
    }
    
    protected void printVtdNavAsString(VTDNav vtdNav) throws NavException {
        System.out.println(getVtdNavAsString(vtdNav));
    }
}
