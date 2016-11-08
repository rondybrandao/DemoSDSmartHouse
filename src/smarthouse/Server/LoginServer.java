/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthouse.Server;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIServerSocketFactory;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import smartHouse_implement.LoginImplement;
import form_rmi.CasaInterface;

public class LoginServer implements RMIServerSocketFactory, Serializable {
    
    public LoginServer(){
        try 
        {
           Registry reg=LocateRegistry.createRegistry(1099);
           //LoginImplement lp=new LoginImplement();
           //reg.rebind("login", lp);
           System.out.println("Servidor registrando");     
        } 
        catch (Exception ex) 
        {
        }
        try {
            CasaInterface li = new LoginImplement(1099);
            Naming.rebind("login", li);
            System.out.println("Login.Server.LoginServer.<init>()");
        } catch (Exception e) {
        }
    }
 
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        
        ServerSocketFactory factory = SSLServerSocketFactory.getDefault();
        ServerSocket socket = factory.createServerSocket(port);
        return socket;
    }
    public static void main(String[]args) {
        new LoginServer();
    }   

}
