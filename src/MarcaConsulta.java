import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


public class MarcaConsulta extends JFrame{

	public MarcaConsulta(){
		
	final JFrame FrameCentro = new JFrame();
	Container c = FrameCentro.getContentPane();
		
	c.setBackground(Color.white);
	FrameCentro.setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	
	
		ImageIcon logo = new ImageIcon("dentelogo2.jpg");
		JLabel lblogo = new JLabel();
		lblogo.setIcon(logo);
		FrameCentro.add(lblogo);
		lblogo.setBounds(470, 50, 200, 313);
		lblogo.setLayout(null);
		
		// ** TITULO E TXT CPF 
		
		JLabel lblcpf = new JLabel("cpf");
		FrameCentro.add(lblcpf);
		lblcpf.setFont(new Font("Comic Sans Ms", Font.ITALIC, 16));
		lblcpf.setBounds(10, 20, 120,30);
		
		final JTextField txtcpf = new JTextField();
		FrameCentro.add(txtcpf);
		txtcpf.setBounds(60, 25, 140,25);
		
		final Cliente cliente = new Cliente();
		 final JComboBox comboNome = new JComboBox();
		  comboNome.setBounds(230,25, 150, 25);
		  FrameCentro.add(comboNome);
		  for (String l : cliente.getListaEnviar()) {
	         comboNome.addItem(l);
	      }
		  
		  //** TITULO E TXT NOME
		  JLabel lblnome = new JLabel("Nome completo");
		  FrameCentro.add(lblnome);
		  lblnome.setForeground(Color.black);
		  lblnome.setFont(new Font("Comic Sans Ms", Font.BOLD,13));
		  lblnome.setBounds(10, 70, 100, 30);
		  
		  final JTextField txtnome = new JTextField();
		  FrameCentro.add(txtnome);
		  txtnome.setBounds(10, 100, 220, 25);
		  txtnome.setEditable(false);
		  
		  //** TITULO E TXT TELEFONE
		  
		  JLabel lbltelefone= new JLabel("telefone");
		  FrameCentro.add(lbltelefone);
		  lbltelefone.setForeground(Color.black);
		  lbltelefone.setFont(new Font("Comic Sans Ms", Font.BOLD,13));
		  lbltelefone.setBounds(10, 130, 100, 30);
		  
		  final JTextField txttelefone = new JTextField();
		  FrameCentro.add(txttelefone);
		  txttelefone.setBounds(10, 160, 220, 25);
		  txttelefone.setEditable(false);
		  
		  // ** TITULO E TXT CPF
		  
		  JLabel lblcpf1 = new JLabel("Cpf");
		  FrameCentro.add(lblcpf1);
		  lblcpf1.setForeground(Color.black);
		  lblcpf1.setFont(new Font("Comic Sans Ms", Font.BOLD,13));
		  lblcpf1.setBounds(10, 190, 100, 30);
		  
		  final  JTextField txtcpf1 = new JTextField();
		  FrameCentro.add(txtcpf1);
		  txtcpf1.setBounds(10, 220, 220, 25);		  
		  txtcpf1.setEditable(false);
		  
		  
		  
		  
		  
		  
		  //** CALENDARIO CONSULTA
		  JLabel lbldata = new JLabel("Proxima consulta ");
			FrameCentro.add(lbldata);
			lbldata.setForeground(Color.black);
			lbldata.setFont(new Font("Comic Sans Ms",Font.BOLD,13));
			lbldata.setBounds(10, 265, 150, 30);
			
			final JDateChooser calendario = new JDateChooser(new java.util.Date(), "yyyy/MM/dd"); 
			
			FrameCentro.add(calendario);
			calendario.setBounds(10, 290, 180, 30);
			calendario.setEnabled(false);
			
			//*** BOTAO PESQUISA CONSULTA	
						
			ImageIcon imconsultahorario = new ImageIcon("Lupa.png");
			JButton btnconsultaHorario = new JButton();
			btnconsultaHorario.setIcon(imconsultahorario);
			btnconsultaHorario.setBounds(200, 290, 40, 30);
			FrameCentro.add(btnconsultaHorario);
			 final JComboBox comboHora = new JComboBox();
			btnconsultaHorario.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
				
					final String data1 =new SimpleDateFormat("yyyy-MM-dd").format(calendario.getDate());

					JLabel lblhorario = new JLabel("Horario");
					FrameCentro.add(lblhorario);
					lblhorario.setForeground(Color.black);
					lblhorario.setFont(new Font("Comic Sans Ms ", Font.BOLD, 13));
					lblhorario.setBounds(10, 325, 100, 30);
					System.out.println("DATA: "+data1);
				
					
					Cliente cliente = new Cliente();
					
					cliente.consulta_horario(data1);
					

					
					  comboHora.removeAllItems();
					  comboHora.setBounds(10, 350, 200, 20);
					  FrameCentro.add(comboHora);
					  
					  for (int i = 0 ; i<cliente.horasdisponiveis.size();i++){
						  comboHora.addItem(cliente.horasdisponiveis.get(i));
						  
					  }
					
					
				}
				
			
			});
			
			
			// *** BOTAO CHECK
			
			ImageIcon check = new ImageIcon("check.jpg");
			JButton btncheck = new JButton();
			btncheck.setBackground(Color.white);
			btncheck.setIcon(check);
			btncheck.setBounds(400, 20, 40, 30);
			FrameCentro.add(btncheck);
			btncheck.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
		String cpf = txtcpf.getText();  
		if(cpf.isEmpty()){
			txtnome.setEditable(true);
			txttelefone.setEditable(true);
			calendario.setEnabled(true);
			
			final	String selecionanome = String.valueOf(comboNome.getSelectedItem());
			final Cliente cliente2 = Cliente.find_nome(selecionanome);
			txtnome.setText(cliente2.getNome());
			txttelefone.setText(cliente2.getTelefone());
			txtcpf1.setText(cliente2.getCpf());
			
			try {
		    	   DateFormat formatter; 
				      Date date;
		    	formatter = new SimpleDateFormat("yyyy-MM-dd");
				date = (Date)formatter.parse(cliente2.getData());
				 calendario.setDate(date);
			     
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		}
		else{
			txtnome.setEditable(true);
			txttelefone.setEditable(true);
			calendario.setEnabled(true);
			
			Cliente cliente3 = Cliente.find_cpf(cpf);
			txtnome.setText(cliente3.getNome());
			txtcpf1.setText(cpf);
			
			txttelefone.setText(cliente3.getTelefone());

			
			
			try {
		    	   DateFormat formatter; 
				      Date date;
		    	formatter = new SimpleDateFormat("yyyy-MM-dd");
				date = (Date)formatter.parse(cliente3.getData());
				 calendario.setDate(date);
			     
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
					
					
					
				}
			});
			
			
			JButton btnmarcar = new JButton("Marcar");
			FrameCentro.add(btnmarcar);
			btnmarcar.setBounds(10, 400,100, 30);
			btnmarcar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					Cliente cliente  = new Cliente();
					
					String cpf = String.valueOf(txtcpf1.getText());
					
					cliente.setNome(txtnome.getText());
					
					cliente.setStatus("remarcado");
					cliente.setTelefone(txttelefone.getText());
					final String data1 =new SimpleDateFormat("yyyy-MM-dd").format(calendario.getDate());
					cliente.setData(data1);
					
					final	String selecionaHora = String.valueOf(comboHora.getSelectedItem());
					cliente.setHorario(selecionaHora);
					cliente.atualiza_consulta(cpf);
					
					txtcpf.setText("");
					txtnome.setText("");
					txttelefone.setText("");
					txtcpf1.setText("");
				
					
				}
			});
			
			ImageIcon btnvolt = new ImageIcon("frente.png");
			  JButton btnvoltar = new JButton();	
			  btnvoltar.setIcon(btnvolt);
			  FrameCentro.add(btnvoltar);
			  btnvoltar.setBounds(590, 400, 50, 50);
			  btnvoltar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					new MenuPrincipal();
					FrameCentro.dispose();
					
				}
			});
			
			
			
			FrameCentro.setLayout(null);
			FrameCentro.setSize(680, 500);
			FrameCentro.setLocationRelativeTo(null);
			FrameCentro.setVisible(true);
			
			
			
			
			
}
	}
