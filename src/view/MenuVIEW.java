package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class MenuVIEW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuVIEW frame = new MenuVIEW();
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
	public MenuVIEW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 444);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuCadastro = new JMenu("Cadastrar");
		menuBar.add(MenuCadastro);
		
		JMenuItem itemMenuCadastroVendedor = new JMenuItem("Vendedor");
		MenuCadastro.add(itemMenuCadastroVendedor);
		
		JMenuItem itemMenuCadastroCliente = new JMenuItem("Cliente");
		MenuCadastro.add(itemMenuCadastroCliente);
		
		JMenuItem itemMenuCadastroProduto = new JMenuItem("Produto");
		MenuCadastro.add(itemMenuCadastroProduto);
		
		JMenu MenuVendas = new JMenu("Vender");
		menuBar.add(MenuVendas);
		
		JMenuItem itemMenuVendas = new JMenuItem("Vendas");
		MenuVendas.add(itemMenuVendas);
		
		JMenu MenuSair = new JMenu("Sair");
		menuBar.add(MenuSair);
		
		JMenuItem itemMenuFechar = new JMenuItem("Fechar");
		MenuSair.add(itemMenuFechar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
