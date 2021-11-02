package Terreno;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Terreno {
	protected String nombre;
	protected ImageIcon icono;
	protected JLabel grafico;
	
	public JLabel getGrafico(){
		return this.grafico;
	}
	
	public String getNombre(){
		return nombre;
	}

}
