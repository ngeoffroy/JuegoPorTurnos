package Terreno;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Monta�a extends Terreno{
	
	public Monta�a(){
		icono=new ImageIcon(this.getClass().getResource("/Iconos/monta�a.png"));
		grafico = new JLabel(icono);
	}

}
