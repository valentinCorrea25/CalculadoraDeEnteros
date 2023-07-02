package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.*;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class Vista extends JFrame{

	private JPanel contentPane;
	private JTextField textDisplay;
	private String display = "0";
	private int resultado;
	private int a, b = 0;
	private char signoAnterior = '0';
	private DefaultListModel<String> modelo;
	private ArrayList<String> historial;
	private Action uno;
	private Action dos;
	private Action tres;
	private Action cuatro;
	private Action cinco;
	private Action seis;
	private Action siete;
	private Action ocho;
	private Action nueve;
	private Action cero;
	private Action sumar;
	private Action restar;
	private Action multiplicar;
	private Action dividir;
	private Action borrarUno;
	private Action borrarTodo;
	private Action esIgual;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Vista() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vista.class.getResource("/img/R.png")));
		setResizable(false);
		setTitle("Calculadora");
		historial = new ArrayList<>();

		// TODAS ESTAS CLASES SON PARA LA IMPLEMENTACION DE UTILIZAR EL TELCADO PARA CONTROLAR LA CALCULADORA https://www.youtube.com/watch?v=IyfB0u9g2x0
		
		uno = new Uno();
		dos = new Dos();
		tres = new Tres();
		cuatro = new Cuatro();
		cinco = new Cinco();
		seis = new Seis();
		siete = new Siete();
		ocho = new Ocho();
		nueve = new Nueve();
		cero = new Cero();
		
		sumar = new Suma();
		restar = new Resta();
		multiplicar = new Multiplicacion();
		dividir = new Division();
		borrarUno = new BorrarUno();
		borrarTodo = new BorrarTodo();
		esIgual = new EsIgual();
		
		
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('1'), "unoAct");
		contentPane.getActionMap().put("unoAct", uno);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('2'), "dosAct");
		contentPane.getActionMap().put("dosAct", dos);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('3'), "tresAct");
		contentPane.getActionMap().put("tresAct", tres);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('4'), "cuatroAct");
		contentPane.getActionMap().put("cuatroAct", cuatro);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('5'), "cincoAct");
		contentPane.getActionMap().put("cincoAct", cinco);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('6'), "seisAct");
		contentPane.getActionMap().put("seisAct", seis);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('7'), "sieteAct");
		contentPane.getActionMap().put("sieteAct", siete);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('8'), "ochoAct");
		contentPane.getActionMap().put("ochoAct", ocho);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('9'), "nueveAct");
		contentPane.getActionMap().put("nueveAct", nueve);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('0'), "ceroAct");
		contentPane.getActionMap().put("ceroAct", cero);
		
		contentPane.getInputMap().put(KeyStroke.getKeyStroke((char) KeyEvent.VK_ENTER), "igualAct");
		contentPane.getActionMap().put("igualAct", esIgual);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('+'), "sumaAct");
		contentPane.getActionMap().put("sumaAct", sumar);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('-'), "restaAct");
		contentPane.getActionMap().put("restaAct", restar);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('*'), "multiplicarAct");
		contentPane.getActionMap().put("multiplicarAct", multiplicar);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('/'), "dividirAct");
		contentPane.getActionMap().put("dividirAct", dividir);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke((char) KeyEvent.VK_BACK_SPACE), "borrarUnoAct");
		contentPane.getActionMap().put("borrarUnoAct", borrarUno);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke('c'), "borrarTodoAct");
		contentPane.getActionMap().put("borrarTodoAct", borrarTodo);

		textDisplay = new JTextField();
		textDisplay.setText("0");
		textDisplay.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 28));
		textDisplay.setEditable(false);
		textDisplay.setBounds(23, 28, 311, 47);
		contentPane.add(textDisplay);
		textDisplay.setColumns(10);

		JButton btnNum1 = new JButton("1");
		btnNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('1');
			}
		});
		btnNum1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum1.setBounds(23, 245, 56, 56);
		btnNum1.setFocusable(false);
		contentPane.add(btnNum1);

		JButton btnNum2 = new JButton("2");
		btnNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('2');
			}
		});
		btnNum2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum2.setBounds(89, 245, 56, 56);
		btnNum2.setFocusable(false);
		contentPane.add(btnNum2);

		JButton btnNum3 = new JButton("3");
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('3');
			}
		});
		btnNum3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum3.setBounds(155, 245, 56, 56);
		btnNum3.setFocusable(false);
		contentPane.add(btnNum3);

		JButton btnNum4 = new JButton("4");
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('4');
			}
		});
		btnNum4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum4.setBounds(23, 178, 56, 56);
		btnNum4.setFocusable(false);
		contentPane.add(btnNum4);

		JButton btnNum5 = new JButton("5");
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('5');
			}
		});
		btnNum5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum5.setBounds(89, 178, 56, 56);
		btnNum5.setFocusable(false);
		contentPane.add(btnNum5);

		JButton btnNum6 = new JButton("6");
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('6');
			}
		});
		btnNum6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum6.setBounds(155, 178, 56, 56);
		btnNum6.setFocusable(false);
		contentPane.add(btnNum6);

		JButton btnNum7 = new JButton("7");
		btnNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('7');
			}
		});
		btnNum7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum7.setBounds(23, 111, 56, 56);
		btnNum7.setFocusable(false);
		contentPane.add(btnNum7);

		JButton btnNum8 = new JButton("8");
		btnNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('8');
			}
		});
		btnNum8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum8.setBounds(89, 111, 56, 56);
		btnNum8.setFocusable(false);
		contentPane.add(btnNum8);

		JButton btnNum9 = new JButton("9");
		btnNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('9');
			}
		});
		btnNum9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum9.setBounds(155, 111, 56, 56);
		btnNum9.setFocusable(false);
		contentPane.add(btnNum9);

		JButton btnNum0 = new JButton("0");
		btnNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarCaracter('0');
			}
		});
		btnNum0.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnNum0.setBounds(89, 312, 56, 56);
		btnNum0.setFocusable(false);
		contentPane.add(btnNum0);

		JButton btnBorrar = new JButton("<-");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarUltimo();
			}
		});
		btnBorrar.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		btnBorrar.setBounds(155, 312, 56, 56);
		btnBorrar.setFocusable(false);
		contentPane.add(btnBorrar);

		JButton btnBorrarTodo = new JButton("C");
		btnBorrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarVariables();
				textDisplay.setText(display);
			}
		});
		btnBorrarTodo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnBorrarTodo.setBounds(23, 312, 56, 56);
		btnBorrarTodo.setFocusable(false);
		contentPane.add(btnBorrarTodo);

		JButton btnResultado = new JButton("=");
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar('=');
			}
		});
		btnResultado.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnResultado.setBounds(219, 312, 115, 56);
		btnResultado.setFocusable(false);
		contentPane.add(btnResultado);

		JButton btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar('+');
			}
		});
		btnSuma.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 27));
		btnSuma.setBounds(221, 178, 54, 56);
		btnSuma.setFocusable(false);
		contentPane.add(btnSuma);

		JButton btnResta = new JButton("-");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar('-');
			}
		});
		btnResta.setBackground(new Color(255, 255, 255));
		btnResta.setIcon(null);
		btnResta.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnResta.setBounds(280, 178, 54, 56);
		btnResta.setFocusable(false);
		contentPane.add(btnResta);

		JButton btnMultiplicacion = new JButton("x");
		btnMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar('x');
			}
		});
		btnMultiplicacion.setIcon(null);
		btnMultiplicacion.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnMultiplicacion.setBounds(280, 111, 54, 56);
		btnMultiplicacion.setFocusable(false);
		contentPane.add(btnMultiplicacion);

		JButton btnDivision = new JButton("/");
		btnDivision.setIcon(null);
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verificar('/');
			}
		});
		btnDivision.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
		btnDivision.setBounds(221, 111, 54, 56);
		btnDivision.setFocusable(false);
		contentPane.add(btnDivision);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setBounds(363, 28, 184, 340);
		contentPane.add(scrollPane);
		
		modelo = new DefaultListModel();
		JList list = new JList(modelo);
		list.setFocusable(false);
		scrollPane.setViewportView(list);
		
		
		
	}

	private void insertarCaracter(char num) {
		if (display.equals("0")) {
			display = Character.toString(num);
		} else {
			display += num;
		}
		textDisplay.setText(display);
	}

	private void verificar(char signoOperacion) {
		try {
			char aux = display.charAt(display.length() - 1);
			if (signoOperacion == '=') {
				if (a != 0 && Character.isDigit(aux)) {
					b = Integer.parseInt(display.substring(display.lastIndexOf(signoAnterior) + 1));
					realizarOperacion(Character.toString(signoAnterior));
					a = 0;
					b = 0;
					signoAnterior = ' ';
				}
			} else {
				if (!Character.isDigit(aux)) { // Verifico en la expresion termine con un valor numerico
					if (aux != signoOperacion) { // no es igual al signo de la operacion insertado por lo que cambia de signo
						borrarUltimo();
						signoAnterior = signoOperacion;
						insertarCaracter(signoOperacion);
					}
				} else {
					if (display.lastIndexOf(signoOperacion) == -1) { // Entra si no tiene el digito apretado
						if (a == 0) { // a no tiene nuingun valor
							a = Integer.parseInt(display);
							signoAnterior = signoOperacion;
							insertarCaracter(signoOperacion);
						} else if(signoAnterior != ' '){ // Si el signo de la operacion anterior finalizo y dio un resultado sin seguir la cuenta
							b = Integer.parseInt(display.substring(display.lastIndexOf(signoAnterior) + 1));
							realizarOperacion(Character.toString(signoAnterior));
							signoAnterior = signoOperacion;
							insertarCaracter(signoOperacion);
							System.out.println("2Valor de el signo " + signoAnterior);
						}
					} else { // a tiene algun valor o el signo insertado esta en el display
						b = Integer.parseInt(display.substring(display.lastIndexOf(signoAnterior) + 1));
						realizarOperacion(Character.toString(signoAnterior));
						insertarCaracter(signoOperacion);
						signoAnterior = signoOperacion;
						System.out.println("Valor de el signo " + signoAnterior);

					}
				}
			}
		
		}catch(ArithmeticException e) {
			textDisplay.setText("Error Aritmetico");
			vaciarVariables();
		}catch (NumberFormatException e) {
			textDisplay.setText("Demasiado Grande");
			vaciarVariables();
		}
	}

	private void borrarUltimo() {
		if (display.length() > 1) {
			display = display.substring(0, display.length() - 1);
		} else {
			vaciarVariables();
		}
		textDisplay.setText(display);
	}

	private void realizarOperacion(String c) {

		if (c.equals("+"))
			resultado = a + b;
		if (c.equals("-"))
			resultado = a - b;
		if (c.equals("x"))
			resultado = a * b;
		if (c.equals("/"))
			resultado = a / b;

		historial.add(String.valueOf(a) + " " + c + " "  + String.valueOf(b) +" = "+  String.valueOf(resultado));
		modelo.removeAllElements();
		modelo.addAll(actualizarHistorial());
		display = String.valueOf(resultado);
		textDisplay.setText(display);
		a = resultado;
		b = 0;
	}

	private void vaciarVariables() {
		a = 0;
		b = 0;
		display = "0";
	}
	
	private ArrayList<String> actualizarHistorial() {
		return historial;
	}
		
	public class Uno extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('1');
		}		
	}
	public class Dos extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('2');
		}		
	}
	public class Tres extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('3');
		}		
	}
	public class Cuatro extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('4');
		}		
	}
	public class Cinco extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('5');
		}		
	}
	public class Seis extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('6');
		}		
	}
	public class Siete extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('7');
		}		
	}
	public class Ocho extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('8');
		}		
	}
	public class Nueve extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('9');
		}		
	}
	public class Cero extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			insertarCaracter('0');
		}		
	}
	public class Suma extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			verificar('+');
		}		
	}
	public class Resta extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			verificar('-');
		}		
	}
	public class Multiplicacion extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			verificar('x');
		}		
	}
	public class Division extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			verificar('/');
		}		
	}
	public class BorrarUno extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			borrarUltimo();
		}		
	}
	public class BorrarTodo extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			vaciarVariables();
			textDisplay.setText(display);
		}		
	}
	
	public class EsIgual extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e) {
			verificar('=');
		}		
	}
	
	
}


