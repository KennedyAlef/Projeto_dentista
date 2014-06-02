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
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ConsultaStatus extends JFrame {

	public ConsultaStatus(){
		final JFrame FrameCentro = new JFrame();
		Container c = FrameCentro.getContentPane();
		
		Color corAzul = new Color(61,122,241);
		
		c.setBackground(Color.white);
		FrameCentro.setDefaultCloseOperation(EXIT_ON_CLOSE);
		FrameCentro.setSize(800, 680);
		FrameCentro.setLocationRelativeTo(null);
		FrameCentro.setLayout(null);
		FrameCentro.setVisible(true);
		
		  ImageIcon logo = new ImageIcon("dentelogo2.jpg");
			JLabel lblogo = new JLabel();
			lblogo.setIcon(logo);
			FrameCentro.add(lblogo);
			lblogo.setBounds(580, 10, 155, 235);
			lblogo.setLayout(null);
			
		JLabel titulomake = new JLabel("Make Tooth White S.A");
		FrameCentro.add(titulomake);
		titulomake.setFont(new Font("Monotype Corsiva", Font.ITALIC,  18));
		titulomake.setForeground(corAzul);
		titulomake.setBounds(10, 10, 180, 30);
		
		JLabel lblatendimento = new JLabel("Status de Atendimento");
		FrameCentro.add(lblatendimento);
		lblatendimento.setFont(new Font("Comic Sans Ms", Font.BOLD, 40));
		lblatendimento.setForeground(Color.red);
		lblatendimento.setBounds(20, 90, 460, 120);
		  
		
	JTable tblcliente = new JTable(0,0);    
  
  Cliente cliente = new Cliente();
  cliente.getTable(tblcliente);
  tblcliente.setForeground(Color.black);
  tblcliente.setFont(new Font("Comic Sans Ms", Font.BOLD , 14));
  JScrollPane scrollPane = new JScrollPane(tblcliente);
  scrollPane.setBounds(0, 290, 800,270);    
  tblcliente.setAutoCreateRowSorter(true);
  scrollPane.getViewport().setBackground(Color.white);
  FrameCentro.add(scrollPane);

  ImageIcon btnvolt = new ImageIcon("frente.png");
  JButton btnvoltar = new JButton();	
  btnvoltar.setIcon(btnvolt);
  FrameCentro.add(btnvoltar);
  btnvoltar.setBounds(0, 570, 50, 50);
  btnvoltar.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	new TestaCombo();
	FrameCentro.dispose();
		
	}
});
  
	
	}
	
	

	
}
