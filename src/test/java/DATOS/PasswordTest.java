/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DATOS;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vramirez
 */
public class PasswordTest {
   
@Test
    public void debil_when_has_less_than_5_letters() {
        Assertions.assertEquals(Password.Security.debil,Password.clave("1234"));
        
    }
    
  
    @Test
    public void debil_when_has_less_only_letters() {
        Assertions.assertEquals(Password.Security.debil,Password.clave("desarrollodesoftware"));
        
    }
    
    @Test
    public void medio_when_has_less_numbers_letters() {
        Assertions.assertEquals(Password.Security.medio,Password.clave("ficha2758268"));
        
    }
    
     @Test
    public void fuerte_when_has_less_numbers_letters_symbols() {
        Assertions.assertEquals(Password.Security.fuerte,Password.clave("sena2024*"));
        
    }
}
