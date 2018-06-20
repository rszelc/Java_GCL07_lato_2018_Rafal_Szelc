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
class UserAddException extends ChatException {
    public UserAddException(){
        System.out.println("Uzytkownik istnieje");
    }
}
