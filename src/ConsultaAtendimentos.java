import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class ConsultaAtendimentos extends JFrame{
	
	public ConsultaAtendimentos(){
		

		final JFrame FrameCentro = new JFrame();
		Container c = FrameCentro.getContentPane();
		
		Color corAzul = new Color(61,122,241);
		
		c.setBackground(Color.white);
		FrameCentro.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
		JTable tblcliente = new JTable(0,0);    
		tblcliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
      
      Cliente cliente = new Cliente();
      cliente.getTableTotal(tblcliente);
      
      JScrollPane scrollPane = new JScrollPane(tblcliente);
      scrollPane.setBounds(10, 120, 430, 146);    
      scrollPane.setBackground(Color.white);
      FrameCentro.add(scrollPane);
      
      JLabel lbltitulo = new JLabel("CONSULTAS REALIZADAS E MARCADAS");
      lbltitulo.setForeground(Color.red);
      lbltitulo.setFont(new Font("Comic Sans Ms", Font.BOLD, 16));
      lbltitulo.setBounds(20, 45, 340, 40);
      FrameCentro.add(lbltitulo);
		
      ImageIcon imglogo = new ImageIcon("dentelogo2.jpg");
      JLabel lbllogo = new JLabel();
      lbllogo.setIcon(imglogo);
      lbllogo.setBounds(500, 40, 180, 278);
      FrameCentro.add(lbllogo);
      
      ImageIcon btnvolt = new ImageIcon("frente.png");
	  JButton btnvoltar = new JButton();	
	  btnvoltar.setIcon(btnvolt);
	  FrameCentro.add(btnvoltar);
	  btnvoltar.setBounds(10, 300, 50, 50);
	  btnvoltar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			new MenuPrincipal();
			FrameCentro.dispose();
			
		}
	});
	
      
  	FrameCentro.setSize(720, 420);
	FrameCentro.setLocationRelativeTo(null);
	FrameCentro.setLayout(null);
	FrameCentro.setVisible(true);
		
		
	}

}
