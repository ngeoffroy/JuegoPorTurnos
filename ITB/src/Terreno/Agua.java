package Terreno;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Agua extends Terreno{
	protected String a;
	
	public Agua(){
		icono=new ImageIcon(this.getClass().getResource("/Iconos/agua.png"));
		grafico = new JLabel(icono);
	}

}
