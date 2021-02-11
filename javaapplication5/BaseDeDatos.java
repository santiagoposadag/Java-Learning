
package javaapplication5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.io.FileWriter;  
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;//estos son todas las librerias que estamos usando en esta clase.


public class BaseDeDatos {
    HashMap<String, List<String>> usuarios = new HashMap<String, List<String>>();
    
   
    HashMap<String, List<String>> propiedades = new HashMap<String, List<String>>();  
    
    /*estos son los atributos de la clase, dos directorios, 
    uno para los usuarios y las contraseñas y otro para las propiedades.
    continenen como primer elemento o clave del Hash map un String y 
    como contenido una lista de dos elementos.*/
    
    
    public void lectura(){
        try {
            File LecturaArchivo = new File("C:\\Users\\Santiago Posada\\Desktop\\Pagina Web\\JavaApplication5\\src\\javaapplication5\\usuariosDB.txt"); //por medio de la libreria File vamos a acceder al archivo .txt.
            Scanner myReader = new Scanner(LecturaArchivo); //Vamos a crear un objeto de tipo Scanner que en vez de tomar la informacion del input del teclado, la va a tomar del archivo .Txt.
            while(myReader.hasNextLine()) {  //aqui la condicion indica que siempre  cuando el scanner tenga una linea mas que leer entonces ejecute lo sig.
                String data = myReader.nextLine(); //cada linea va a ser ingresada a la variable "data", como un string.
                System.out.println(data);
                
                String[] arrOfStr = data.split(", "); //creamos un arreglo de tipo string conformado por dos columnas las cuales van a ser lo extraido por data, separando por medio de la ",".
                List<String> datosContraseña = Arrays.asList(arrOfStr[1], "A");  //vamos a llenar el segundo campo del HashMap compuesto por una lista, el primer elemento con el segundo elemento del arreglo anterios y el segundo con una constante que indica los permisos.
                usuarios.put(arrOfStr[0], datosContraseña); //y aqui vamos a ingresar la informacion al HashMap, tanto el elemento String con el primer elemento extraido del arreglo, como el segundo elemento que es la lista anterios.
                
                System.out.println(usuarios); //y aqui se imprimer solo por verificacion.
                
                /*for (String a : arrOfStr) 
                System.out.println(a);
                List<String> datosContraseña = Arrays.asList(contraseña, "A");
                usuarios.put(nombre, datosContraseña);*/
                
                
            }
        myReader.close();
        } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        } 
        /*Este elemento try nos permite hacer el intento de realizar una accion, 
        sin que esto significa la imposibilidad de seguir realizando la accion completa. */
    }
    
    public boolean agregarUsuario(String contraseña, String nombre){
        if(usuarios.keySet().contains(nombre)){
            return false;
        }else{
            List<String> datosContraseña = Arrays.asList(contraseña, "A");
            usuarios.put(nombre, datosContraseña);
            try {
                File myWriter_1 = new File("C:\\Users\\Santiago Posada\\Desktop\\Pagina Web\\JavaApplication5\\src\\javaapplication5\\usuariosDB.txt");
                FileWriter myWriter = new FileWriter(myWriter_1, true);
                myWriter.write(nombre + ", " + contraseña + "\n");
                myWriter.close();
                
                
                /*Aqui que hicimos:
                1-accedimos al archivo creando un objeto de tipo file llamada myWrite
                2-creamos un objeto de tipo FileWriter llamado myWriter que escribe en archivo myWrite_1, 
                  ademas de poner la convencion "true" para que no sobre escriba sino que haga una nueva linea.
                3-con el objeto myWrite, usando el metodo "write" ingresamos la informacion que deseamos
                cerramos el objeto myWriter.*/
                
                
                System.out.println("Successfully wrote to the file.");
            }catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return true;
        }
    }
    
    public int autenticacion(String contraseña, String nombre){
        if(usuarios.keySet().contains(nombre)){
            
            if(usuarios.get(nombre).get(0).equals(contraseña)){
                //0 significa que el usurio coincide y la contraseña tambien
                return 0;
            }else{
                //1 solo la contraseña es incorrecta
                return 1;
            }
        }else
            //2 no esta el usurio.
            return 2;
    }
    
    /*public void ingresado() {
        List<String> Santi = Arrays.asList("12345", "A");
        usuarios.put("Santi", Santi); 
        
    } */
    
    
}
