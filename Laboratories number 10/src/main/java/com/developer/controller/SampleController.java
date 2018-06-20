/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

    private ArrayList<jsonList> images = new ArrayList<>();
    @RequestMapping("/gallery/pictures")
    @ResponseBody
    /*public JsonObject getJSON() throws JsonProcessingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonObject obj=null;
               try{
    JsonReader reader = Json.createReader(new FileReader("./src/main/resources/JSON.json"));
       obj = reader.readObject();
       
    } catch(FileNotFoundException e)
    {
        e.printStackTrace();
    } 
               return obj;
    }*/
    public Map<String, List<jsonList>>  listImages(){
        HashMap<String, List<jsonList>> itemIlist = new HashMap<>();
        
        images.add(new jsonList(1, "jeden.jpg","1280x720", 75, 1525941686));
        images.add(new jsonList(2, "asd","400x400", 28, 1525940148 ));
        itemIlist.put("pictures", images);
        return itemIlist;
    }

    

     @RequestMapping(value = "/gallery/pictures/{id}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String id) throws IOException {
 
        ClassPathResource imgFile = new ClassPathResource(id);
 
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
        
    }
    @RequestMapping(value = "/gallery/pictures/{id}", method = RequestMethod.DELETE)
    public void delete() {

    }
    

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
