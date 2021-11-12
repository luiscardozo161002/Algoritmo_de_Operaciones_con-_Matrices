package com.operacionmatriz.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class FrmOperacionesConMatrices extends JFrame {

	private JPanel contentPane;
	private JTextField txtOperacionesConMatrices;
	private JTextField txtMatrizA;
	private JTextField txtMatrizB;
	private JTextField txtFilasA;
	private JTextField txtResultado;
	private JComboBox cmbTipoOperacion;
	private JTextField txtTipoDeOperacin;
	private JTextField txtColumnasA;
	private JTextField txtColumnasB;
	private JTextField txtFilasB;
	private JTextField txtSumaYResta;
	private JTextField txtMultiplicacinDeMatrices;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNocolumnas_2;
	private JTextField txtMatrizB_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtFilA;
	private JTextField txtColumA;
	private JTextField txtFilB;
	private JTextField txtColumB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmOperacionesConMatrices frame = new FrmOperacionesConMatrices();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmOperacionesConMatrices() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmOperacionesConMatrices.class.getResource("/com/operacionmatriz/recursos/IconoCalculadoraMatrices.PNG")));
		setBackground(Color.LIGHT_GRAY);
		setForeground(SystemColor.menuText);
		setTitle("Calculadora: Operaciones con Matrices");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 383);
		contentPane = new JPanel();  
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtOperacionesConMatrices = new JTextField();
		txtOperacionesConMatrices.setForeground(Color.BLACK);
		txtOperacionesConMatrices.setBackground(SystemColor.inactiveCaption);
		txtOperacionesConMatrices.setEditable(false);
		txtOperacionesConMatrices.setHorizontalAlignment(SwingConstants.CENTER);
		txtOperacionesConMatrices.setText("Matrices");
		txtOperacionesConMatrices.setBounds(10, 11, 778, 20);
		contentPane.add(txtOperacionesConMatrices);
		txtOperacionesConMatrices.setColumns(10);
		
		txtMatrizA = new JTextField();
		txtMatrizA.setForeground(Color.BLACK);
		txtMatrizA.setBackground(SystemColor.inactiveCaption);
		txtMatrizA.setEditable(false);
		txtMatrizA.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatrizA.setText("Matriz A");
		txtMatrizA.setBounds(10, 129, 165, 20);
		contentPane.add(txtMatrizA);
		txtMatrizA.setColumns(10);
		
		txtMatrizB = new JTextField();
		txtMatrizB.setForeground(Color.BLACK);
		txtMatrizB.setBackground(SystemColor.inactiveCaption);
		txtMatrizB.setEditable(false);
		txtMatrizB.setText("Matriz B");
		txtMatrizB.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatrizB.setColumns(10);
		txtMatrizB.setBounds(10, 207, 165, 20);
		contentPane.add(txtMatrizB);
		
		JLabel lblNewLabel =  new JLabel("No.Filas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 151, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtFilasA = new JTextField();
		txtFilasA.setBounds(10, 164, 75, 28);
		contentPane.add(txtFilasA);
		txtFilasA.setColumns(10);
		
		JLabel lblNocolumnas = new JLabel("No.Columnas");
		lblNocolumnas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNocolumnas.setBounds(77, 151, 98, 14);
		contentPane.add(lblNocolumnas);
		
		TextArea txtResultadoMatriz = new TextArea();
		txtResultadoMatriz.setBounds(363, 98, 406, 205);
		contentPane.add(txtResultadoMatriz);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(Color.BLACK);
		btnBorrar.setBackground(Color.LIGHT_GRAY);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmbTipoOperacion.setSelectedIndex(0);
				txtFilasA.setText(null);
				txtColumnasA.setText(null);
				txtFilasB.setText(null);
				txtColumnasB.setText(null);
		        txtResultadoMatriz.setText(null);
			}
		});
		btnBorrar.setBounds(363, 309, 89, 23);
		contentPane.add(btnBorrar);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setForeground(Color.BLACK);
		btnCalcular.setBackground(Color.LIGHT_GRAY);
		btnCalcular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {	
		
		int TipoOperacionMatriz=0;		
		
		try {
		//Extraer la opcion seleccionada del comboBox
		TipoOperacionMatriz=cmbTipoOperacion.getSelectedIndex();	
	   
		int filasA=Integer.parseInt(txtFilasA.getText());
		int columnasA=Integer.parseInt(txtColumnasA.getText());
		int filasB=Integer.parseInt(txtFilasA.getText());
		int columnasB=Integer.parseInt(txtColumnasA.getText());
		
		int matrizA[][]=new int[filasA][columnasA];
        int matrizB[][]=new int[filasB][columnasB];
	    int matRes[][]=new int[filasA][columnasB];
		

	    //Condicionales del getSelectedIndex();     
	   if (TipoOperacionMatriz==1) {
	    	
	   //Ingreso datos de la matriz A
	   JOptionPane.showMessageDialog(null,"Datos de la Matriz A","Datos", JOptionPane.INFORMATION_MESSAGE);
	   txtResultadoMatriz.append("\nDatos de la Matriz A\n");
	  
	   for(int i=0;i<filasA;i++){
	      for(int j=0;j<columnasA;j++){
	         matrizA[i][j]=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la posición: a["+i+"]["+j+"]"+" de la matriz A"));
	                             txtResultadoMatriz.append(matrizA[i][j]+" ");
	                 }
	                      txtResultadoMatriz.append("\n");
	         }

	   //Ingreso datos de la matriz B
	          JOptionPane.showMessageDialog(null,"Datos de la Matriz B","Datos", JOptionPane.INFORMATION_MESSAGE);
	          txtResultadoMatriz.append("\nDatos de la Matriz B\n");
	          
	          for(int i=0;i<filasB;i++){
	                        for(int j=0;j<columnasB;j++){
	                                matrizB[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la posición: a["+i+"]["+j+"]"+" de la matriz B"));                            
	                                txtResultadoMatriz.append(matrizB[i][j]+" ");
	                        }
	                        txtResultadoMatriz.append("\n");
	                }
	                
	    //Resultado de la suma de matrices                             
	          JOptionPane.showMessageDialog(null,"Suma de las  matrices","Tipo de Operación", JOptionPane.INFORMATION_MESSAGE);
	          txtResultadoMatriz.append("\nResultado de la Suma de Matrices\n");
	          for(int i=0;i<filasA;i++){
                  for(int j=0;j<columnasB;j++){
                          matRes[i][j]+= matrizA[i][j]+matrizB[i][j];                            
                          txtResultadoMatriz.append(matRes[i][j]+" ");
                  }
                  txtResultadoMatriz.append("\n");
             }
	          
	           
	   } else if(TipoOperacionMatriz==2){
		   //Ingreso datos de la matriz A
		   JOptionPane.showMessageDialog(null,"Datos de la Matriz A","Datos", JOptionPane.INFORMATION_MESSAGE);
		   txtResultadoMatriz.append("\nDatos de la Matriz A\n");
		   for(int i=0;i<filasA;i++){
		      for(int j=0;j<columnasA;j++){
		                  matrizA[i][j]=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa para la posición: a["+i+"]["+j+"]"+" de la matriz A"));
		                            txtResultadoMatriz.append(matrizA[i][j]+" ");
		                 }
		                  txtResultadoMatriz.append("\n");
		         }

		     //Ingreso datos de la matriz B
		          JOptionPane.showMessageDialog(null,"Datos de la Matriz B","Datos", JOptionPane.INFORMATION_MESSAGE);
		          txtResultadoMatriz.append("\nDatos de la Matriz B\n");
		          for(int i=0;i<filasB;i++){
		                        for(int j=0;j<columnasB;j++){
		                                matrizB[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la posición: a["+i+"]["+j+"]"+" de la matriz B"));                            
		                                txtResultadoMatriz.append(matrizB[i][j]+" ");
		                        }
		                      txtResultadoMatriz.append("\n");
		                }		   
		      
		          
		         
	                JOptionPane.showMessageDialog(null,"Resta de las matrices","Tipo de Operación", JOptionPane.INFORMATION_MESSAGE);
	                txtResultadoMatriz.append("\nResultado de la Resta de Matrices\n");
	               
	                for(int i=0;i<filasA;i++){
	                        for(int j=0;j<columnasB;j++){
	                                matRes[i][j]+= matrizA[i][j]-matrizB[i][j];                            
	                                txtResultadoMatriz.append(matRes[i][j]+" ");
	                        }
	                        txtResultadoMatriz.append("\n");
	                   }  
	  
	                    
	   }else if(TipoOperacionMatriz==4) {       
		   
		   //if para verificar que se pueda realizar la multiplicación
           if(filasA==columnasB){
              
        	 //Ingreso datos de la matriz A 
           	JOptionPane.showMessageDialog(null,"Datos de la Matriz A","Datos", JOptionPane.INFORMATION_MESSAGE);
           	 txtResultadoMatriz.append("\nDatos de la Matriz A\n");
                   for(int i=0;i<filasA;i++){
                           for(int j=0;j<columnasA;j++){
                                   matrizA[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la posición: a["+i+"]["+j+"]"+" de la matriz A"));
                                   txtResultadoMatriz.append(matrizA[i][j]+" ");
                           }
                           txtResultadoMatriz.append("\n");
                   }

                 //Ingreso datos de la matriz B
                 JOptionPane.showMessageDialog(null,"Datos de la Matriz B","Datos", JOptionPane.INFORMATION_MESSAGE);
                 txtResultadoMatriz.append("\nDatos de la Matriz B\n");
                   for(int i=0;i<filasB;i++){
                           for(int j=0;j<columnasB;j++){
                                   matrizB[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la posición: a["+i+"]["+j+"]"+" de la matriz B"));                               
                                   txtResultadoMatriz.append(matrizB[i][j]+" ");
                           }
                           txtResultadoMatriz.append("\n");
                   }
           }
	       //Ingreso del valor escalar   
           int Escalar = Integer.parseInt(JOptionPane.showInputDialog("Valor del Escalar"));
           //Seleccion del tipo de matriz a multiplicar
           int opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la matriz a multiplicar 1(A ó 2(B"));
           //Selección de la matriz A por el Escalar
           if(opcion == 1){
        	   //Ingreso de los datos de la matriz A
        	   JOptionPane.showMessageDialog(null,"Datos de la Matriz A","Datos", JOptionPane.INFORMATION_MESSAGE);
             	txtResultadoMatriz.append("\nResultado de la Matriz por Escalar\n");
             	  for(int i=0;i<filasA;i++){
                      for(int j=0;j<columnasB;j++){
                              matRes[i][j]+= matrizA[i][j]*Escalar;                            
                              txtResultadoMatriz.append(matRes[i][j]+" ");
                      }
                      txtResultadoMatriz.append("\n");
                 }
     
           }else{
        	   //Ingreso de los datos de la matriz B
        	   JOptionPane.showMessageDialog(null,"Datos de la Matriz A","Datos", JOptionPane.INFORMATION_MESSAGE);
             	txtResultadoMatriz.append("\nResultado de la Matriz por Escalar\n");
             //Selección de la matriz B por el Escalar 	
               if(opcion == 2){
            	   for(int i=0;i<filasA;i++){
                       for(int j=0;j<columnasB;j++){
                               matRes[i][j]+= matrizB[i][j]*Escalar;                            
                               txtResultadoMatriz.append(matRes[i][j]+" ");
                       }
                       txtResultadoMatriz.append("\n");
                  }
            	 
               }else{
            	   //Sí ingresa un valor de matriz diferente a las dos opciones a dar
            	   JOptionPane.showMessageDialog(null,"La opción ingresada es inválida","Error", JOptionPane.ERROR_MESSAGE);
               }
           }
              
           }else {
        	   //Sí no elige un tipo de operación a realizar
	        	  JOptionPane.showMessageDialog(null,"Debe elegir un tipo de operación con matrices a realizar","Error", JOptionPane.ERROR_MESSAGE);
	          }
	    
	     //Excepcion al dejar campos en blanco dentro del programan
		 }catch(NumberFormatException e){
		 JOptionPane.showMessageDialog(null,"Operación Realizada con Éxito","Mensaje", JOptionPane.INFORMATION_MESSAGE);		
		}
	    	
 	}

});
		btnCalcular.setBounds(532, 309, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setBackground(Color.LIGHT_GRAY);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
		   public void mouseClicked(MouseEvent e) {
		   int Salida=JOptionPane.showConfirmDialog(null,"¿Estás seguro de salir del programa?","Salir del Programa",JOptionPane.WARNING_MESSAGE);
		   if (Salida==0) {
			   System.exit(0);
		   }else if(Salida==1){
			 
		   }
		   
	     }
		});
		btnSalir.setBounds(680, 309, 89, 23);
		contentPane.add(btnSalir);
		
		txtResultado = new JTextField();
		txtResultado.setForeground(Color.BLACK);
		txtResultado.setBackground(SystemColor.inactiveCaption);
		txtResultado.setEditable(false);
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setText("Resultado");
		txtResultado.setBounds(187, 66, 589, 20);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		
		cmbTipoOperacion = new JComboBox();
		cmbTipoOperacion.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "1._Suma de Matrices", "2.-Resta de Matrices", "3.-Multiplicacion de Matrices", "4.-Matriz por Escalar"}));
		cmbTipoOperacion.setBounds(12, 65, 165, 22);
		contentPane.add(cmbTipoOperacion);
		
		txtTipoDeOperacin = new JTextField();
		txtTipoDeOperacin.setForeground(Color.BLACK);
		txtTipoDeOperacin.setBackground(SystemColor.inactiveCaption);
		txtTipoDeOperacin.setEditable(false);
		txtTipoDeOperacin.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipoDeOperacin.setText("Tipo de Operaci\u00F3n");
		txtTipoDeOperacin.setBounds(10, 42, 778, 20);
		contentPane.add(txtTipoDeOperacin);
		txtTipoDeOperacin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("No.Filas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 238, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNocolumnas_1 = new JLabel("No.Columnas");
		lblNocolumnas_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNocolumnas_1.setBounds(79, 241, 98, 14);
		contentPane.add(lblNocolumnas_1);
		
		txtColumnasA = new JTextField();
		txtColumnasA.setColumns(10);
		txtColumnasA.setBounds(95, 164, 80, 28);
		contentPane.add(txtColumnasA);
		
		txtColumnasB = new JTextField();
		txtColumnasB.setColumns(10);
		txtColumnasB.setBounds(95, 255, 80, 26);
		contentPane.add(txtColumnasB);
		
		txtFilasB = new JTextField();
		txtFilasB.setColumns(10);
		txtFilasB.setBounds(10, 254, 80, 28);
		contentPane.add(txtFilasB);
		
		txtSumaYResta = new JTextField();
		txtSumaYResta.setHorizontalAlignment(SwingConstants.CENTER);
		txtSumaYResta.setText("Suma, Resta y Escalar");
		txtSumaYResta.setBounds(10, 98, 165, 20);
		contentPane.add(txtSumaYResta);
		txtSumaYResta.setColumns(10);
		
		txtMultiplicacinDeMatrices = new JTextField();
		txtMultiplicacinDeMatrices.setText("Multiplicaci\u00F3n de Matrices");
		txtMultiplicacinDeMatrices.setHorizontalAlignment(SwingConstants.CENTER);
		txtMultiplicacinDeMatrices.setColumns(10);
		txtMultiplicacinDeMatrices.setBounds(182, 98, 175, 20);
		contentPane.add(txtMultiplicacinDeMatrices);
		
		textField = new JTextField();
		textField.setText("Matriz A");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setBounds(185, 129, 165, 20);
		contentPane.add(textField);
		
		lblNewLabel_2 = new JLabel("No.Filas");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(187, 151, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNocolumnas_2 = new JLabel("No.Columnas");
		lblNocolumnas_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNocolumnas_2.setBounds(248, 151, 109, 14);
		contentPane.add(lblNocolumnas_2);
		
		txtMatrizB_1 = new JTextField();
		txtMatrizB_1.setText("Matriz B");
		txtMatrizB_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatrizB_1.setForeground(Color.BLACK);
		txtMatrizB_1.setEditable(false);
		txtMatrizB_1.setColumns(10);
		txtMatrizB_1.setBackground(SystemColor.inactiveCaption);
		txtMatrizB_1.setBounds(185, 207, 165, 20);
		contentPane.add(txtMatrizB_1);
		
		lblNewLabel_4 = new JLabel("No.Filas");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(187, 241, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("No.Columnas");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(270, 238, 65, 14);
		contentPane.add(lblNewLabel_5);
		
		txtFilA = new JTextField();
		txtFilA.setColumns(10);
		txtFilA.setBounds(185, 164, 75, 28);
		contentPane.add(txtFilA);
		
		txtColumA = new JTextField();
		txtColumA.setColumns(10);
		txtColumA.setBounds(270, 164, 75, 28);
		contentPane.add(txtColumA);
		
		txtFilB = new JTextField();
		txtFilB.setColumns(10);
		txtFilB.setBounds(187, 255, 73, 28);
		contentPane.add(txtFilB);
		
		txtColumB = new JTextField();
		txtColumB.setColumns(10);
		txtColumB.setBounds(270, 255, 75, 28);
		contentPane.add(txtColumB);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Extraer la opcion seleccionada del comboBox
			int	TipoOperacionMatriz=cmbTipoOperacion.getSelectedIndex();
				
		if (TipoOperacionMatriz==3) {	
				   int  filA=Integer.parseInt(txtFilA.getText());
			       int  columA=Integer.parseInt(txtColumA.getText());;
			       int matA[][]=new int[filA][columA];
			       	                
			       int filB=Integer.parseInt(txtFilB.getText());
			       int columB=Integer.parseInt(txtColumB.getText());;
			       int matB[][]=new int[filB][columB];
			       int matR[][]=new int[filA][columB];

		        if(filA == filB){ 

		                   //Ingreso datos de la matriz A
			                	JOptionPane.showMessageDialog(null,"Datos de la Matriz A","Datos", JOptionPane.INFORMATION_MESSAGE);
			                	 txtResultadoMatriz.append("\nDatos de la Matriz A\n");
			                        for(int i=0;i<filA;i++){
			                                for(int j=0;j<columA;j++){
			                                        matA[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la posición: a["+i+"]["+j+"]"+" de la matriz A"));
			                                        txtResultadoMatriz.append(matA[i][j]+" ");
			                                }
			                                txtResultadoMatriz.append("\n");
			                        }

			                      //Ingreso datos de la matriz B
			                      JOptionPane.showMessageDialog(null,"Datos de la Matriz B","Datos", JOptionPane.INFORMATION_MESSAGE);
			                      txtResultadoMatriz.append("\nDatos de la Matriz B\n");
			                        for(int i=0;i<filB;i++){
			                                for(int j=0;j<columB;j++){
			                                        matB[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la posición: a["+i+"]["+j+"]"+" de la matriz B"));                               
			                                        txtResultadoMatriz.append(matB[i][j]+" ");
			                                }
			                                txtResultadoMatriz.append("\n");
			                        }
			                        
			                        JOptionPane.showMessageDialog(null,"Multiplicación de las  matrices","Tipo de Operación", JOptionPane.INFORMATION_MESSAGE);
			                        txtResultadoMatriz.append("\nResultado de la Multiplicación de Matrices\n");
			                        for ( int i = 0; i < filA; i++){ 
			                                for ( int j = 0; j < columB; j++){
			                                        for ( int k = 0; k < columA; k++ ){ //puede ser columnasA o filasB ya que deben ser iguales
			                                                matR[ i ][j ] += matA[i][k]*matB[k][j];
			                                         }
			                                        txtResultadoMatriz.append(matR[i][j]+" ");
			                                }
			                                txtResultadoMatriz.append("\n");
			                            }
				                 }else{
		             
		          JOptionPane.showMessageDialog(null,"Error las matrices no se pueden multiplicar, no se cumplen las reglas","Error", JOptionPane.INFORMATION_MESSAGE);
		         } 
		     }
		  }
		});
	}
}
