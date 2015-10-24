package View;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.FocusManager;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Dimension;

public class ConversationWindow extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ConversationWindow(int String, String contatos) {
		
		setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setAutoscrolls(true);
		add(tabbedPane, "cell 0 0 1 2,grow");
		
		JTextArea txtRandomConversation = new JTextArea();
		txtRandomConversation.setText("Harry:\r\nblablablabla\r\n\r\nSally: \r\ncool talk bro\r\n\r\nHarry: \r\nbye!");
		tabbedPane.addTab("Harry", null, txtRandomConversation, null);
		JTextArea txtRandomConversation2 = new JTextArea();
		txtRandomConversation2.setText("Harry:\r\nlol this is weird\r\n\r\nJohn: \r\nwhat are you talking about\r\n\r\nHarry: \r\nnothing!");
		tabbedPane.addTab("John", null, txtRandomConversation2, null);
		
		textField = new JTextField();
		add(textField, "flowx,cell 0 2,growx");
		textField.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		add(btnEnviar, "cell 0 2");

	}

}
