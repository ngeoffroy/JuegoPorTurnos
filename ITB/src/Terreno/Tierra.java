package Terreno;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tierra extends Terreno {

	protected String nombre;
	
	public Tierra(){
		icono=new ImageIcon(this.getClass().getResource("/Iconos/tierra.png"));
		grafico = new JLabel(icono);
		nombre="Tierra";
	}
	
	
}
