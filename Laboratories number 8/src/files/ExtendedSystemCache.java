/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafał
 */
public class ExtendedSystemCache extends SystemCache implements Serializable{
    public void exportCSV(String path) throws IOException
    {  
        OutputStream stream = null;
        try {
            stream = new FileOutputStream(path);
            exportCSV(stream);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
        } 
        stream.close();
    }
    public void exportCSV(OutputStream stream) throws IOException
    {
        if(stream == null){
            System.out.println("File not found");
            return;
        }
        for (HashMap.Entry<Parameter, Double> entry : this.cache.entrySet()) {
            Parameter key = entry.getKey();
            double[] values = key.getValues();
            Double value = entry.getValue();
            stream.write((value.toString()+",").getBytes());
            for(int i=0; i<values.length;i++){
                stream.write((Double.toString(values[i])+",").getBytes());
            }
            stream.write("\n".getBytes());
        }     
    }


    public void importCSV(String path) throws IOException 
    { 
        InputStream stream = null;
        try {
            stream = new FileInputStream(path);
            importCSV(stream);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
        }
        stream.close();
    }

    public void importCSV(InputStream stream ) throws IOException{
        if(stream == null){
            System.out.println("File not found");
            return;
        }
        BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
        while(reader.ready())
        {
             String line = reader.readLine();
             String[] parts = line.split(",");
             
             double parametrs[] = new double[parts.length-1];
             for(int i=1;i<parts.length;i++){
                 parametrs[i-1] = Double.parseDouble(parts[i]);
             }
             this.put(parametrs, Double.parseDouble(parts[0]));
        }    
    }
    public void serialize(String path) throws IOException
    {       
        OutputStream stream = null;
        try {
            stream = new FileOutputStream(path);
            serialize(stream);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
        } 
        stream.close();
    }
    public void serialize (OutputStream stream) throws IOException
    {
        if(stream == null){
            System.out.println("File not found");
            return;
         }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)) {
            objectOutputStream.writeObject(getCache()); 
            objectOutputStream.close();
        }
    }
    public void deserialize(String path) throws IOException
    { 
        InputStream stream = null;
        try {
            stream = new FileInputStream(path);
            deserialize(stream);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("file not found");
        } 
        stream.close();
    }
    public void deserialize(InputStream stream) throws IOException{
         if(stream == null){
            System.out.println("file not found");
            return;
         }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(stream);
            setCache((HashMap<Parameter, Double>) objectInputStream.readObject());
                    
        } 
        catch (ClassNotFoundException ex) {         
            System.out.println("file not found");
        }               
         objectInputStream.close();
    }
    
    
}
