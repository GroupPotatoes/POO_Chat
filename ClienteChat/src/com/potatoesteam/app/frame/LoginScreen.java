package com.potatoesteam.app.frame;

import com.potatoesteam.app.bean.ChatMessage;
import com.potatoesteam.app.bean.ChatMessage.Action;
import com.potatoesteam.app.bean.ConnectionSetup;
import com.potatoesteam.app.bean.ListenerSocket;
import com.potatoesteam.app.service.ClienteService;
import java.awt.Color;


public class LoginScreen extends javax.swing.JFrame {

    public LoginScreen() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        btnLogar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("bem vindo! :)");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("digite seu nickname para logar no chat:");

        btnLogar.setText("entrar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btnLogar)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        ConnectionSetup.nickName = txtLogin.getText();
        if(ConnectionSetup.nickName.isEmpty() || ConnectionSetup.nickName == null){
            this.lblTitulo.setText("digite seu nickname :(");
            this.lblTitulo.setForeground(Color.red);
        }
        else{    
            this.lblTitulo.setText(":)");
            this.lblTitulo.setForeground(Color.black);
            
            ConnectionSetup.message = new ChatMessage();
            ConnectionSetup.message.setAction(Action.CONNECT);
            ConnectionSetup.message.setName(ConnectionSetup.nickName);

            ConnectionSetup.service = new ClienteService();
            ConnectionSetup.socket = ConnectionSetup.service.connect();

            ConnectionSetup.currentListenerSocket =  new Thread(new ListenerSocket(ConnectionSetup.socket));
            ConnectionSetup.currentListenerSocket.start();

            ConnectionSetup.service.send(ConnectionSetup.message);
            
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnLogarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables

    
}
