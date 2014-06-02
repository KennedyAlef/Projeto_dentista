import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame{

	public Login(){
	
		
	final JFrame FrameCentro = new JFrame("Login");
	Container c = FrameCentro.getContentPane();
	FrameCentro.setDefaultCloseOperation(EXIT_ON_CLOSE);
	c.setBackground(Color.white);
	
	
	
	//*** TXT USUÁRIO 
	JLabel lblusuario = new JLabel("USUARIO: ");
	lblusuario.setForeground(Color.black);
	lblusuario.setFont(new Font("Comic Sans Ms", Font.BOLD , 12));
	lblusuario.setBounds(10, 20, 100, 40);
	FrameCentro.add(lblusuario);
	
	final JPasswordField txtusuario = new JPasswordField();
	txtusuario.setBounds(10, 50, 150, 25);
	txtusuario.setVisible(true);
	FrameCentro.add(txtusuario);
	
	
	//** TXT SENHA
	
	JLabel lblsenha = new JLabel("SENHA: ");
	lblsenha.setForeground(Color.black);
	lblsenha.setFont(new Font("Comic Sans Ms", Font.BOLD , 12));
	lblsenha.setBounds(10, 80, 100, 40);
	FrameCentro.add(lblsenha);
	
	final JPasswordField txtsenha = new JPasswordField();
	txtsenha.setBounds(10, 110, 150, 25);
	txtsenha.setVisible(true);
	FrameCentro.add(txtsenha);
	
	//** LOGIN 
	
	ImageIcon imglogin = new ImageIcon("check.jpg");
	JButton login = new JButton();
	login.setIcon(imglogin);
	login.setBounds(10, 140, 40, 30);
	FrameCentro.add(login);
	login.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Cliente cliente = new Cliente();
			if(cliente.login(txtusuario.getText(),txtsenha.getText())){
				
				new MenuPrincipal();
				FrameCentro.dispose();
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
				txtsenha.setText("");
				txtusuario.setText("");
			}
			
		}
	});
	
	// ** ESQUECEU SENHA
	
	ImageIcon imgesqueceu = new ImageIcon("interrogação.jpg");
	JButton btnesqueceu = new JButton();
	btnesqueceu.setIcon(imgesqueceu);
	btnesqueceu.setBounds(60, 140, 40, 30);
	FrameCentro.add(btnesqueceu);
	
	
	// ** LOGO
	
	ImageIcon imglogo = new ImageIcon("dentelogin.png");
	JLabel lbllogo = new JLabel();
	lbllogo.setIcon(imglogo);
	lbllogo.setBounds(160, 10, 140, 184);
	FrameCentro.add(lbllogo);
	
	
	
	FrameCentro.setSize(330, 230);
	FrameCentro.setLocationRelativeTo(null);
	FrameCentro.setLayout(null);
	FrameCentro.setVisible(true);
	
	
	
	
	
	
	}
}
