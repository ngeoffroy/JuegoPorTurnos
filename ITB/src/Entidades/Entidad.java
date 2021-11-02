package Entidades;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Visitor.Visitor;
import ataques.ataque;

public abstract class Entidad {
	protected int energia;
	protected ImageIcon icono;
	protected JLabel grafico;
	protected int daño;
	protected double posFallar=0.3;
	protected Point pos;
	protected Visitor v;
	protected ataque attack;
	
	public Entidad(){
		pos=new Point();
	}
	
	public int getEnergia(){
		return energia;
	}
	
	public int getDaño(){
		return daño;
	}
	
	public void setEnergia(int n){
		energia=n;
	}
	
	public void setDaño(int d){
		daño=d;
	}

	public abstract void serAtacado(Visitor v);
	public abstract void serAtacado(Visitor v, Jugador j);
	public JLabel getGrafico(){
		return this.grafico;
	}
	public Point getPos(){
		return pos;
	}
	
	public void setPos(int x, int y){
		pos.x=x;
		pos.y=y;
	}
	
	protected void cambiarGrafico(int dir){
		if(this.grafico != null){
			this.grafico.setBounds((pos.x * 35)+1,(pos.y * 35)+1, 34, 34);
			this.grafico.setLocation(pos.x,pos.y);
		}
	}
	
	public abstract void morir();
	
	
}
