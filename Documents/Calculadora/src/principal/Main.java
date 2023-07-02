package principal;
import javax.swing.UnsupportedLookAndFeelException;

import vista.Vista;

public class Main {

	public static void main(String[] args) {
		
		Vista ventana;
		try {
			ventana = new Vista();
			ventana.setVisible(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
