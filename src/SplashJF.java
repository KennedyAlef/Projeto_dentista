import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;


public class SplashJF extends JFrame{

	 private static JProgressBar barra = new JProgressBar();
	    private static JFrame janela = new JFrame();
	    private static Color textcol1 = new Color(24 ,180 ,150);//verde
	
	 public SplashJF(){
		 
		 	janela.setLayout(null);
	       
		 	janela.setBackground(Color.white);
	        ImageIcon imagem = new ImageIcon("dentista.png");
	        JLabel paneltela = new JLabel();
	        paneltela.setBounds(5, 5, 301, 320);
	        paneltela.setIcon(imagem);
	        janela.add(paneltela);
	        
	        barra.setBounds(30, 190, 330, 15);
	        barra.setBorder(BorderFactory.createLineBorder(Color.black,1 ));
//	        barra.setStringPainted(true);
//	        barra.setFont(new Font("FreeMono", Font.BOLD,12));
	        paneltela.add(barra);
	        barra.setForeground(textcol1);
	        barra.setBackground(Color.white);
	        
	        janela.setSize(320,320);
	        janela.setLocationRelativeTo(null);
	        janela.setVisible(true);
	        janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
	    }
	    
		 
	    public static void carregar(){
	        for (int i = 0; i <=101; i++){
	            try {
	                Thread.sleep(20);
	                barra.setValue(i);
	                
	                if (i==101){
	                    janela.dispose();
	                }
	            } catch (InterruptedException e) {
	                JOptionPane.showMessageDialog(null, "Não possivel Carregar" + e.getMessage());
	                e.printStackTrace();
	            }
	        }
	    }
	}


	
