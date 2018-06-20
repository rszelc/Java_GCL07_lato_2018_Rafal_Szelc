/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import static java.util.stream.StreamSupport.stream;

/**
 *
 * @author Rafał
 */
public class Files {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Files A = new Files();
        SystemCache cache = new SystemCache();
        ExtendedSystemCache ex = new ExtendedSystemCache();
        double[] input = {2.0,3.0,4.0};
        ex.put(input, 2.0);
        
        ex.exportCSV("dane.csv");
        ex.importCSV("dane2.csv");
        ex.exportCSV("dane3.csv");
        ex.serialize("objects.bin");
        ex.deserialize("objects.bin");
        ex.exportCSV("dane5.csv");
        
    }
    
}