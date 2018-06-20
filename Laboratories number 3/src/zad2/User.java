/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

/**
 *
 * @author rszelc
 */
public class User {
    long id;
    String name;
    long createdAt;
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public User(long id1, String name1){
        id=id1;
        name=name1;
    }
}
