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
public class Zad2 {

    /**
     * @param args the command line arguments
     * @throws zad2.UserAddException
     */
    public static void main(String[] args) throws UserAddException {
        int id=0;
        User B=new User(++id, "Wiesiek");
        ChatEngine A = new ChatEngine();
        
        //A.createBan("Wiesiek");
        A.addUser(B);
        System.out.println("Is there Wiesiek? " + A.hasUser(0));
        
    }
    
}
