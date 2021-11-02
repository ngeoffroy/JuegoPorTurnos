	package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import General.Juego;
import Visitor.Visitor;
import ataques.ataquesadyacentes;

public class Edificio extends Jugador{

	
	public Edificio(){
		energia=100;
		icono=new ImageIcon(this.getClass().getResource("/Iconos/edificio.png"));
		grafico = new JLabel(icono);
	}
	
	public int getEnergia(){
		return energia;
	}
	
	public void setEnergia(int n){
		energia=n;
	}

	
	public void serAtacado(Visitor v) {
		v.atacar(this);
	}

	@Override
	public void atacar(int dir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void morir() {
		Juego.getInstance().getMapa().remove(Juego.getInstance().getCasillero(pos.x,pos.y).getEntidad().getGrafico());
		Juego.getInstance().getEdificios().remove(this);
		Juego.getInstance().getCasillero(pos.x, pos.y).eliminarEntidad();
		Juego.getInstance().getMapa().add(Juego.getInstance().getCasillero(pos.x,pos.y).getFondo().getGrafico());
		Juego.getInstance().getMapa().repaint();
	}

	
	
}
