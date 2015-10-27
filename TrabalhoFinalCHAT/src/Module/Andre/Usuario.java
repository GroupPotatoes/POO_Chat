/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module.Andre;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author 14649826
 */
public class Usuario
{
    protected String            nick;
    protected Socket            canal;
    protected PrintWriter       mandador;
    protected BufferedReader    receptor;
    protected TratadorDeUsuario tratador;

    public Usuario (String n, Socket c, PrintWriter m, BufferedReader r, Thread t)
    {
        // validacoes
        this.nick     = n;
        this.canal    = c;
        this.mandador = m;
        this.receptor = r;
        this.tratador = (TratadorDeUsuario) t;
    }

    public void morra ()
    {
        this.tratador.pare ();
    }

    //TODO: métodos obrigatórios
}
