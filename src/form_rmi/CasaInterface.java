package form_rmi;

import java.rmi.*;

public interface CasaInterface extends Remote
{
 public boolean getLogin(String user, String pass ) throws RemoteException;
 
 public String getConsumoLuz() throws RemoteException;
 
 public boolean interruptor(boolean interruptor) throws RemoteException;
    
}
