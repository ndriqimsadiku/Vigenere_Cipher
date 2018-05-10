package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import VigenereCipher.VigenereCipherClass;

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
		frame.setBounds(100, 100, 532, 713);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JTextArea txtCipherCrack = new JTextArea();
		txtCipherCrack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCipherCrack.setBounds(36, 140, 438, 100);
		frame.getContentPane().add(txtCipherCrack);
		txtCipherCrack.setLineWrap(true);
		txtCipherCrack.setWrapStyleWord(true);
		
		JTextArea txtPlainTextCrack = new JTextArea();
		txtPlainTextCrack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPlainTextCrack.setBounds(36, 370, 438, 100);
		frame.getContentPane().add(txtPlainTextCrack);
		txtPlainTextCrack.setLineWrap(true);
		txtPlainTextCrack.setWrapStyleWord(true);
		
		JLabel lblNewLabel = new JLabel("Ciphertext");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(36, 112, 92, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PlainText");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 342, 83, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnCrack = new JButton("CRACK");
		btnCrack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VigenereCipherClass vigenereCipher=new VigenereCipherClass();
				
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
					
					
				   // String key = VigenereCipherClass.calculateKey(TextToCrack);
				//    String plainText = VigenereCipherClass.decrypt(TextToCrack, key);
				 //   txtPlainTextCrack.setText(plainText);
				   // txtCelesiCrack.setText(key);		
					
				}
				
			}
		});
		btnCrack.setBounds(121, 260, 268, 69);
		frame.getContentPane().add(btnCrack);
		
		txtCelesiCrack = new JTextField();
		txtCelesiCrack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCelesiCrack.setColumns(10);
		txtCelesiCrack.setBounds(36, 546, 438, 35);
		frame.getContentPane().add(txtCelesiCrack);
		
		lblelesi = new JLabel("\u00C7el\u00EBsi ");
		lblelesi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblelesi.setBounds(36, 518, 59, 25);
		frame.getContentPane().add(lblelesi);
		
		JLabel lblVinegerCipher = new JLabel("Vineger Cipher");
		lblVinegerCipher.setFont(new Font("Arial", Font.PLAIN, 40));
		lblVinegerCipher.setBounds(124, 30, 261, 47);
		frame.getContentPane().add(lblVinegerCipher);
		
	
	}
}
