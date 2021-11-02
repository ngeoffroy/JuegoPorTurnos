package Terreno;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Montaña extends Terreno{
	
	public Montaña(){
		icono=new ImageIcon(this.getClass().getResource("/Iconos/montaña.png"));
		grafico = new JLabel(icono);
	}

}
