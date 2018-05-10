package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import VigenereCipher.VigenereCipherClass;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnkriptoDekripto {

	private JFrame frame;
	private JTextField txtPlaintext;
	private JTextField txtKey;
	private JTextField txtTekstiEnkriptuar;
	private JTextField txtDecrypt;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnkriptoDekripto window = new EnkriptoDekripto();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public EnkriptoDekripto() {
		initialize();
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		txtPlaintext = new JTextField();
		txtPlaintext.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtPlaintext.setBounds(36, 131, 355, 35);
		frame.getContentPane().add(txtPlaintext);
		txtPlaintext.setColumns(10);
		
		txtKey = new JTextField();
		txtKey.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtKey.setBounds(36, 202, 355, 35);
		frame.getContentPane().add(txtKey);
		txtKey.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PlainText");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(172, 90, 83, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Key");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(197, 171, 33, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnEnkripto = new JButton("Enkripto");
		btnEnkripto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEnkripto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String plainteksti=txtPlaintext.getText();
				String celesi=txtKey.getText();
				
				String tekstiEnkriptuar=VigenereCipherClass.encrypt(plainteksti, celesi);
				txtTekstiEnkriptuar.setText(tekstiEnkriptuar);
				
				
			}
		});
		btnEnkripto.setBounds(122, 244, 184, 45);
		frame.getContentPane().add(btnEnkripto);
		
		txtTekstiEnkriptuar = new JTextField();
		txtTekstiEnkriptuar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtTekstiEnkriptuar.setBounds(36, 337, 355, 35);
		frame.getContentPane().add(txtTekstiEnkriptuar);
		txtTekstiEnkriptuar.setColumns(10);
		
		JLabel lblCiphertext = new JLabel("Teksti Enkriptuar");
		lblCiphertext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCiphertext.setBounds(138, 305, 151, 25);
		frame.getContentPane().add(lblCiphertext);
		
		JButton btnDekripto = new JButton("Dekripto");
		btnDekripto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDekripto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tekstiEnkriptuar=txtTekstiEnkriptuar.getText();
				String celesi=txtKey.getText();
				String tekstiDekriptuar=VigenereCipherClass.decrypt(tekstiEnkriptuar, celesi);
				txtDecrypt.setText(tekstiDekriptuar);
			}
		});
		btnDekripto.setBounds(122, 396, 184, 45);
		frame.getContentPane().add(btnDekripto);
		
		JLabel lblTekstiDekriptuar = new JLabel("Teksti Dekriptuar");
		lblTekstiDekriptuar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTekstiDekriptuar.setBounds(137, 457, 154, 25);
		frame.getContentPane().add(lblTekstiDekriptuar);
		
		txtDecrypt = new JTextField();
		txtDecrypt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtDecrypt.setBounds(36, 487, 355, 35);
		frame.getContentPane().add(txtDecrypt);
		txtDecrypt.setColumns(10);
		

	    JLabel lblVinegerEncryption = new JLabel("Vigenere Cipher");
		lblVinegerEncryption.setFont(new Font("Arial", Font.PLAIN, 30));
		lblVinegerEncryption.setBounds(99, 16, 230, 35);
		frame.getContentPane().add(lblVinegerEncryption);
	}
}
