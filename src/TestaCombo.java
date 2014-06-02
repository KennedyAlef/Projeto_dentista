import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


public class TestaCombo extends JFrame {

	
	public TestaCombo(){
		
		final JFrame FrameCentro = new JFrame();
		Container c = FrameCentro.getContentPane();
		
		Color corAzul = new Color(61,122,241);
		
		c.setBackground(Color.white);
		FrameCentro.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	final Cliente cliente = new Cliente();
	 final JComboBox comboNome = new JComboBox();
	  comboNome.setBounds(10, 30, 200, 20);
	  FrameCentro.add(comboNome);
	  for (String l : cliente.getListaEnviar()) {
         comboNome.addItem(l);
      }
	  ImageIcon logo = new ImageIcon("dentelogo2.jpg");
		JLabel lblogo = new JLabel();
		lblogo.setIcon(logo);
		FrameCentro.add(lblogo);
		lblogo.setBounds(420, 50, 200, 313);
	  
	// *** LABEL E TXT ENDEREÇO
				JLabel lblendereco = new JLabel("ENDERECO ");
				FrameCentro.add(lblendereco);
				lblendereco.setForeground(Color.black);
				lblendereco.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
				lblendereco.setBounds(10, 90, 100, 30);
				
				final JTextField txtendereco = new JTextField("");
				FrameCentro.add(txtendereco);
				txtendereco.setForeground(Color.black);
				txtendereco.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
				txtendereco.setBounds(120, 90, 150, 25);

				txtendereco.setEditable(false);
				
				// *** LABEL E TXT IDADE
				
				JLabel lblidade = new JLabel("IDADE ");
				FrameCentro.add(lblidade);
				lblidade.setForeground(Color.black);
				lblidade.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
				lblidade.setBounds(10, 130, 100, 30);
				
				final JTextField txtidade = new JTextField("");
				FrameCentro.add(txtidade);
				txtidade.setForeground(Color.black);
				txtidade.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
				txtidade.setBounds(120, 130, 150, 25);
				
				txtidade.setEditable(false);
				
				// ** LABEL E TXT DATA CONSULTA
				
				JLabel lbldata = new JLabel("DATA ");
				FrameCentro.add(lbldata);
				lbldata.setForeground(Color.red);
				lbldata.setFont(new Font("Comic Sans Ms",Font.BOLD,16));
				lbldata.setBounds(10, 165, 150, 30);
				
				final JTextField txtdata = new JTextField();
				FrameCentro.add(txtdata);
				txtdata.setForeground(Color.black);
				txtdata.setFont(new Font("Comic Sans Ms", Font.BOLD, 12));
				txtdata.setBounds(120, 165, 150, 25);
			
				txtdata.setEditable(false);
				
				//** LABEL E TXT HORARIO CONSULTA
				

				JLabel lblhora = new JLabel("HORARIO  ");
				FrameCentro.add(lblhora);
				lblhora.setForeground(Color.red);
				lblhora.setFont(new Font("Comic Sans Ms",Font.BOLD,16));
				lblhora.setBounds(10, 200, 150, 30);
				
				final JTextField txthora = new JTextField();
				FrameCentro.add(txthora);
				txthora.setForeground(Color.red);
				txthora.setFont(new Font("Comic Sans Ms", Font.BOLD, 13));
				txthora.setBounds(120, 200, 150, 25);
			
				txthora.setEditable(false);
				
				
				// ** LABEL E TXT TELEFONE 
				
				JLabel lbltelefone = new JLabel("TELEFONE:");
				FrameCentro.add(lbltelefone);
				lbltelefone.setForeground(Color.black);
				lbltelefone.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
				lbltelefone.setBounds(10, 230, 100, 30);
				
				final JTextField txttelefone = new JTextField("");
				FrameCentro.add(txttelefone);
				txttelefone.setForeground(Color.black);
				txttelefone.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
				txttelefone.setBounds(120, 230, 150, 25);
				txttelefone.setEditable(false);
		
	
	JButton btnconsulta = new JButton("Pesquisar");
	
	FrameCentro.add(btnconsulta);
	btnconsulta.setBounds(240, 25, 100, 30);
	btnconsulta.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
	        
			final	String selecionanome = String.valueOf(comboNome.getSelectedItem());
			final Cliente cliente2 = Cliente.find_nome(selecionanome);
			txtendereco.setText(cliente2.getEndereco());
			txtidade.setText(String.valueOf(cliente2.getIdade()));
			txtdata.setText(cliente2.getData());
			txttelefone.setText(cliente2.getTelefone());

			txthora.setText(String.valueOf(cliente2.getHorario()));
			
			
			
		final	JComboBox comboopcao = new JComboBox();
			
			FrameCentro.add(comboopcao);
			comboopcao.addItem("em atendimento");
			comboopcao.addItem("Remarcado");
			comboopcao.addItem("Faltou");
			comboopcao.setBounds(10, 280, 140, 30);
			
			ImageIcon ir = new ImageIcon("icon.jpg");
			JButton btnConfirmapaciente = new JButton();
			btnConfirmapaciente.setIcon(ir);
			FrameCentro.add(btnConfirmapaciente);
			btnConfirmapaciente.setBounds(300, 320, 65, 40);
			btnConfirmapaciente.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
			final String selecionastatus = String.valueOf(comboopcao.getSelectedItem());

			cliente2.altera_status(cliente2.getCpf(), selecionastatus);
			System.out.println(cliente2.getStatus());
			new ConsultaStatus();
			FrameCentro.dispose();
			
					
				}
			});
			
			
			
		}
	});
		
	ImageIcon btnvolt = new ImageIcon("frente.png");
	  JButton btnvoltar = new JButton();	
	  btnvoltar.setIcon(btnvolt);
	  FrameCentro.add(btnvoltar);
	  btnvoltar.setBounds(10, 320, 50, 50);
	  btnvoltar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			new MenuPrincipal();
			FrameCentro.dispose();
			
		}
	});
	 
	  FrameCentro.setSize(680, 420);
		FrameCentro.setLocationRelativeTo(null);
		FrameCentro.setLayout(null);
		FrameCentro.setVisible(true);
	  
	}
}
