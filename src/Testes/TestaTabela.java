package Testes;



//import Cliente;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TestaTabela extends JFrame {

	static JButton btnRegistrar;
	static JTable table;
	static JScrollPane scrollPane;
	static Container c;
	static TestaTabela v;

	public TestaTabela(){
	

		
		/*		
				super("Ejemplo tabla");
				c= getContentPane();
				setLayout(new FlowLayout());
				setSize(500,500);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				
				
				
				btnRegistrar = new JButton("Ver tabela");
				btnRegistrar.addActionListener(this);
				
				//tabla
				String[] columnas = {"Nome", "Endereco","idade","ultima consulta","telefone","cpf"};
				
				int i = Integer.parseInt(JOptionPane.showInputDialog("Quantos deseja consultar?"));
					
				for (int cont = 0;cont <i;++cont){
				Cliente cliente = Cliente.find(cont);
		
				ArrayList lista = new ArrayList<>();
				lista.add(cliente);
				for (int a = 0; a < lista.size(); a++) {
					Cliente cliente2 = (Cliente) lista.get(a);
					cliente.getNome();
				
					Object[][] datos= {
							
							{cliente2.getNome(),cliente2.getEndereco(),cliente2.getIdade(),cliente2.getData(),cliente2.getTelefone(),cliente2.getCpf()}
									
									
							 };
				
							
				
				table = new JTable(datos,columnas);
				scrollPane = new JScrollPane(table);
				scrollPane.setVisible(false);
				table.setPreferredScrollableViewportSize(new Dimension(300,150));
				
				
				//tabla
				
				}
				c.add(btnRegistrar);
				c.add(scrollPane);
				
				
				
				}
				
			}//constructor
			
			
			public static void main(String[] args) {
				v = new TestaTabela();
				v.setVisible(true);

			}

			@Override
			public void actionPerformed(ActionEvent ev) {
				if(ev.getSource().equals(btnRegistrar)){
					
					scrollPane.setVisible(true);
					v.validate();
					
					
				}
				
			}


			/*String[] nomes;
			nomes = new String[i];
			nomes[cont] = cliente.getNome();
			
			String[] endereços;
			endereços = new String[i];
			endereços[cont] = cliente.getEndereco();
			
			double [] idades;
			idades = new double[i];
			idades[cont] = cliente.getIdade();
			
			String[] ult_consult;
			ult_consult = new String[i];
			ult_consult[cont] = cliente.getData();
			
			
			String[] telefone;
			telefone = new String[i];
			telefone[cont] = cliente.getTelefone();
			
			String[] cpf;
			cpf = new String[i];
			cpf[cont] = cliente.getCpf();
	*/
	/*
	 * 
	 */
	}}

