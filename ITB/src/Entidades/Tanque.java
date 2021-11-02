package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import General.Juego;
import Visitor.Visitor;
import Visitor.VisitorAliado;
import ataques.ataquestanque;

public class Tanque extends Jugador{
	
	public Tanque(){
		setEnergia(10);
		daño=1;
		icono=new ImageIcon(this.getClass().getResource("/Iconos/tanque.png"));
		grafico = new JLabel(icono);
		v=new VisitorAliado(daño);
		setPasos(5);
		setNombre("Tanque");
		attack=new ataquestanque(this);
	}
	

	public Tanque(int x,int y){
		setEnergia(10);
		daño=1;
		icono=new ImageIcon(this.getClass().getResource("/Iconos/tanque.png"));
		grafico = new JLabel(icono);
		v=new VisitorAliado(daño);
		setPasos(5);
		pos.x=x;
		pos.y=y;
		setNombre("Tanque");
		attack=new ataquestanque(this);
	}

	@Override
	public void atacar(int dir) {
		attack.atacar(dir);
	}
	
	public void resetearPasos(){
		setPasos(5);
	}


	@Override
	public void morir() {
		Juego.getInstance().getMapa().remove(Juego.getInstance().getCasillero(pos.x,pos.y).getEntidad().getGrafico());
		Juego.getInstance().getAliados().remove(this);
		Juego.getInstance().getCasillero(pos.x, pos.y).eliminarEntidad();
		Juego.getInstance().getMapa().add(Juego.getInstance().getCasillero(pos.x,pos.y).getFondo().getGrafico());
		Juego.getInstance().getMapa().repaint();
	}
	
}
