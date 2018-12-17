
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Renato
 */
public class Cliente {

    public static void main(String[] args) throws NotBoundException, RemoteException, MalformedURLException {

        InterfaceContatos contatos = (InterfaceContatos) Naming.lookup("rmi://127.0.0.1/servidor");
        while (true) {

            System.out.println("Digite o valor de uma opçao: ");
            System.out.println("1 Adicionar: ");
            System.out.println("2 Remover: ");
            System.out.println("3 Listar: ");
            System.out.println("4 Atualizar: ");

            Scanner valor = new Scanner(System.in);
            int entrada = valor.nextInt();
            switch (entrada) {

            case 1:
                System.out.println("Adicionando COntato");
                Scanner add = new Scanner(System.in);

                System.out.println("Id : ");
                int attid = add.nextInt();

                System.out.println("email");
                String email = add.nextLine();

                System.out.println("nome do contato: ");
                String nome = add.nextLine();

                System.out.println("numero");
                int num = add.nextInt();

                System.out.println("adicionando contato");
                contatos.adicionar(attid,nome, num, email);
                System.out.println("Contato adicionado");
                break;

            case 2:
                Scanner remover = new Scanner(System.in);
                System.out.println("id do contato que deseja excluir: ");
                int removerContato = remover.nextInt();

                contatos.remover(removerContato);
                break;

            case 3:
                System.out.println("Listar contatos: ");

                for (Contato contato : contatos.listar()) {
                    System.out.println("Id: " + contato.getId());
                    System.out.println("Email: " + contato.getEmail());
                    System.out.println("Nome: " + contato.getNome());
                    System.out.println("Numero: " + contato.getNumero());
                    System.out.println("===========================");

                }

                break;
            case 4:
                Scanner atualizar = new Scanner(System.in);
                System.out.println("Digite o ID do contato que deseja atualizar ");
                int ctt = atualizar.nextInt();
                for (Contato contato : contatos.listar()) {

                    if (contato.getId() == ctt) {
                        System.out.println("Atualizando contato ");
                        System.out.println("Id : ");
                        int id = atualizar.nextInt();

                        System.out.println("Email : ");
                        String attEmail = atualizar.nextLine();

                        System.out.println("Nome : ");
                        String AttNome = atualizar.nextLine();
                        System.out.println("Numero : ");
                        int attNum = atualizar.nextInt();
                        contatos.atualizar(id, AttNome, attNum, attEmail);
                    }

                }
                break;

            }
        }

    }

}
