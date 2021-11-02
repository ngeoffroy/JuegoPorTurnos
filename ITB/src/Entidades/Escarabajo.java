package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import General.Juego;
import Inteligencia.IEscarabajo;
import Visitor.Visitor;
import Visitor.VisitorEnemigo;
import ataques.ataque;
import ataques.ataquesadyacentes;

public class Escarabajo extends Enemigo{

	public Escarabajo(){
		daño=2;
		icono=new ImageIcon(this.getClass().getResource("/Iconos/escarabajo.png"));
		grafico = new JLabel(icono);
		inteligenciaEnemiga=new IEscarabajo(this);
		energia=4;
		v=new VisitorEnemigo(daño,danioEdificio);
		attack= new ataquesadyacentes(this);
	}

	@Override
	public void mover() {
		inteligenciaEnemiga.mover();
	}

	
	
	public void setPos(int x, int y){
		pos.x=x;
		pos.y=y;
	}
	
	public void atacar(Jugador j){
		inteligenciaEnemiga.atacar(v,j);;
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
