/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renato
 */
public interface InterfaceContatos extends Remote {

    public void adicionar(int id, String nome, int numero, String email) throws RemoteException;

    public void remover(int id) throws RemoteException;

    public List<Contato> listar() throws RemoteException;

    public void atualizar(int id, String nome, int numero, String email) throws RemoteException;
}
