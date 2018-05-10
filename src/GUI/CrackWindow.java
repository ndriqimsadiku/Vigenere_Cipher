package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import VigenereCipher.VigenereCipher;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

public class CrackWindow {

	private JFrame frame;
	private JTextField txtCelesiCrack;
	private JLabel lblelesi;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrackWindow window = new CrackWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CrackWindow() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 532, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JTextArea txtCipherCrack = new JTextArea();
		txtCipherCrack.setBounds(31, 54, 438, 69);
		frame.getContentPane().add(txtCipherCrack);
		txtCipherCrack.setLineWrap(true);
		txtCipherCrack.setWrapStyleWord(true);
		
		JTextArea txtPlainTextCrack = new JTextArea();
		txtPlainTextCrack.setBounds(31, 188, 438, 61);
		frame.getContentPane().add(txtPlainTextCrack);
		txtPlainTextCrack.setLineWrap(true);
		txtPlainTextCrack.setWrapStyleWord(true);
		
		
		JLabel lblNewLabel = new JLabel("Ciphertext");
		lblNewLabel.setBounds(31, 32, 79, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PlainText");
		lblNewLabel_1.setBounds(31, 167, 65, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnCrack = new JButton("CRACK");
		btnCrack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VigenereCipher vigenereCipher=new VigenereCipher();
				
				if(txtCipherCrack.getText()==null) {
					JOptionPane.showMessageDialog(null,"Please write a text in textfield that you want to crack... ");
				}
				else {
					String TextToCrack=txtCipherCrack.getText();
					CharSequence n="1234567890";
					
					if(TextToCrack.contains(n)) {
						JOptionPane.showMessageDialog(null,"Please write only letters...");						
					}
					
					String[] textVarg=TextToCrack.split(" ");
					
					TextToCrack="";
					for(int i=0;i<textVarg.length;i++) {
						TextToCrack+=textVarg[i];
					}
					
					
				    String key = VigenereCipher.calculateKey(TextToCrack);
				    String plainText = VigenereCipher.decrypt(TextToCrack, key);
				    txtPlainTextCrack.setText(plainText);
				    txtCelesiCrack.setText(key);		
					
				}
				
			}
		});
		btnCrack.setBounds(120, 124, 247, 49);
		frame.getContentPane().add(btnCrack);
		
		txtCelesiCrack = new JTextField();
		txtCelesiCrack.setColumns(10);
		txtCelesiCrack.setBounds(41, 291, 438, 26);
		frame.getContentPane().add(txtCelesiCrack);
		
		lblelesi = new JLabel("\u00C7elesi ");
		lblelesi.setBounds(31, 265, 79, 20);
		frame.getContentPane().add(lblelesi);
		
	
	}
}
