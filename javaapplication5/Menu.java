
package javaapplication5;
import java.util.Scanner;


public class Menu {
    public void inicio(){
        Scanner input = new Scanner(System.in);
        BaseDeDatos DataBase = new BaseDeDatos();
        DataBase.lectura();  
        /*se inicializa el metodo de "lectura" para poder poder llenar el HashMap y 
        asi poder realizar las otras acciones tales como validar si un usuario existe 
        para poderlo crear o si ya existe para poder permitir el ingreso igual.*/
        //DataBase.ingresado();---esto era para ingresar el usuario de forma manual.
        
        System.out.println("Bienvenido.");
        System.out.println("Opciones: ");
        System.out.println("1.Ingresar");
        System.out.println("2.Registrarse");
        System.out.print("Ingrese aqui: ");
        int opcion = Integer.parseInt(input.nextLine());
        
        //System.out.println(DataBase.usuarios);
        
        if(opcion == 1){
            System.out.print("Ingrese su usuario: ");
            String nombre = input.nextLine();
            System.out.println("nombre: " + nombre);
            
            System.out.print("Ingrese su contraseña: ");
            String contraseña = input.nextLine();
            System.out.println("contraseña: " + contraseña);
            
            int verificacion = DataBase.autenticacion(contraseña, nombre);
            
            switch(verificacion){
                case 0: System.out.println("Bienvenido."); break;
                case 1: System.out.println("Contraseña errada."); break;
                case 2: System.out.println("Usuario no encontrado."); break;
            }
            
            
        }else if(opcion == 2){
            System.out.println("Gracias por elegirnos!");
            System.out.print("Ingrese el nombre de usuario que desea: ");
            String nombre = input.nextLine();
            
            System.out.print("Ingrese la contraseña: ");
            String contraseña = input.nextLine();
            
            DataBase.agregarUsuario(contraseña, nombre);
            //System.out.println(DataBase.usuarios);
            
        }else{
            System.out.println("No sea tan marica.");
        }
        
        
    }
    
    
        
        
    
}
