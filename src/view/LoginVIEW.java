package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoginVIEW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField login;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginVIEW frame = new LoginVIEW();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 235, 223));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(249, 235, 229));
		panel.setBounds(66, 140, 389, 157);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 41, 44, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 105, 56, 14);
		panel.add(lblNewLabel_1);
		
		login = new JTextField();
		login.setBounds(78, 38, 264, 20);
		panel.add(login);
		login.setColumns(10);
		
		senha = new JTextField();
		senha.setBounds(76, 104, 261, 20);
		panel.add(senha);
		senha.setColumns(10);
		
		JButton btnEntrar = new JButton("");
		btnEntrar.setBackground(new Color(249, 235, 223));
		btnEntrar.setIcon(new ImageIcon("C:\\Users\\marci\\Downloads\\login_16dp_F_FILL0_wght400_GRAD0_opsz20.png"));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntrar.setBounds(237, 342, 54, 54);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\marci\\Downloads\\imagemLogo-removebg-preview.png"));
		lblNewLabel_2.setBounds(175, 22, 159, 89);
		contentPane.add(lblNewLabel_2);
	}
}
