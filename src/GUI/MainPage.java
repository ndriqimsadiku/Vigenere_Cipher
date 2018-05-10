package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainPage {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainPage() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 406, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		String twoLines = "Enkripto/Dekripto \n Vigenere Cipher";
	
		JButton btnEnkDekr = new JButton("<html>" + twoLines.replaceAll("\\n", "<br>") + "</html>");
		btnEnkDekr.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEnkDekr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnkriptoDekripto.main(null);
			}
		});
		btnEnkDekr.setBounds(66, 153, 251, 83);
		frame.getContentPane().add(btnEnkDekr);
		
		JButton btnCrack = new JButton("Crack Vigenere Cipher");
		btnCrack.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrackWindow.main(null);
			}
		});
		btnCrack.setBounds(66, 263, 251, 50);
		frame.getContentPane().add(btnCrack);
		
		JLabel lblVigenerCipher = new JLabel("Vigenere Cipher");
		lblVigenerCipher.setFont(new Font("Arial", Font.PLAIN, 40));
		lblVigenerCipher.setBounds(44, 26, 296, 57);
		frame.getContentPane().add(lblVigenerCipher);
	}

}