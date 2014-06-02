

import java.awt.Color;
import java.awt.Component;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;



public class Cliente implements Model {

	
	
	Connection connection;
	private String nome;
	private String endereco;
	private double idade;
	private String data_ult;
	private String horario_consulta;
	private String telefone;
	private String cpf;
	private String email;
	private String status;
	String horas[] = new String[37];
	ArrayList<String> horasfunc = new ArrayList<String>();
	ArrayList<String> horasdisponiveis = new ArrayList<String>();



	
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/pro_dentista";
	  private static final String DB_USER = "root";
	  private static final String DB_PASS = "";
	  
	  public Cliente(){
		  this.connection = null;
	  }
	 
	  public String getNome(){
		  return this.nome;
	  }
	  public void setNome(String nome){
		  this.nome = nome;
	  }
	  
	  public String getEndereco(){
		  return this.endereco;
	  }
	  public void setEndereco(String endereco){
		  this.endereco = endereco;
	  }
	  public double getIdade(){
		  return this.idade;
	  }
	  public void setIdade(double idade){
		  this.idade = idade;
	  }
	  
	  public String getData(){
		  return this.data_ult;
	  }
	  public void setData(String data){
		  this.data_ult = data;
	  }
	  public String getTelefone(){
		  return this.telefone;
	  }
	  public void setTelefone(String telefone){
		  this.telefone = telefone;
	  }
	  
	  public String getCpf(){
		  return this.cpf;
	  }
	  public void setcpf(String cpf){
		  this.cpf = cpf;
	  }
	  public String getEmail(){
		  return this.email;
	  }
	  public void setEmail(String email){
		  this.email = email;
	  }
	  public String getStatus(){
		  return this.status;
	  }
	  public void setStatus(String status){
		  this.status = status;
	  }
	  public String getHorario(){
		  return this.horario_consulta;
	  }
	  public void setHorario( String hora){
		  this.horario_consulta = hora;
	  }
	 
	  
	  
	  public static Cliente find(int id){
		  Cliente cliente = new Cliente();
	  
		  Connection connection = null;
		  try{
			  connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }

		String sql = "SELECT * FROM cliente where id = "+id;
		 
		try {
		      Statement stmt = (Statement) connection.createStatement();
		      ResultSet result = stmt.executeQuery(sql);
		      if (result.next()) {
		        
		    	cliente.setNome(result.getString("nome"));
		        cliente.setEndereco(result.getString("endereco"));
		        cliente.setIdade(result.getDouble("idade"));
		        cliente.setData((result.getString("ult_consulta")));
		        cliente.setHorario(result.getString("horario_consulta"));
		        cliente.setTelefone(result.getString("telefone"));   
		        cliente.setcpf(result.getString("cpf"));
		        cliente.setEmail(result.getString("email"));
		        cliente.setStatus(result.getString("status"));
		        JOptionPane.showMessageDialog(null, "Cliente encontrado");
		        
	  }
		}
	  catch (SQLException e){
		  e.printStackTrace();
	  }
		
		
		
		
				
		return cliente;
	  
		}
	  
	  public boolean save() {
		    Boolean saved = false;
		    
		    try {
		      connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		    Statement stmt = null;
		    
		    try {
		      stmt = (Statement) connection.createStatement();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }

		    ResultSet result = null;
		    try {
		      result = stmt.executeQuery("SELECT * FROM cliente WHERE cpf = '" + cpf + "'");
		    } catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		    
		    String sql = "";
		    
		    try {
		      if(result.next()) {
  
		        JOptionPane.showMessageDialog(null, "Cpf já cadastrado");
		        return false;
		        
		      } else {
		       
		    	  sql = "INSERT INTO cliente (nome, endereco, idade, ult_consulta, telefone,cpf, email,status,horario_consulta) " +
		                     "VALUES ('" + nome + "', '" + endereco+ "', '" + idade+ "', " +
		                     "'" + data_ult + "','"+telefone+"','"+cpf+"','"+email+"','"+status+"','"+horario_consulta+"') "; 
		    	  
		    	  JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		    	  
		    	  	
		      }
		    } catch (SQLException e1) {
		      // TODO Auto-generated catch block
		      e1.printStackTrace();
		    }
		    
		  //  System.out.println(sql);
		    
		    try {
		      saved = stmt.execute(sql);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		    return saved;
		  }
	  
	  public static Cliente deleta(int id){
			 Cliente cliente = new Cliente();
			 boolean saved = false;
			 
			 Connection connection = null;
			 
			  try{
				  connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }

			  Statement stmt = null;
			String sql = "SELECT * FROM cliente where id = "+id;
			 
			try {
			      stmt = (Statement) connection.createStatement();
			      ResultSet result = stmt.executeQuery(sql);
			      if (result.next()) {
			        
			    	  sql = "DELETE FROM cliente where id ="+id;
		  }
			}
		  catch (SQLException e){
			  e.printStackTrace();
		  }
			 try {
			      saved = stmt.execute(sql);
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
					JOptionPane.showMessageDialog(null, "Cliente "+id+" deletado com sucesso");
			return cliente;
		 }
	  
	  public static Cliente find_cpf(String cpf){
		  Cliente cliente = new Cliente();
	  
		  Connection connection = null;
		  try{
			  connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }

		String sql = "SELECT * FROM cliente where cpf = "+cpf;
		 
		try {
		      Statement stmt = (Statement) connection.createStatement();
		      ResultSet result = stmt.executeQuery(sql);
		      if (result.next()) {
		        
		    	cliente.setNome(result.getString("nome"));
		        cliente.setEndereco(result.getString("endereco"));
		        cliente.setIdade(result.getDouble("idade"));
		        cliente.setData((result.getString("ult_consulta")));
		        cliente.setHorario(result.getString("horario_consulta"));
		        cliente.setTelefone(result.getString("telefone"));   
		        cliente.setcpf(result.getString("cpf"));
		        cliente.setEmail(result.getString("email"));
		        cliente.setEmail(result.getString("status"));
		        JOptionPane.showMessageDialog(null, "Cliente encontrado");
		        
	  }
		      else{
		    	  JOptionPane.showMessageDialog(null, "Cpf não cadastrado");
		    	  
		      }
		}
	  catch (SQLException e){
		  e.printStackTrace();
	  }
		
		
		
		
				
		return cliente;
	  
		}
	  
	  public boolean atualiza(){
		  
		  Boolean update = false;
		    
		    try {
		      connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		    Statement stmt = null;
		    
		    try {
		      stmt = (Statement) connection.createStatement();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }

		    ResultSet result = null;
		    try {
		      result = stmt.executeQuery("SELECT * FROM cliente WHERE cpf = '" + cpf + "'");
		    } catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		    
		    String sql = "";
		    
		    try {
		      if(result.next()) {
		        sql = "UPDATE cliente SET nome = '"+nome+"', endereco	 = '"+endereco+"', " +
		        		  " idade = '"+idade+"', ult_consulta = '"+data_ult+"',horario_consulta = '"+horario_consulta+"',  telefone =  '"+telefone+"', cpf = '"+cpf+"', email = '"+email+"', status = '"+status+"'" +
		        		  		" where cpf ='"+cpf+"'";   
		        
		     
		        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
		        
		      } else {
		       
		    	  JOptionPane.showMessageDialog(null, "Cliente nao cadastrado");
		    	  return false;
		      }	
		    } catch (SQLException e1) {
		      // TODO Auto-generated catch block
		      e1.printStackTrace();
		    }
		    
		   //System.out.println(sql);
		    
		    try {
		      update = stmt.execute(sql);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		    return update;
		  }
		  
	  public ArrayList<String> getListaEnviar() {
		  
		  
		  ArrayList<String> array = new ArrayList<String>();
		  try {
              
              ArrayList<String> clientes = new ArrayList<String>();
           
    		  Connection connection = null;
    		  try{
    			  connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    		    } catch (SQLException e) {
    		      e.printStackTrace();
    		    }
    		  
    		  java.util.Date utilDate = new java.util.Date();
              java.sql.Date datahj = new java.sql.Date(utilDate.getTime());
              
    		  
    		  String sql = ("Select nome, ult_consulta from cliente WHERE ult_consulta = '" + datahj + "'");
    			 
    			try {
    			      Statement stmt = (Statement) connection.createStatement();
    			      ResultSet result = stmt.executeQuery(sql);
    			      
    			      while (result.next()) {
            	  Cliente c = new Cliente();
                  c.setData(result.getString("ult_consulta"));
                  c.setNome(result.getString("nome"));
                 // System.out.println(c.getData());
                  
                  
                
         
                  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
      		     java.sql.Date data = new java.sql.Date(format.parse(c.getData()).getTime());
      		     
      	     
      		
                
    		    	clientes.add(c.getNome()); 
    		    	
    		    	
    		
    			      
    			      }
    		  
    			      
              return clientes;
              }
              catch (Exception e) {
				e.printStackTrace();
			}
    		
    			
          }
      catch(Exception e2){
    	  e2.printStackTrace();
      }
          return array;
	  }
	  
	  public static Cliente find_nome(String nome){
		  Cliente cliente = new Cliente();
		  
		  Connection connection = null;
		  try{
			  connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }

		String sql = ("SELECT * FROM cliente WHERE nome = '" + nome + "'");
		 
		try {
			// System.out.println(sql);
		      Statement stmt = (Statement) connection.createStatement();
		      ResultSet result = stmt.executeQuery(sql);
		      if (result.next()) {
		        
		    	cliente.setNome(result.getString("nome"));
		        cliente.setEndereco(result.getString("endereco"));
		        cliente.setIdade(result.getDouble("idade"));
		        cliente.setData((result.getString("ult_consulta")));
		        cliente.setHorario(result.getString("horario_consulta"));
		        cliente.setTelefone(result.getString("telefone"));   
		        cliente.setcpf(result.getString("cpf"));
		        cliente.setEmail(result.getString("email"));
		        cliente.setStatus(result.getString("status"));
		        JOptionPane.showMessageDialog(null, "Cliente encontrado");
		        
	  }
		}
	  catch (SQLException e){
		  e.printStackTrace();
	  }
		
		
		
		
				
		return cliente;
	  
		}
		  
	  
	  public void getTable(JTable tblcliente) {
		  Object titulo1 [][] = {};
		  try{
			  connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }      
		  
		  java.util.Date utilDate = new java.util.Date();
          java.sql.Date datahj = new java.sql.Date(utilDate.getTime());
         
		  
		  
		 String sql = ("Select nome,ult_consulta, horario_consulta, status from cliente WHERE ult_consulta = '" + datahj + "' && status = 'em atendimento' order by horario_consulta");
			 
			try {
				// System.out.println(sql);
			      Statement stmt = (Statement) connection.createStatement();
			      ResultSet result = stmt.executeQuery(sql);
			
			      
	             Cliente cliente = new Cliente();
	                  ((DefaultTableModel) tblcliente.getModel()).addColumn("nome", titulo1); 
	                  ((DefaultTableModel) tblcliente.getModel()).addColumn("ult_consulta", titulo1) ; 
	                  ((DefaultTableModel) tblcliente.getModel()).addColumn("horario_consulta", titulo1); 
	                  ((DefaultTableModel) tblcliente.getModel()).addColumn("status", titulo1); 
	                  while (result.next()) {
	                      ((DefaultTableModel) tblcliente.getModel()).addRow(new Object[]{    
	                    		  result.getString(1).trim(),
	                    		  result.getString(2).trim(),
	                    		  result.getString(3).trim(),
	                    		  result.getString(4).trim(),
	                   
	                          });

	                  }
	                
	              } catch (SQLException e) {
	                  throw new RuntimeException(e);
	              }
	  }
	  
	  public void altera_status(String cpf1 , String status){
		  Boolean update = false;
		    
		    try {
		      connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		    Statement stmt = null;
		    
		    try {
		      stmt = (Statement) connection.createStatement();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }

		    ResultSet result = null;
		    try {
		     result = stmt.executeQuery("SELECT * FROM cliente WHERE cpf = '" + cpf1 + "'");
		      
		    } catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		    
		    String sql = "";
		    
		    try {
		      if(result.next()) {
		        sql = "UPDATE cliente SET status= '"+status+"' where cpf = '"+cpf1+"'";   
		       System.out.println(sql);
		        
		      } 
		      
		    } catch (SQLException e1) {
		      // TODO Auto-generated catch block
		      e1.printStackTrace();
		    }
		    
		   //System.out.println(sql);
		    
		    try {
		      update = stmt.execute(sql);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		  
		
		  
	  }
	
	 public void consulta_horario(String data ){
		 
		 Cliente c = new Cliente();
		 
		 
		 ArrayList<String> aux = new ArrayList<String>();
		  Connection connection = null;
		  try{
			  connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		  
		  String sql = ("Select  ult_consulta, horario_consulta from cliente WHERE ult_consulta = '" + data + "'");
			 
			try {
				 c.horas[0] = "08:00:00";
				 c.horas[1] = "08:15:00";
				 c.horas[2] = "08:30:00";
				 c.horas[3] = "08:45:00";
				 c.horas[4] = "09:00:00";
				 c.horas[5] = "09:15:00";
				 c.horas[6] = "09:30:00";
				 c.horas[7] = "09:45:00";
				 c.horas[8] = "10:00:00";
				 c.horas[9] = "10:15:00";
				 c.horas[10] = "10:30:00";
				 c.horas[11] = "10:45:00";
				 c.horas[12] = "11:00:00";
				 c.horas[13] = "11:15:00";
				 c.horas[14] = "11:30:00";
				 c.horas[15] = "11:45:00";
				 c.horas[16] = "12:00:00";
				 c.horas[17] = "12:15:00";
				 c.horas[18] = "12:30:00";
				 c.horas[19] = "12:45:00";
				 c.horas[20] = "13:00:00";
				 c.horas[21] = "13:15:00";
				 c.horas[22] = "13:30:00";
				 c.horas[23] = "13:45:00";
				 c.horas[24] = "14:00:00";
				 c.horas[25] = "14:15:00";
				 c.horas[26] = "14:30:00";
				 c.horas[27] = "14:45:00";
				 c.horas[28] = "15:00:00";
				 c.horas[29] = "15:45:00";
				 c.horas[30] = "16:00:00";
				 c.horas[31] = "16:15:00";
				 c.horas[32] = "16:30:00";
				 c.horas[33] = "16:45:00";
				 c.horas[34] = "17:00:00";		
				 
				 for ( int i = 0 ; i<35;i++){
		    		  horasdisponiveis.add(c.horas[i]);
		    	  }
				
			      Statement stmt = (Statement) connection.createStatement();
			      ResultSet result = stmt.executeQuery(sql);
			     
	     
			      
			      while (result.next()) {
			
            c.setData(result.getString("ult_consulta"));
            c.setHorario(result.getString("horario_consulta"));
            aux.add(c.getHorario());
            
            int a=0;
 
            do{
            	
            	for(int i=0;i<35;i++){
            		
            if(c.horas[i].equals(aux.get(a))){
            	
            	 horasdisponiveis.remove(c.horas[i]);
            	 
            }
         
            }

            	a++;
            	}while(a<aux.size() ); 
         
            }
			      
			      /*if(!result.next()){
			    	  for ( int i = 0 ; i<35;i++){
			    		  horasdisponiveis.add(c.horas[i]);
			    	  } 
			    	  
			      }*/
			      								
			      }
			      catch (Exception e) {
						e.printStackTrace();
					}
	
			
}
  
	 public boolean atualiza_consulta(String cpf){
		  Boolean update = false;
		    
		    try {
		      connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		    Statement stmt = null;
		    
		    try {
		      stmt = (Statement) connection.createStatement();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }

		    ResultSet result = null;
		    try {
		      result = stmt.executeQuery("SELECT * FROM cliente WHERE cpf = '" + cpf + "'");
		    } catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		    
		    String sql = "";
		    
		    try {
		      if(result.next()) {
		        sql = "update cliente set nome = '"+nome+"',telefone = '"+telefone+"',ult_consulta ='"+data_ult+"', horario_consulta ='"+horario_consulta+"' where cpf = '"+cpf+"'";             
		       
		        JOptionPane.showMessageDialog(null, "Consulta Marcada	");
		        
		      } else {
		       
		    	  JOptionPane.showMessageDialog(null, "Cliente nao cadastrado");
		    	  return false;
		      }	
		    } catch (SQLException e1) {
		      // TODO Auto-generated catch block
		      e1.printStackTrace();
		    }
		    
		   //System.out.println(sql);
		    
		    try {
		      update = stmt.execute(sql);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		    return update;
		  
	 }
	 
	 public void getTableTotal(JTable tblcliente) {
		  Object titulo1 [][] = {};
		  try{
			  connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }      
		  
		  java.util.Date utilDate = new java.util.Date();
         java.sql.Date datahj = new java.sql.Date(utilDate.getTime());
        
		  
		  
		 String sql = ("Select nome,ult_consulta, horario_consulta, status from cliente WHERE ult_consulta >= '" + datahj + "' order by horario_consulta");
			 
			try {
				// System.out.println(sql);
			      Statement stmt = (Statement) connection.createStatement();
			      ResultSet result = stmt.executeQuery(sql);
			
			      
	             Cliente cliente = new Cliente();
	                  ((DefaultTableModel) tblcliente.getModel()).addColumn("nome", titulo1); 
	                  ((DefaultTableModel) tblcliente.getModel()).addColumn("ult_consulta", titulo1) ; 
	                  ((DefaultTableModel) tblcliente.getModel()).addColumn("horario_consulta", titulo1); 
	                  ((DefaultTableModel) tblcliente.getModel()).addColumn("status", titulo1); 
	                  while (result.next()) {
	                      ((DefaultTableModel) tblcliente.getModel()).addRow(new Object[]{    
	                    		  result.getString(1).trim(),
	                    		  result.getString(2).trim(),
	                    		  result.getString(3).trim(),
	                    		  result.getString(4).trim(),
	                   
	                          });

	                  }
	                
	              } catch (SQLException e) {
	                  throw new RuntimeException(e);
	              }
	  }

	 public boolean login(String usuario, String senha){
		 
		 boolean log = false;
		 
		 try {
		      connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		    Statement stmt = null;
		    
		    try {
		      stmt = (Statement) connection.createStatement();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    ResultSet result = null;
		    try {
		      result = stmt.executeQuery("SELECT usuario, senha from admin where usuario= '" + usuario+ "' && senha = '"+senha+"'");
		    } catch (SQLException e2) {
		      e2.printStackTrace();
		    }
		    try{
		    if(result.next()){
		     log = true;
		    	
		    }
		    else{
		    	log = false;
		    }
		    }
		    catch (SQLException e1) {
			      // TODO Auto-generated catch block
			      e1.printStackTrace();
			    }
	 return log;
	 }
}
          


	   

	  
	  

