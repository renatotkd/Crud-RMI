/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the tem
plate in the editor.
 */


import java.net.MalformedURLException;
import java.rmi.*;

/**
 *
 * @author Renato
 */
public class Servidor {
    
    public static void main(String[] args) throws MalformedURLException {
        try {
            ImplementaContatos contatos = new ImplementaContatos();
            
            Naming.rebind("servidor", contatos);
        } catch (RemoteException ex) {
            System.out.println("erro do servidor: " + ex.getMessage());
    }} 
}
