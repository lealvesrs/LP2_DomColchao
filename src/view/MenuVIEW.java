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
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
public class MenuVIEW extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JFrame frame = new JFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuVIEW frame = new MenuVIEW();
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
	
	
	/*public class FundoDesktopPane extends JDesktopPane {
	    private Image fundo;

	    public FundoDesktopPane() {
	        try {
	            fundo = ImageIO.read(new File("imagens/imagemFundo.jpg"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if (fundo != null) {
	            g.drawImage(fundo, 0, 0, this); // Desenha a imagem de fundo
	        }
	    }
	}
	// Substitua JDesktopPane por FundoDesktopPane
fundoDesktopPane = new FundoDesktopPane();
fundoDesktopPane.setBounds(0, 0, 800, 600); // Ajuste o tamanho conforme necessário
contentPane.add(fundoDesktopPane);

	
	*/

	public MenuVIEW() {
		
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 444);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(249, 235, 223));
		setJMenuBar(menuBar);
		
		JMenu MenuCadastro = new JMenu("Cadastrar");
		menuBar.add(MenuCadastro);
		
		JMenuItem itemMenuCadastroVendedor = new JMenuItem("Vendedor");
		itemMenuCadastroVendedor.setIcon(new ImageIcon(MenuVIEW.class.getResource("/imagens/vendedor.png")));
		itemMenuCadastroVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVendedorVIEW();
			}
		});
		MenuCadastro.add(itemMenuCadastroVendedor);
		
		JMenuItem itemMenuCadastroCliente = new JMenuItem("Cliente");
		itemMenuCadastroCliente.setIcon(new ImageIcon(MenuVIEW.class.getResource("/imagens/cliente.png")));
		itemMenuCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirClienteVIEW();
			}
		});
		MenuCadastro.add(itemMenuCadastroCliente);
		
		JMenuItem itemMenuCadastroProduto = new JMenuItem("Produto");
		itemMenuCadastroProduto.setIcon(new ImageIcon(MenuVIEW.class.getResource("/imagens/vendas.png")));
		itemMenuCadastroProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirProdutoVIEW();
			}});
		MenuCadastro.add(itemMenuCadastroProduto);
		
		JMenu MenuVendas = new JMenu("Vender");
		menuBar.add(MenuVendas);
		
		JMenuItem itemMenuVendas = new JMenuItem("Vendas");
		itemMenuVendas.setIcon(new ImageIcon(MenuVIEW.class.getResource("/imagens/cifrão.png")));
		MenuVendas.add(itemMenuVendas);
		
		JMenu MenuSair = new JMenu("Sair");
		menuBar.add(MenuSair);
		
		JMenuItem itemMenuFechar = new JMenuItem("Fechar");
		itemMenuFechar.setIcon(new ImageIcon(MenuVIEW.class.getResource("/imagens/logout_16dp_F_FILL0_wght400_GRAD0_opsz20.png")));
		MenuSair.add(itemMenuFechar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 729, 383);
	    contentPane.add(desktopPane);
		desktopPane.setLayout(null);
	}
	
	private void abrirClienteVIEW() {
	    ClienteVIEW clienteView = new ClienteVIEW();
	    clienteView.setClosable(false);
	    clienteView.setResizable(false);
	    clienteView.setMaximizable(false);
	    clienteView.setIconifiable(true);
	    clienteView.setVisible(true);

	  
	    JDesktopPane desktopPane = (JDesktopPane) contentPane.getComponent(0); 
	    clienteView.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
	    desktopPane.add(clienteView); 
	    try {
	        clienteView.setSelected(true); 
	    } catch (java.beans.PropertyVetoException e) {
	        e.printStackTrace();
	    }
	}
	
	private void abrirProdutoVIEW() {
	    ProdutoVIEW produtoView = new ProdutoVIEW();
	    produtoView.setClosable(false);
	    produtoView.setResizable(false);
	    produtoView.setMaximizable(false);
	    produtoView.setIconifiable(true);
	    produtoView.setVisible(true);

	  
	    JDesktopPane desktopPane = (JDesktopPane) contentPane.getComponent(0); 
	    produtoView.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
	    desktopPane.add(produtoView); 
	    try {
	    	produtoView.setSelected(true); 
	    } catch (java.beans.PropertyVetoException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	private void abrirVendedorVIEW() {
	    VendedorVIEW vendedorView = new VendedorVIEW();
	    vendedorView.setClosable(false);
	    vendedorView.setResizable(false);
	    vendedorView.setMaximizable(false);
	    vendedorView.setIconifiable(true);
	    vendedorView.setVisible(true);

	  
	    JDesktopPane desktopPane = (JDesktopPane) contentPane.getComponent(0); 
	    vendedorView.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
	    desktopPane.add(vendedorView); 
	    try {
	        vendedorView.setSelected(true); 
	    } catch (java.beans.PropertyVetoException e) {
	        e.printStackTrace();
	    }
	}
}
