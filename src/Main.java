import java.awt.Color;
import java.awt.Container;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;




public class Main extends JFrame {
	
	public static void main(String [] args)  {
		
	
		//	new Login();
		
	
		  SplashJF splash = new SplashJF();
	        splash.setVisible(true);
	        splash.carregar();
	        
	        splash.dispose();
	        new Login();
	    }	
		 
		
	/* 	Cliente cliente = new Cliente();
		
		cliente.consulta_horario("2015-05-30");
		for ( int i = 0 ; i<cliente.horasdisponiveis.size();i++){
			
			System.out.println(cliente.horasdisponiveis.get(i));
		}
		
		System.out.println("Tamanho da lista :"+cliente.horasdisponiveis.size());
		
		
	
		
		
	
		new MarcaConsulta();
		
	/*	java.util.Date utilDatetemp = new java.util.Date();
        java.sql.Date datahjtempo = new java.sql.Date(utilDatetemp.getTime());
      
		  Cliente cliente = Cliente.find(4);
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		   java.sql.Date datatemp = new java.sql.Date(format.parse(cliente.getData()).getTime());
        
		long defit = (cliente.getHorario().getTime() + datatemp.getTime()) - datahjtempo.getTime();
		System.out.println("DEFITI: "+defit);
		if( defit > datahjtempo.getTime()){
			System.out.println("CONSULTA");
		}
		else{
			System.out.println("ATRASADO");
		}
		   /*  if(cliente.getHorario().getTime() + datatemp.getTime() > datahjtempo.getTime()){
		   System.out.println("Consulta a realizar");
		   }
		   else{
			   System.out.println("ATRASADO");
		   }
        
      /*  Cliente cliente = Cliente.find(1);
        if(cliente.getHorario().getTime() >= tempo.getTime()){
        	System.out.println("MAIOR");
        	
        }
        else{
        	System.out.println("MENIR");
        }*/
        
		//new TestaCombo();
	/*	java.util.Date tdata = new java.util.Date();
		tdata.getDate();
		
		
		
		String dt = "10/01/1995";
		Cliente cliente = Cliente.find(1);
		ArrayList lista = new ArrayList<>();
		System.out.println(cliente.getData());
		 java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    System.out.println("utilDate:" + utilDate);
		    System.out.println("sqlDate:" + sqlDate);
		    
		    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
		    java.sql.Date data = new java.sql.Date(format.parse(dt).getTime()); 
		   
		    System.out.println(sqlDate.getTime());
		    System.out.println(data.getTime());
		    System.out.println(data);
	*/
	}
	