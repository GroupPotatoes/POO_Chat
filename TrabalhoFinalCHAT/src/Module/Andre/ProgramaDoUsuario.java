package Module.Andre;

import View.TelaPrincipal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author 14649826
 */
public class ProgramaDoUsuario
{
    protected Socket canal;
    protected PrintWriter mandador;
    protected BufferedReader receptor;
    protected String nick;//, ip;
    private int porta;
    
    
    public void executaPrograma(TelaPrincipal janela) throws IOException
    {
        
        // tomando a iniciativa de comunicar-se com outro programa...
//        Socket canal = new Socket (endereco,porta); // endereco pode ser ip ou nome
         this.canal = new Socket ("172.16.12.12", porta);
//         Socket canal = new Socket ("fs5", 10000);
        this.mandador = new PrintWriter (canal.getOutputStream());
        this.receptor = new BufferedReader (new InputStreamReader (canal.getInputStream()));
        // para mandar dados nao textuais, em vez de PrintWriter, declare DataOutputStream
        // para receber dados nao textuais, em vez de BufferedReader, declare DataInputStream

        //looping infinito
        for(;;)
        {
            String remetente = receptor.readLine ();
            String mensagem  = receptor.readLine ();

            janela.novaConversa(remetente,mensagem);
        }
    }

    public void setPorta(int porta) throws Exception{
        if(porta<1||porta>10000)
            this.porta = porta;
        else
            throw new Exception("porta inválida!");
    }
    
}
