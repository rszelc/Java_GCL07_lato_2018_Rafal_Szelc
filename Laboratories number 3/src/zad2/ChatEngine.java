/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author rszelc
 */
public class ChatEngine {
    HashMap<Long,User> mapa =new HashMap<>();
    long id;
    Set<String> names = new TreeSet<>();
    void addUser(User user) throws UserAddException{
        if(hasUser(user.getId()) == false && hasName(user.getName())==false){
            mapa.put(id, user);
            id++;
        }
        else{
            throw new UserAddException();
        }
        
        
    }
    void removeUser(long userid) throws UserRemoveException{
        if(hasUser(userid) == true){
            mapa.remove(id);
        }
        else{
            throw new UserRemoveException();
        }
    }
    int getNumerOfUsers(){
        return mapa.size();
    }
    void createBan(String userName){
        names.add(userName);
        if(hasUser(userName)==true){
            mapa.remove(userName);
        }
        
    }
    void removeBan(String userName){
        names.remove(userName);
        
    }
    boolean hasUser(long userid){
        boolean isThereUser = mapa.containsKey(userid);
        return isThereUser;
    }
    boolean hasUser(String userName){
        boolean isThereUser = mapa.containsValue(userName);
        return isThereUser;
    }
    boolean hasName(String userName){
        boolean isThereUser = names.contains(userName);
        return isThereUser;
    }

   
}
