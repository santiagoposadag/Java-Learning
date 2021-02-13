import java.net.*;  
import java.io.*;  
class MyServerPrueba{  
public static void main(String args[])throws Exception{  
ServerSocket ss=new ServerSocket(3333);  
Socket s=ss.accept();  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2="", usertype="", username = "", passw=""; 
dout.writeUTF("Bienvenido a nuestro servicio de bienes raices");
dout.flush();
dout.writeUTF("Desea ingresar como administrador o como usuario?(A/U)");
usertype = din.readUTF();
if(usertype.equals("A")){
    dout.writeUTF("Ingrese su nombre de usuario: ");
    username = din.readUTF();
    dout.writeUTF("Ingrese su contraseña: ");
    passw = din.readUTF();
    dout.writeUTF("Bienvenido: " + username);
}

//while (!str.equals("stop")) {
//    str = din.readUTF();
//    System.out.println("client says: " + str);
//    str2 = br.readLine();
//    dout.writeUTF(str2);
//    dout.flush();
//}
din.close();  
s.close();  
ss.close();  
}} 