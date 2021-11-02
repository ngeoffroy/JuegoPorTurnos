package Entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import General.Juego;
import Visitor.Visitor;
import Visitor.VisitorAliado;
import ataques.ataque;
import ataques.ataqueadyacentesrobot;
import ataques.ataquesadyacentes;

public class Robot extends Jugador{
	

	public Robot(){
		setEnergia(10);
		daño=2;
		icono=new ImageIcon(this.getClass().getResource("/Iconos/robot.png"));
		grafico = new JLabel(icono);
		v=new VisitorAliado(daño);
		setPasos(3);
		setNombre("Robot");
		attack=new ataqueadyacentesrobot(this);
	}
	
	public Robot(int x,int y){
		setEnergia(10);
		daño=2;
		icono=new ImageIcon(this.getClass().getResource("/Iconos/robot.png"));
		grafico = new JLabel(icono);
		v=new VisitorAliado(daño);
		setPasos(3);
		pos.x=x;
		pos.y=y;
		setNombre("Robot");
		attack=new ataqueadyacentesrobot(this);
	}
	
	public void atacar(int dir){
		attack.atacar(dir);
	}
	
	public void resetearPasos(){
		setPasos(3);
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
