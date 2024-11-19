package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class LoginVIEW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField login;
	private JTextField senha;
	JFrame frame = new JFrame();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginVIEW frame = new LoginVIEW();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 91, 365, 130);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(10, 26, 29, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(10, 83, 44, 14);
		panel.add(lblNewLabel_1);
		
		login = new JTextField();
		login.setBounds(61, 23, 264, 20);
		panel.add(login);
		login.setColumns(10);
		
		senha = new JTextField();
		senha.setBounds(64, 80, 261, 20);
		panel.add(senha);
		senha.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(155, 11, 121, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtLogin = login.getText();
				String txtSenha = senha.getText();
				
				if(txtLogin.isEmpty() || txtSenha.isEmpty()) JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				else {
					if(txtLogin.equals("admin") && txtSenha.equals("admin")) abrirMenu();
					else JOptionPane.showMessageDialog(null, "Login ou Senha incorretos");
				}
				
//				abrirClienteVIEW();
			}
		});
		btnEntrar.setBounds(68, 248, 89, 23);
		contentPane.add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(282, 248, 89, 23);
		contentPane.add(btnSair);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(2, -1, 437, 1);
		contentPane.add(desktopPane);
	}
	
	private void abrirMenu() {
		 MenuVIEW menu = new MenuVIEW();
			 menu.setVisible(true);
			 menu.setResizable(false);
			 dispose();
	}
}
