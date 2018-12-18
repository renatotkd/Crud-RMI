
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Renato
 */
public class ImplementaContatos extends UnicastRemoteObject implements InterfaceContatos {

    List<Contato> contatos = new ArrayList<Contato>();

    public ImplementaContatos() throws RemoteException {
        System.out.println("Servidor Instanciado");
    }

    @Override
    public void adicionar(int id, String nome, int numero, String email) throws RemoteException {
        Contato novoContato = new Contato(id, nome, numero, email);
        contatos.add(novoContato);
    }

    @Override
    public void remover(int id) throws RemoteException {
        for (Contato contato : this.contatos) {
            if (contato.getId() == id) {
                if(contatos.size()== 1){
                    contatos = null;
                    System.out.println("Contato excluido");
                } else if(contatos.size()> 1){
                    contatos.remove(contato);
                    System.out.println("Contato excluido");

                } else {
                    System.out.println("O contato nao foi encontrado");
                }
               
                
                
                
            
        }

    }}
    /**
     *
     * @return @throws RemoteException
     */
    @Override
    public List<Contato> listar() throws RemoteException {
        return contatos;
    }

    @Override
    public void atualizar(int id, String nome, int numero, String email) throws RemoteException {
        for (Contato contato : this.contatos) {
            if (contato.getId() == id) {
                contato.setEmail(email);
                contato.setId(id);
                contato.setNome(nome);
                contato.setNumero(numero);
                System.out.println("Contato atualizado");
            } else {
                System.out.println("Contato nao foi encontrado.");
            }
        }

    }

}
