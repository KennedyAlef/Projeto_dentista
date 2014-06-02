import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.lang.Object;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.JCalendarDemo;


public class MenuCadastro extends JFrame{

	public MenuCadastro(){
	final JFrame FrameCentro = new JFrame();
	Container c = FrameCentro.getContentPane();
	

 final	Color corAzul = new Color (44,167,206);
	c.setBackground(Color.white);
	FrameCentro.setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	// ** TITULO E TEXTO ID
	JLabel lblid = new JLabel("ID ");
	FrameCentro.add(lblid);
	lblid.setForeground(Color.black);
	lblid.setFont(new Font("Comic Sans Ms", Font.BOLD, 16));
	lblid.setBounds(25, 10, 100, 30);
	
	final JTextField txtid = new JTextField("");
	FrameCentro.add(txtid);
	txtid.setBounds(100, 10, 50, 30);
	txtid.setForeground(Color.black);
	txtid.setBackground(Color.white);
	
	
	
	// *** TITULO E TEXTO NOME
	
	JLabel lblnome = new JLabel("NOME ");
	FrameCentro.add(lblnome);
	lblnome.setForeground(Color.black);
	lblnome.setFont(new Font("Comic Sans Ms", Font.BOLD,14));
	lblnome.setBounds(10, 60, 100, 20);
	
	final JTextField txtnome = new JTextField("");
	FrameCentro.add(txtnome);
	txtnome.setForeground(Color.black);
	txtnome.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	txtnome.setBounds(10, 80, 250, 25);
	txtnome.setEditable(false);
	
	// ** TITULO E TEXTO ENDERECO;
	
	JLabel lblendereco = new JLabel("ENDERECO ");
	FrameCentro.add(lblendereco);
	lblendereco.setForeground(Color.black);
	lblendereco.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	lblendereco.setBounds(10, 105, 100, 20);
	
	final JTextField txtendereco = new JTextField("");
	FrameCentro.add(txtendereco);
	txtendereco.setForeground(Color.black);
	txtendereco.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	txtendereco.setBounds(10, 125, 250, 25);
	txtendereco.setEditable(false);
	
	//** TITULO E TEXTO IDADE
	
	JLabel lblidade = new JLabel("IDADE ");
	FrameCentro.add(lblidade);
	lblidade.setForeground(Color.black);
	lblidade.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	lblidade.setBounds(10, 145, 100, 25);
	
	final JTextField txtidade = new JTextField("");
	FrameCentro.add(txtidade);
	txtidade.setForeground(Color.black);
	txtidade.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	txtidade.setBounds(10, 170, 250, 25);
	txtidade.setEditable(false);
	
	//** TITULO E TEXTO ULTIMA CONSULTA
	
	JLabel lbldata = new JLabel("CONSULTA ");
	FrameCentro.add(lbldata);
	lbldata.setForeground(Color.black);
	lbldata.setFont(new Font("Comic Sans Ms",Font.BOLD,14));
	lbldata.setBounds(10, 210, 150, 20);
	
	final JDateChooser calendario = new JDateChooser(new java.util.Date(), "yyyy/MM/dd"); 
	FrameCentro.add(calendario);
	calendario.setBounds(100, 210, 150, 20);
	final String data1 =new SimpleDateFormat("yyyy-MM-dd").format(calendario.getDate());
	
	calendario.setEnabled(false);


	//  **** HORARIO
	
	JLabel lblhorario = new JLabel("HORARIO");
	FrameCentro.add(lblhorario);
	lblhorario.setForeground(Color.black);
	lblhorario.setFont(new Font("Comic Sans Ms ", Font.BOLD, 14));
	lblhorario.setBounds(10, 240, 100, 30);
	 final JComboBox comboHora = new JComboBox();
	 comboHora.removeAllItems();
	  comboHora.setBounds(10, 270, 200, 20);
	  comboHora.setEnabled(false);
	  FrameCentro.add(comboHora);
	  
	
	
	//*** BOTAO PESQUISA CONSULTA	
	
	ImageIcon imconsultahorario = new ImageIcon("Lupa.png");
	final JButton btnconsultaHorario = new JButton();
	btnconsultaHorario.setIcon(imconsultahorario);
	btnconsultaHorario.setBounds(270, 205, 40, 30);
	btnconsultaHorario.setEnabled(false);
	FrameCentro.add(btnconsultaHorario);
	
	btnconsultaHorario.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		
			final String data1 =new SimpleDateFormat("yyyy-MM-dd").format(calendario.getDate());

			
			System.out.println("DATA: "+data1);
			
			
			Cliente cliente = new Cliente();
			
			cliente.consulta_horario(data1);
			

			
			  
			  
			  for (int i = 0 ; i<cliente.horasdisponiveis.size();i++){
				  comboHora.addItem(cliente.horasdisponiveis.get(i));
				  
			  }
			
			
		}
		
	
	});
	
	
	
	// ** TITULO E TEXTO TELEFONE
	
	JLabel lbltelefone = new JLabel("TELEFONE:");
	FrameCentro.add(lbltelefone);
	lbltelefone.setForeground(Color.black);
	lbltelefone.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	lbltelefone.setBounds(10, 300, 100, 20);
	
	final JTextField txttelefone = new JTextField("");
	FrameCentro.add(txttelefone);
	txttelefone.setForeground(Color.black);
	txttelefone.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	txttelefone.setBounds(10, 320, 250, 25);
	txttelefone.setEditable(false);
	
	//** TITULO E TEXTO CPF
	
	JLabel lblcpf = new JLabel("CPF: ");
	FrameCentro.add(lblcpf);
	lblcpf.setForeground(Color.black);
	lblcpf.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	lblcpf.setBounds(10, 345, 100, 20);
	
	final JTextField txtcpf = new JTextField("");
	FrameCentro.add(txtcpf);
	txtcpf.setForeground(Color.black);
	txtcpf.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	txtcpf.setBounds(10, 370, 250, 25);
	txtcpf.setEditable(false);
	
	//** TITULO E TEXTO EMAIL
	
	JLabel lblemail = new JLabel("E-MAIL: ");
	FrameCentro.add(lblemail);
	lblemail.setForeground(Color.black);
	lblemail.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	lblemail.setBounds(10, 400, 100, 20);
	
	final JTextField txtemail = new JTextField("");
	FrameCentro.add(txtemail);
	txtemail.setForeground(Color.black);
	txtemail.setFont(new Font("Comic Sans Ms", Font.BOLD, 14));
	txtemail.setBounds(10, 420, 250, 25);
	txtemail.setEditable(false);
	

	// **  BOTAO PESQUISAR
	final JButton btnpesquisa = new JButton("Pesquisar");
	FrameCentro.add(btnpesquisa);
	btnpesquisa.setBounds(170, 10, 100, 30);
	btnpesquisa.setBackground(corAzul);
	btnpesquisa.setBorderPainted(false);
	btnpesquisa.setForeground(Color.black);
	btnpesquisa.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int id = Integer.parseInt(txtid.getText());
			
			Cliente cliente = Cliente.find(id);
			
			String nome = cliente.getNome();
			txtnome.setText(nome);
			
			String endereco = cliente.getEndereco();
			txtendereco.setText(endereco);
			
			Double idade = cliente.getIdade();
			txtidade.setText(String.valueOf(idade));
			
			
			// ** CONVERSÃO DE STRING PARA DATA DO CALENDARIO     
			      try {
			    	   DateFormat formatter; 
					      Date date;
			    	formatter = new SimpleDateFormat("yyyy-MM-dd");
					date = (Date)formatter.parse(cliente.getData());
					 calendario.setDate(date);
				     
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			     
			  	
			String telefone = cliente.getTelefone();
			txttelefone.setText(telefone);
				
			String cpf = cliente.getCpf();
			txtcpf.setText(cpf);
			
			String email = cliente.getEmail();
			txtemail.setText(email);
		}
	});
	
	// ** BOTAO CADASTRO 
	
	
	final JButton btncadastro = new JButton("Cadastrar");
		FrameCentro.add(btncadastro);
		btncadastro.setBorderPainted(false);
		btncadastro.setBackground(corAzul);
		btncadastro.setForeground(Color.black);
		btncadastro.setBounds(10, 460, 100, 30);
		
		btncadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtid.setText(" ");
				txtid.setEditable(false);
				txtnome.setText("");
				txtnome.setEditable(true);
				txtendereco.setText("");
				txtendereco.setEditable(true);
				txtidade.setText("");
				txtidade.setEditable(true);
				calendario.setDate(calendario.getDate());
				calendario.setEnabled(true);
				txttelefone.setText("");
				txttelefone.setEditable(true);
				txtcpf.setText("");
				txtcpf.setEditable(true);
				txtemail.setText("");
				txtemail.setEditable(true);
				comboHora.setEnabled(true);
				btnconsultaHorario.setEnabled(true);
				
				btnpesquisa.setVisible(false);
				
				
				JButton salvar = new JButton("Salvar");
				FrameCentro.add(salvar);
				salvar.setBackground(corAzul);
				salvar.setForeground(Color.black);
				salvar.setBounds(170, 10, 100, 30);
				salvar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Cliente cliente = new Cliente();
						cliente.setNome(txtnome.getText());
						cliente.setEndereco(txtendereco.getText());
						cliente.setIdade(Double.parseDouble(txtidade.getText()));
						cliente.setData(data1);
						cliente.setTelefone(txttelefone.getText());
						cliente.setcpf(txtcpf.getText());
						cliente.setEmail(txtemail.getText());
						cliente.setStatus("remarcado");
						final	String selecionaHora = String.valueOf(comboHora.getSelectedItem());
						cliente.setHorario(selecionaHora);
						cliente.save();
						
					}
				});
								
			}
		});
	

	JButton btnatualizar = new JButton("Atualizar");
	FrameCentro.add(btnatualizar);
	btnatualizar.setBackground(corAzul);
	btnatualizar.setBorderPainted(false);
	btnatualizar.setForeground(Color.black);
	btnatualizar.setBounds(120, 460, 100, 30);
	btnatualizar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			txtid.setEditable(false);
			txtnome.setText("");
			txtendereco.setText("");
			txtidade.setText("");
			calendario.getDate();
			txttelefone.setText("");
			txtemail.setText("");
			txtcpf.setText("");
			txtcpf.setEditable(true);
			txtcpf.setBackground(Color.white);
			txtcpf.setForeground(Color.black);
			btnpesquisa.setVisible(false);
			
			//** BOTAO PESQUISA PARA ATUALIZAR PELO CPF
			
			final JButton btnpesquisacpf = new JButton("Pesquisar");
			FrameCentro.add(btnpesquisacpf);
			btnpesquisacpf.setBackground(corAzul);
			btnpesquisacpf.setForeground(Color.black);
			btnpesquisacpf.setBounds(170, 10, 100, 30);
			btnpesquisacpf.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
				final String cpf = String.valueOf(txtcpf.getText());
					Cliente cliente = Cliente.find_cpf(cpf);
					txtnome.setText(cliente.getNome());
					txtendereco.setText(cliente.getEndereco());
					txtidade.setText(String.valueOf(cliente.getIdade()));
					
					 try 
					    {  
					      DateFormat formatter; 
					      Date date; 
					      formatter = new SimpleDateFormat("yyyy/MM/dd");
					      date = (Date)formatter.parse(cliente.getData()); 
					      calendario.setDate(date);
					    } 
					    catch (Exception e)
					    {}
					
					
					txttelefone.setText(cliente.getTelefone());
					txtemail.setText(cliente.getEmail());
					
					txtnome.setEditable(true);
					txtendereco.setEditable(true);
					txtidade.setEditable(true);
					calendario.setEnabled(true);
					txttelefone.setEditable(true);
					txtcpf.setEditable(true);
					txtemail.setEditable(true);
					btncadastro.setVisible(false);
					btnconsultaHorario.setEnabled(true);
					comboHora.setEnabled(true);
					
					// BOTAO SALVAR ATUALIZAÇÃO
					
				final JButton btnsalvarup = new JButton("Salvar");
					FrameCentro.add(btnsalvarup);
					btnsalvarup.setBackground(corAzul);
					btnsalvarup.setForeground(Color.black);
					btnsalvarup.setBounds(10, 460, 100, 30);
					btnsalvarup.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Cliente cliente = new Cliente();
							cliente.setNome(txtnome.getText());
							cliente.setEndereco(txtendereco.getText());
							cliente.setIdade(Double.parseDouble(txtidade.getText()));
							cliente.setData(data1);
							cliente.setTelefone(txttelefone.getText());
							cliente.setcpf(txtcpf.getText());
							cliente.setEmail(txtemail.getText());
							final	String selecionaHora = String.valueOf(comboHora.getSelectedItem());
							cliente.setHorario(selecionaHora);
							cliente.setStatus("remarcado");
							cliente.atualiza();
							txtnome.setText(" ");
							txtnome.setEditable(false);
							txtendereco.setText(" ");
							txtendereco.setEditable(false);
							txtidade.setText(" ");
							txtidade.setEditable(false);
							calendario.setDate(calendario.getDate());
							calendario.setEnabled(false);
							txttelefone.setText(" ");
							txttelefone.setEditable(false);
							txtcpf.setText(" ");
							txtcpf.setEditable(false);
							txtemail.setText("");
							txtemail.setEditable(false);
							btnsalvarup.setVisible(false);
							btncadastro.setVisible(true);
							txtid.setEditable(true);
							comboHora.removeAllItems();
							comboHora.setEnabled(false);
							btnconsultaHorario.setEnabled(false);
							
							
							
						}
					});
					
					
				}
			});
			
		}
	});
	

	ImageIcon imglogo = new ImageIcon("dentelogo.jpg");
	JLabel lbllogo = new JLabel();
	lbllogo.setIcon(imglogo);
	lbllogo.setBounds(430, 40, 340, 444);
	FrameCentro.add(lbllogo);
	
	 ImageIcon btnvolt = new ImageIcon("frente.png");
	  JButton btnvoltar = new JButton();	
	  btnvoltar.setIcon(btnvolt);
	  FrameCentro.add(btnvoltar);
	  btnvoltar.setBounds(0, 500, 50, 50);
	  btnvoltar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			new MenuPrincipal();
			FrameCentro.dispose();
			
		}
	});
	
	
	FrameCentro.setSize(780, 600);
	FrameCentro.setLocationRelativeTo(null);
	FrameCentro.setLayout(null);
	FrameCentro.setVisible(true);
	
	}
}
