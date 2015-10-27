/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module.Andre;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author 14649826
 */
public class ServidorDeChat {
     public static void main (String[] args)
    {
        //...
        //tornando-se receptivo a comunicacao
        Vector<Usuario> usuarios = new Vector<Usuario>();
        ServerSocket conexoes = new ServerSocket (porta);
        //ServerSocket conexoes = new ServerSocket (10000);
        for(;;)
        {
            Socket canal = conexoes.accept();
            TratadorDeUsuario tratador = new TratadorDeUsuario(usuarios, canal);
            tratador.start();
        }
    }
}
