/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module.Andre;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author 14649826
 */
class TratadorDeUsuario extends Thread{
    protected Usuario usr;
    protected Vector<Usuario> usuarios;
    protected boolean fim = false;

    public TratadorDeUsuario (Vector<Usuario> usrs, Socket c)
    {
        //validacoes
        this.usuarios = usrs;
        PrintWriter mandador = new PrintWriter (canal.getOutputStream());
        BufferedReader receptor = new BufferedReader (new InputStreamReader (canal.getInputStream()));
        String nick = receptor.readLine();
        //construo o user
        this.usr = new Usuario (nick,c,mandador,receptor,this);
        synchronized (usr)
        {
            usuarios.add (usr);
        }
        //...
    }

    public void pare ()
    {
        // remove usr do vector usuarios
        this.fim = true;
    }

    public void run ()
    {
        while (!fim)
        {
            String remetente    = this.usr.getBR().readLine();
            String destinatario = this.usr.getBR().readLine();
            String mensagem     = this.usr.getBR().readLine();

            // se destinatario e mensagem forem "sair", acha
            // remetente no vector e chama o metodo morra
            // caso contrario, procura o destinatario no vector
            // e manda a mensagem com o nick do remetente
        }
    }
}
