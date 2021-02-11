
package javaapplication5;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class JavaApplication5 {
    public static void main(String[] args) {
        HashMap<String, List<String>> usuarios = new HashMap<String, List<String>>();
        System.out.print("Ingrese su nombre de usuario: ");
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        
        System.out.print("Ingrese su clave: ");
        String clave =input.nextLine();
        
        List<String> santi = Arrays.asList("1234", "A");
        usuarios.put("Santi", santi);
        /*System.out.println(usuarios.get("Santi"));*/
        
        if(usuarios.keySet().contains(username)){
            System.out.println(usuarios.get(username).get(0));
            System.out.println("clave: " + clave);
            
            if(usuarios.get(username).get(0).equals(clave)){
                System.out.println("Bienvenido.");
                
            }else{
                System.out.println("Contraseña incorrecta.");
            }
        }else
            System.out.println("Usuario no encontrado.");
        
        HashMap<String, List<String>> propiedades = new HashMap<String, List<String>>();
        
        List<String> santiPropiedades = Arrays.asList("Laureles", "310.000.000");
        propiedades.put("1234", santiPropiedades);
        
        System.out.println(propiedades.get("1234"));
        

    }
    
}
