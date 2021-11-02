package Entidades;

import General.Juego;
import Inteligencia.Inteligencia;
import Visitor.Visitor;
import Visitor.VisitorEnemigo;
import ataques.ataque;
import ataques.ataquesadyacentes;

public abstract class Enemigo extends Entidad{
	
	protected Inteligencia inteligenciaEnemiga;	
	protected Visitor v;
	protected int danioEdificio;
	
	public Enemigo(){
		danioEdificio=3;
	}
	public abstract void atacar(Jugador j);
	public abstract void mover();
	public Inteligencia getInteligencia(){
		return inteligenciaEnemiga;
	}
	@Override
	public void serAtacado(Visitor v, Jugador j) {
		v.atacar(this,j);
	}
	
	public void serAtacado(Visitor v){
		
	}
	public ataque getattack(){
		return attack;
	}
}

