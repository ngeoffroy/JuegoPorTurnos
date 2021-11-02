package Entidades;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import General.Juego;
import Inteligencia.IAvispa;
import Visitor.Visitor;
import Visitor.VisitorAliado;
import Visitor.VisitorEnemigo;
import ataques.ataque;
import ataques.ataquesadyacentes;

public class Avispa extends Enemigo{

	public Avispa(){
		daño=2;
		icono=new ImageIcon(this.getClass().getResource("/Iconos/avispa.png"));
		grafico = new JLabel(icono);
		inteligenciaEnemiga= new IAvispa(this);
		pos=new Point();
		v=new VisitorEnemigo(daño,danioEdificio);
		attack=new ataquesadyacentes(this);
		energia=4;
	}

	@Override
	public void mover() {
		inteligenciaEnemiga.mover();
	}

	@Override
	public void atacar(Jugador j) {
		inteligenciaEnemiga.atacar(v,j);
	}

	@Override
	public void morir() {
		Juego.getInstance().getMapa().remove(Juego.getInstance().getCasillero(pos.x,pos.y).getEntidad().getGrafico());
		Juego.getInstance().getEnemigos().remove(this);
		Juego.getInstance().getCasillero(pos.x, pos.y).eliminarEntidad();
		Juego.getInstance().getMapa().add(Juego.getInstance().getCasillero(pos.x,pos.y).getFondo().getGrafico());
		Juego.getInstance().getMapa().repaint();
	}

	
	

}
