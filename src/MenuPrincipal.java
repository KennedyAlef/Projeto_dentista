import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MenuPrincipal extends JFrame {
	
	public MenuPrincipal(){
		
		final JFrame FrameCentro = new JFrame();
		Container c = FrameCentro.getContentPane();
		c.setBackground(Color.white);
		FrameCentro.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Color transparente = new Color(0,0,0);
		
		ImageIcon bntconsultarStatus = new ImageIcon("dente.png");
		final JButton btnconsultarStatus = new JButton();
		btnconsultarStatus.setIcon(bntconsultarStatus);
		btnconsultarStatus.setBackground(Color.white);
		btnconsultarStatus.setBorder(null);
		btnconsultarStatus.setBounds(10, 60, 180, 237);
		FrameCentro.add(btnconsultarStatus);
		btnconsultarStatus.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnconsultarStatus.setBounds(10, 60, 180, 227);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnconsultarStatus.setBounds(10, 0, 180, 280);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnconsultarStatus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TestaCombo();
				FrameCentro.dispose();
				
			}
		});
		
		JLabel lblconsultarStatus = new JLabel("STATUS CONSULTA");
		lblconsultarStatus.setForeground(Color.red);
		lblconsultarStatus.setFont(new Font("Comic Sans Ms", Font.BOLD , 18));
		lblconsultarStatus.setBounds(10, 290, 200, 60);
		FrameCentro.add(lblconsultarStatus);
		
			
		ImageIcon imgmarcaConsulta = new ImageIcon ("dentist.png");
		final JButton btnmarcaConsulta= new JButton();
		btnmarcaConsulta.setIcon(imgmarcaConsulta);
		btnmarcaConsulta.setBackground(Color.white);
		btnmarcaConsulta.setBorder(null);
		btnmarcaConsulta.setBounds(260,60,180,239);
		FrameCentro.add(btnmarcaConsulta);
		
		
		JLabel lblmarcaConsulta = new JLabel("MARCAR CONSULTA");
		lblmarcaConsulta.setForeground(Color.red);
		lblmarcaConsulta.setFont(new Font("Comic Sans Ms", Font.BOLD, 18));
		lblmarcaConsulta.setBounds(260, 290, 200, 60);
		FrameCentro.add(lblmarcaConsulta);
		btnmarcaConsulta.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnmarcaConsulta.setBounds(260,60,180,239);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnmarcaConsulta.setBounds(260, 10, 180,280);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnmarcaConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MarcaConsulta();
				FrameCentro.dispose();
				
			}
		});
		
		ImageIcon imgCadastro = new ImageIcon("dentelogo2.jpg");
	final JButton btnCadastro = new JButton();
		btnCadastro.setIcon(imgCadastro);
		btnCadastro.setBackground(Color.white);
		btnCadastro.setBorderPainted(false);
		btnCadastro.setBounds(500, 30, 180, 278);
		FrameCentro.add(btnCadastro);
		btnCadastro.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnCadastro.setBounds(500, 30, 180, 278);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCadastro.setBounds(500, 0, 180, 300);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuCadastro();
				FrameCentro.dispose();
				
				
			}
		});
		
		JLabel lblcadastro = new JLabel("CADASTRO ");
		lblcadastro.setForeground(Color.red);
		lblcadastro.setFont(new Font("Comic Sans Ms", Font.BOLD, 18));
		lblcadastro.setBounds(530, 290, 200, 60);
		FrameCentro.add(lblcadastro);
		
		ImageIcon imgConsultaAtendimentos = new ImageIcon("dente4.jpg");
		final JButton btnConsultaAtendimentos = new JButton();
		btnConsultaAtendimentos.setBorderPainted(false);
		btnConsultaAtendimentos.setIcon(imgConsultaAtendimentos);
		btnConsultaAtendimentos.setBounds(730, 40, 200, 266);
		btnConsultaAtendimentos.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
			btnConsultaAtendimentos.setBounds(730, 40, 200, 266);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
			btnConsultaAtendimentos.setBounds(730, 10, 200, 266);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnConsultaAtendimentos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ConsultaAtendimentos();
				FrameCentro.dispose();
				
			}
		});
		FrameCentro.add(btnConsultaAtendimentos);
		
		JLabel lblConsultaAtendimentos = new JLabel("CONSULTAS MARCADAS");
		lblConsultaAtendimentos.setForeground(Color.red);
		lblConsultaAtendimentos.setFont(new Font("Comic Sans Ms ", Font.BOLD, 18));
		lblConsultaAtendimentos.setBounds(690, 290, 230, 60);
		FrameCentro.add(lblConsultaAtendimentos);
		
		FrameCentro.setLayout(null);
		FrameCentro.setSize(1000, 600);
		FrameCentro.setLocationRelativeTo(null);
		FrameCentro.setVisible(true);
		
	}

}
