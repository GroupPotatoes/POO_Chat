package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
    /**
     * construtor da classe.
     */
    public TelaPrincipal(String nome) {
        initComponents();
        this.setLocationRelativeTo(null); 
        this.lstContatos.addMouseListener(this.iniciaChat()); 
        this.lstContatos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selecao = lstContatos.getSelectedIndices().length;
				if(selecao>1){
					btnSelecao.setText("Iniciar conversa");
				}
				else{
			        btnSelecao.setText("Selecionar Todos");
			    }
			}        	
        });
        this.lbNick.setText(this.lbNick.getText()+nome.toUpperCase()+" :)");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lstContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbNick1)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbNick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lstContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * M�todo com eventos do bot�o de Logoff.
     * @param evt Poss�vel evento que recebo por par�metro.
     */
    private void btnLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoffActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnLogoffActionPerformed

    /**
     * M�todo que seleciona todos os contatos.
     * @param evt Evento que ser� tratado
     */
    private void btnSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecaoActionPerformed
        if(selecao<=1)
    		lstContatos.setSelectionInterval(0, lstContatos.getModel().getSize()-1);
    	else{    		
    		this.iniciaChatMultiplo();
    	}
    }//GEN-LAST:event_btnSelecaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogoff;
    private javax.swing.JButton btnSelecao;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbNick;
    private javax.swing.JLabel lbNick1;
    private javax.swing.JList lstContatos;
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
                        if(conversationWindow==null){//se eu não tiver criado a janela ainda
                            conversationWindow = new ConversationWindow(1, lstContatos.getSelectedValue().toString());
                            /*Configurar antes:
                             * 1.Como informações serão passadas
                             * 2.Criar simples troca de mensagens
                             */
                        }
              }
            }
          };
    }
    
    /**
     * M�todo que retorna qual o nome do contato atrav�s do seu �ndice dentro do jList lstContatos.
     * @param indiceContato �ndice do contato que desejo saber o nome
     * @return nomeContato Nome do contato desejado.
     */
    public String retornaContatoList(int indiceContato){
    	String nomeContato;
    	nomeContato=lstContatos.getModel().getElementAt(indiceContato).toString();
    	return nomeContato;
    }
       
    /**
     * M�todo que faz com que N chats sejam inicializados.
     * @param quantidadeContatos Quantidade de contatos que selecionei.
     * @return MouseAdapter Um evento de mouse
     */
    public void iniciaChatMultiplo(){
    	//�ndices dos contatos
		int[] indices = lstContatos.getSelectedIndices();
        /* A partir daqui, eu teoricamente abriria N forms,
         * cada um para um chat.
         * Para exemplificar, mandarei para um jOptionPane
         */
		String contatos = "INICIE A CONVERSA COM :\n";
        for(int i = 0; i < indices.length; i++)
        	contatos += " "+retornaContatoList(indices[i]);
        JOptionPane.showMessageDialog(null, contatos);
        //depois de executar a funcionalidade, "zero" a quantidade de elementos selecionados
		this.selecao=0;
		this.lstContatos.clearSelection();
    }
}
