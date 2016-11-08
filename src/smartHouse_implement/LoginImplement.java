/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartHouse_implement;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import form_rmi.CasaInterface;
public class LoginImplement extends UnicastRemoteObject implements CasaInterface
{

    public LoginImplement(int port)throws RemoteException{
        super(port);
    }
    public boolean getLogin(String user, String pass) throws RemoteException 
    {
        boolean found=false;
        try 
        {
            if(user.equals("admin") && pass.equals("123"))
                return found=true;
            else
                return found=false;
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return found;
        
    }

    @Override
    public String getConsumoLuz() throws RemoteException {
        String consumoLampada = "100kw/h";
        
        return consumoLampada;
    }

    @Override
    public boolean interruptor(boolean interruptor) throws RemoteException {
        boolean i = false;
        if(interruptor == true){
            return i = true;
        }else
            return i = false;
    }
}
