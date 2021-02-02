package org.sg.campus.dao.impl.vtd;

import com.ximpleware.NavException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DaoVtdImpl {
    
    protected VTDNav vtdNav; //index navigator inside xml
    
    public DaoVtdImpl(byte[] byteContent) throws Exception {
        VTDGen vtdGen = new VTDGen();
        vtdGen.setDoc(byteContent);
        vtdGen.parse(false);
        
        vtdNav = vtdGen.getNav();
        System.out.println(getVtdNavAsString(vtdNav));
    }
    
    public DaoVtdImpl(String filePath) throws Exception {
        this(Files.readAllBytes(Paths.get(filePath)));
    }
    
    protected String getVtdNavAsString(VTDNav vtdNav) throws NavException {
        return vtdNav.toString((int)vtdNav.getElementFragment(),(int)(vtdNav.getElementFragment() >> 32));
    }
    
    protected void printVtdNavAsString(VTDNav vtdNav) throws NavException {
        System.out.println(getVtdNavAsString(vtdNav));
    }
}
