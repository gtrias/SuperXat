/*
 * Servidor.java
 *
 * Created on 14 de abril de 2008, 10:53
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

/** Constructor: Crea el socket servidor para el puerto definido por la variable "puerto",
 *  ejecuta los hilos de la clase */

public class Servidor implements Runnable{
    private ServerSocket sServidor;
    Servidor(int puerto){
        try{
            sServidor = new ServerSocket(puerto);
            System.out.println("El servidor ha arrancado correctamente en el puerto: "+String.valueOf(puerto));
            new Thread(this).start();
        }catch(IOException e){
            System.out.println("Error a la hora de crear el servidor");
        }
    }
    
/** Escucha las peticiones entrantes, crea un socket cuando se acepta una conexion y crea un objeto Cliente pasandole el socket creado */
    
    public void aceptarConexion(){
        try{
            System.out.println("Esperando conexiones");
            Socket s = sServidor.accept();
            new Cliente(s);
        }catch(IOException e){
            System.out.println("Ha ocurrido un error al intentar aceptar una peticion");
        }
    }
    
/** Acepta conexiones hasta que termine la ejecucion del programa  */
    
    @Override
    public void run(){
        while(true){
            aceptarConexion();
        }
    }
    
}
