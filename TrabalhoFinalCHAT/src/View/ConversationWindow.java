package View;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Janela das conversas.
 *
 * @author Mandinha Zika Trevosa
 */
public class ConversationWindow extends javax.swing.JFrame {

    protected ArrayList<JTextField> listaConversas;
    private static int qtdChats = 0;

    /**
     * Construtor da classe - para uma conversa.
     */
    public ConversationWindow(int qtd, String[] contatos, String mensagem) {
        initComponents();
        this.inicializaLista();
        this.setLocationRelativeTo(null); 
        adicionaConversa(qtd, contatos, mensagem);
        //bloqueando o resinzing do form
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpConversas = new javax.swing.JTabbedPane();
        txtMsg = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnFecharConversa = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtMsg.setText("Digite sua mensagem aqui...");

        btnEnviar.setText("Enviar");

        btnFecharConversa.setText("Fechar Conversa");
        btnFecharConversa.setFocusable(false);
        btnFecharConversa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFecharConversa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFecharConversa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharConversaActionPerformed(evt);
            }
        });

        lblTitulo.setText(":: Tela de Conversas ::");

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
                        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFecharConversa)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFecharConversa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
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

    /**
     * Evento de fechamento do formulario.
     *
     * @param evt Evento.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //fechando todas as conversas
        while(qtdChats>0){
            this.fechaConversa(qtdChats-1);
        }
        this.dispose(); //minimizar
    }//GEN-LAST:event_formWindowClosing

    /**
     * Evento do botão que fecha as janelas.
     * @param evt Evento do botão.
     */
    private void btnFecharConversaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharConversaActionPerformed
        this.fechaConversa(this.tbpConversas.getSelectedIndex());
        //decremento a quantidade de chats que tenho e verifico se está zerado
        if(qtdChats==0){
            this.dispose();
        }
    }//GEN-LAST:event_btnFecharConversaActionPerformed

    /**
     * Adiciona n conversas ao chat.
     *
     * @param qtd Quantidade de conversas.
     * @param contatos Contatos que serão adicionados.
     * @param mensagem Mensagem a ser enviada.
     */
    public void adicionaConversa(int qtd, String[] contatos, String mensagem) {
        for (int i = 0; i < qtd; i++) {
            this.adicionaConversa(contatos[i], mensagem);
        }
    }

    /**
     * Adiciona uma conversa.
     *
     * @param contato Contato da conversa a ser adicionado.
     * @param mensagem Mensagem a ser enviada.
     */
    protected void adicionaConversa(String contato, String mensagem) {
        //Se a conversa com o contato não existir
        if(!this.existeContato(contato)){
            //adiciona à lista de conversas a janela contendo o contato
            this.listaConversas.add(this.criaJanelaConversa(contato, mensagem));
            //adiciono ao TabbelPane o título da janela e o jList que acabei de adicionar
            this.tbpConversas.add(contato, this.listaConversas.get(qtdChats));
            qtdChats++;
        }else{
            //Mensagem de erro
            JOptionPane.showMessageDialog(null, "Vish... Esqueceu que já está conversando com essa pessoa?", 
                    "Você já está falando com "+contato+" :(", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Inicializa arrayList de conversas.
     */
    protected void inicializaLista() {
        this.listaConversas = new ArrayList<JTextField>();
    }

    /**
     * Cria um JTextField uma conversa.
     *
     * @param contato Nome do contato.
     * @param mensagem Mensagem a ser enviada.
     * @return conversa JTextField contendo as informaçoes da conversa.
     */
    protected JTextField criaJanelaConversa(String contato, String mensagem) {
        JTextField conversa = new JTextField();
        //cabeçalho e texto da conversa
        conversa.setText(this.textoConversa(contato)+
                //se mensagem não for nula, adiciono... Senão, envio uma string vazia
                (mensagem!=null?("\n"+contato+": "+mensagem):""));
        conversa.setHorizontalAlignment(SwingConstants.LEFT);
        return conversa;
    }
    
    /**
     * Retorna o texto inicial de uma conversa.
     *
     * @param contato Nome do contato
     * @return String modificada de acordo con o contato.
     */
    protected String textoConversa(String contato) {
        return "########## " + contato + "##########";
    }

    /**
     * Verifica se contato existe dentro da lista de conversas.
     * @param contato
     *          Contato a ser buscado.
     * @return Existência (true) ou não (false) do contato na lista.
     */
    protected boolean existeContato(String contato) {
        for(int i=0;i<qtdChats;i++){
            //Se na lista de JTextFields, no índice determinado, existir a String com esse contato
            if (this.listaConversas.get(i).getText().contains(contato)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Fecha a aba no JOptionPane de acordo com o id enviado.
     * @param id 
     *          Id da aba.
     */
    protected void fechaConversa(int id){
        this.tbpConversas.remove(id);
        this.listaConversas.remove(id);
        qtdChats--;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnFecharConversa;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTabbedPane tbpConversas;
    private javax.swing.JTextField txtMsg;
    // End of variables declaration//GEN-END:variables

}
