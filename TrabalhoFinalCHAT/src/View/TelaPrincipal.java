package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe da janela principal do chat.
 * @author Maiara Rodrigues
 */
public class TelaPrincipal extends javax.swing.JFrame { 
	
    private int selecao=0; //quantidade de contatos selecionados
    private ConversationWindow conversationWindow;
    private DefaultListModel contatosModel; //Lista de contatos que terei no meu JList
    //TODO: depois de ter o controle de quem entra/sai do chat, esse cara de cima precisara ser setado
    //muitas vezes, para depois setar o model da list 
    //EX: jList1.setModel(DefaultListModel);
	
    /**
     * Construtor da classe.
     */
    public TelaPrincipal(String nome) {
        initComponents();
        this.inicializa();
        this.setLocationRelativeTo(null); 
        this.lstContatos.addMouseListener(this.iniciaChat()); 
        this.btnMensagemMultipla.setVisible(false);
        this.txtMensagemMultipla.setVisible(false);
        this.lstContatos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selecao = lstContatos.getSelectedIndices().length;
				if(selecao>1){ //se mais de um contato for adicionado
					btnSelecao.setText("Iniciar conversa");
                                        btnMensagemMultipla.setVisible(true);
                                        txtMensagemMultipla.setVisible(true);
				}
				else{
                                    btnSelecao.setText("Selecionar Todos");
                                    btnMensagemMultipla.setVisible(false);
                                    txtMensagemMultipla.setVisible(false);
			    }
			}        	
        });
        this.lbNick.setText(this.lbNick.getText()+nome.toUpperCase()+" :)");
        //bloqueando o resinzing do form
        setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lbNick = new javax.swing.JLabel();
        btnLogoff = new javax.swing.JButton();
        btnSelecao = new javax.swing.JButton();
        lbNick1 = new javax.swing.JLabel();
        lstContatos = new javax.swing.JList();
        btnMensagemMultipla = new javax.swing.JButton();
        txtMensagemMultipla = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbNick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNick.setText("OLÁ, ");

        btnLogoff.setBackground(new java.awt.Color(255, 255, 255));
        btnLogoff.setText("Deslogar");
        btnLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoffActionPerformed(evt);
            }
        });

        btnSelecao.setBackground(new java.awt.Color(255, 255, 255));
        btnSelecao.setText("Selecionar Todos");
        btnSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecaoActionPerformed(evt);
            }
        });

        lbNick1.setText("LISTA DE CONTATOS");

        lstContatos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Contato1", "Contato2", "Contato3", "Contato4", "Contato5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstContatos.setSelectionBackground(new java.awt.Color(255, 102, 102));

        btnMensagemMultipla.setBackground(new java.awt.Color(255, 255, 255));
        btnMensagemMultipla.setText("Enviar");
        btnMensagemMultipla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensagemMultiplaActionPerformed(evt);
            }
        });

        txtMensagemMultipla.setText("Enviar mensagem múltipla...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbNick, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbNick1)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelecao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lstContatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtMensagemMultipla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMensagemMultipla, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNick)
                    .addComponent(btnLogoff))
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNick1))
                .addGap(18, 18, 18)
                .addComponent(lstContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMensagemMultipla)
                    .addComponent(txtMensagemMultipla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * M�todo com eventos do bot�o de Logoff.
     * @param evt Poss�vel evento que recebo por par�metro.
     */
    private void btnLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoffActionPerformed
        this.confirmacaoSaida();
    }//GEN-LAST:event_btnLogoffActionPerformed

    /**
     * M�todo que seleciona todos os contatos.
     * @param evt Evento que ser� tratado
     */
    private void btnSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecaoActionPerformed
        if(selecao<=1)
    		lstContatos.setSelectionInterval(0, lstContatos.getModel().getSize()-1);
    	else{    		
    		this.iniciaChatMultiplo(null);
    	}
    }//GEN-LAST:event_btnSelecaoActionPerformed

    /**
     * Evento do fechamento do formulário. 
     * @param evt 
     *      Evento
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.confirmacaoSaida();
    }//GEN-LAST:event_formWindowClosing

    private void btnMensagemMultiplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensagemMultiplaActionPerformed
        this.iniciaChatMultiplo(this.txtMensagemMultipla.getText());
    }//GEN-LAST:event_btnMensagemMultiplaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogoff;
    private javax.swing.JButton btnMensagemMultipla;
    private javax.swing.JButton btnSelecao;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbNick;
    private javax.swing.JLabel lbNick1;
    private javax.swing.JList lstContatos;
    private javax.swing.JTextField txtMensagemMultipla;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo que faz com que um chat seja inicializado [atrav�s do duplo clique em cima de um �nico contato]
     * @return MouseAdapter um evento de mouse
     */
    public MouseAdapter iniciaChat(){
    	return new MouseAdapter(){
    		//recebe um evento de mouse
            public void mouseClicked(MouseEvent e){
              if(e.getClickCount() == 2){ //se forem cliques duplos
                    	//pego o index do contato clicado
            	  	int indexContato = lstContatos.locationToIndex(e.getPoint());
            	  	//e atraves desse index eu verifico a String relativa ao nome do contato
            	  	String nomeContato = retornaContatoList(indexContato);	         
                        String contato[] = new String[]{nomeContato};
                        if(conversationWindow==null){//se eu não tiver criado a janela ainda
                            conversationWindow = new ConversationWindow(1, contato, null);
                         }
                        else{
                            conversationWindow.adicionaConversa(1, contato, null);
                        }
                    conversationWindow.setVisible(true);
              }
                }
          };
    }
    
    /**
     * M�todo que retorna qual o nome do contato atrav�s do seu �ndice dentro do jList lstContatos.
     * @param indiceContato �ndice do contato que desejo saber o nome
     * @return nomeContato Nome do contato desejado.
     */
    protected String retornaContatoList(int indiceContato){
    	String nomeContato;
    	nomeContato=lstContatos.getModel().getElementAt(indiceContato).toString();
    	return nomeContato;
    }
       
    /**
     * M�todo que faz com que N chats sejam inicializados.
     * @param quantidadeContatos Quantidade de contatos que selecionei.
     * @return MouseAdapter Um evento de mouse
     */
    protected void iniciaChatMultiplo(String mensagem){
    	//Indices dos contatos
        int[] indices = lstContatos.getSelectedIndices();
        //Vetor com nomes dos contatos
        String nomeContatos[]=new String[indices.length];
        for(int i=0;i<indices.length;i++){
            //Vou pegando nome a nome dos contatos 
            nomeContatos[i]=retornaContatoList(indices[i]);
            //E desabilito a janela do contato
            
        }   
        if(conversationWindow==null){//se eu não tiver criado a janela ainda
            conversationWindow = new ConversationWindow(indices.length, nomeContatos, mensagem);
        }
        else{
            conversationWindow.adicionaConversa(indices.length, nomeContatos, mensagem);
        }
        conversationWindow.setVisible(true);
        //depois de executar a funcionalidade, "zero" a quantidade de elementos selecionados
	this.selecao=0;
	this.lstContatos.clearSelection();
    }

    /**
     * Remove algum contato da lista.
     * @param idContato 
     *          Id do contato a ser removido.
     */
    protected void removeContato(int idContato){
        //TODO: codigo nas 2 linhas abaixo NAO SERA NECESSARIO quando o contatosModel for setado de acordo com quem esta online
        //Fazendo meu DefaultListModel receber os caras que ja existem na lista
        for(int i=0;i<lstContatos.getModel().getSize();i++){
            this.contatosModel.addElement(this.lstContatos.getModel().getElementAt(i));
        }
        
        //Removendo o contato que tenho
        this.contatosModel.remove(idContato);
        
        //Atualizo a lista com o que tenho
        lstContatos.setModel(this.contatosModel);
    }
    
    /**
     * Adiciona contato no JList.
     * @param nomeContato 
     *          Nome do contato a ser adicionado.
     */
    protected void adicionaContato(String nomeContato){
        //TODO: codigo nas 2 linhas abaixo NAO SERA NECESSARIO quando o contatosModel for setado de acordo com quem esta online
        //Fazendo meu DefaultListModel receber os caras que ja existem na lista
        for(int i=0;i<lstContatos.getModel().getSize();i++){
            this.contatosModel.addElement(this.lstContatos.getModel().getElementAt(i));
        }
        //Adiciono o contato que desejo, na ultima posicao
        this.contatosModel.add(lstContatos.getModel().getSize(), nomeContato);
        
        //Atualizo a lista com o que tenho
        lstContatos.setModel(this.contatosModel);
    }
    
    /**
     * Inicializa as variaveis que existem.
     */ 
    protected void inicializa(){
        this.contatosModel=new DefaultListModel();
    }
    
    /**
     * Confirma a saída do formulário ou não.
     */
    protected void confirmacaoSaida(){
        //Verificando com um JOptionPane a saída ou não do formulário
        int sair = JOptionPane.showConfirmDialog(null, "Já vai? Deseja realmente sair do chat?", 
                    "Fique um pouco mais! :)", JOptionPane.YES_NO_OPTION);
        if(sair==0){ //se desejar sair
            JOptionPane.showMessageDialog(null, "Até a próxima! :)");
            System.exit(0);
        }
    }
    
    //TODO: os metodos de adicionar e remover devem ser setados, com o tempo, para receberem o ip do contato
}
