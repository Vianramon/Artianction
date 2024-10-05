/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATOS;

import java.security.Security;

/**
 *
 * @author vramirez
 */
public class Password {
    
    public enum Security {
        debil, medio, fuerte
        
    }
    public static Security clave(String Password){
    
        if (Password.length()<5){
        return Security.debil; 
            
}
        if (Password.matches("[a-zA-Z]+")){
            return Security.debil;
        }
        
        if (Password.matches("[a-zA-Z0-9]+")){
            return Security.medio;
        }
        
        return Security.fuerte;
        
 }
     }