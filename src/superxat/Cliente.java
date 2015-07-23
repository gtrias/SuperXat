/*
 * Cliente.java
 *
 * Created on 14 de abril de 2008, 12:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package superxat;
import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author genar
 */
public class Cliente implements Runnable{
    private Socket socket;
    public DataInputStream entrada;
    public DataOutputStream salida;
    private static ArrayList clientes=new ArrayList();
    private String mensaje;
    
/** Constructor: Se pasa un socket obtenido del servidor en el constructor. Se crean los flujos de entrada y de salida.
 * Se añade el objeto creado al array clientes y finalmente se ejecutan los hilos. */
    
    Cliente(Socket sock){
        this.socket = sock;
        try{
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            System.out.println("Los flujos se han creado correctamente");
        }catch(IOException e){
            System.out.println("Error a la hora de crear los flujos");
        }
        clientes.add(this);
        (new Thread(this)).start();
    }
    
/** Ejecucion del hilo: Hasta que termine el programa esta leyendo para cada objeto el flujo de entrada. 
 * Cuando recibe un mensaje se lo pasa al metodo broadcast() */
    
    @Override
    public void run(){
        try{
            while(true){
                String mens = entrada.readUTF();
                System.out.println("se ha recibido: "+mens);
                mensaje = "";
                mensaje = mens;
                broadcast(mens);
            }
        }catch(IOException e){
            
        }
    }
         
/** Devuelve el valor de la variable mensaje   */
    
    public String obtenerMensaje(){
        return(mensaje);
    }
    
/** Metodo que se encarga de mandar el texto que se le pase a todos los clientes de la array clientes */
    
    public void broadcast(String mensaje){
        for(int i=0; i< clientes.size(); i++){
            Cliente c =(Cliente) clientes.get(i);
            try{
                c.salida.writeUTF(mensaje);
                c.salida.flush();
            }catch(IOException e){
                System.out.println("Error a la hora de escribir el mensaje en output stream");
            }

        }
    }
}
