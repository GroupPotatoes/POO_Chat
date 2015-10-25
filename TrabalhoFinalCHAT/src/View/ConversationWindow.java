/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Janela das conversas.
 * @author Mandinha Zika Trevosa
 */
public class ConversationWindow extends javax.swing.JFrame {
    protected ArrayList<JTextField> listaConversas;
    private static int qtdChats=0;
    
    /**
     * Construtor da classe - para uma conversa.
     */
    public ConversationWindow(int qtd, String[] contatos) {
        initComponents();
        this.inicializaLista();
        adicionaConversa(qtd, contatos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpConversas = new javax.swing.JTabbedPane();
        txtMsg = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnAdicionarConversa = new javax.swing.JButton();
        btnDesconectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMsg.setText("Digite sua mensagem aqui...");

        btnEnviar.setText("Enviar");

        btnAdicionarConversa.setText("Adicionar Conversa");
        btnAdicionarConversa.setFocusable(false);
        btnAdicionarConversa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdicionarConversa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnDesconectar.setText("Desconectar");
        btnDesconectar.setFocusable(false);
        btnDesconectar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDesconectar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbpConversas)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionarConversa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDesconectar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarConversa)
                    .addComponent(btnDesconectar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbpConversas, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void adicionaConversa(int qtd, String[] contatos){
        for(int i=0;i<qtd;i++){
            this.adicionaConversa(contatos[i]);
        }
    }
    
    /**
     *Adiciona uma conversa.
     * @param contato 
     *          Contato da conversa a ser adicionado.
     */
    protected void adicionaConversa(String contato){
        if(!this.listaConversas.contains(contato)){ //se a janela de chat com o contato nao tiver ido inicializada
            this.listaConversas.add(this.criaJanelaConversa(contato));
            this.tbpConversas.add(contato, this.listaConversas.get(qtdChats-1));
        }
    }
    
    protected void inicializaLista(){
        this.listaConversas=new ArrayList<JTextField>();
    }
    
    /**
     * Cria um JTextField uma conversa.
     * @param contato 
     *          Nome do contato.
     * @return conversa
     *          JTextField contendo as informaçoes da conversa.
     */
    private JTextField criaJanelaConversa(String contato){
        JTextField conversa = new JTextField();
        conversa.setText(this.textoConversa(contato));
        qtdChats++;
        return conversa;
    }
    
    //TODO: Criar click do botao para remover contato selecionado
    //TODO: Modelar clicks dos botoes
    
    
    /**
     * Retorna o texto inicial de uma conversa.
     * @param contato
     *          Nome do contato
     * @return String modificada de acordo con o contato.
     */
    protected String textoConversa(String contato){
        return "########## "+contato+"##########";
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarConversa;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JTabbedPane tbpConversas;
    private javax.swing.JTextField txtMsg;
    // End of variables declaration//GEN-END:variables
}
