package Inteligencia;

import Entidades.Jugador;
import General.Casilla;
import Visitor.Visitor;
import Visitor.VisitorEnemigo;

public abstract class Inteligencia {
	protected VisitorEnemigo v;
	
	public abstract void mover();
	
	public abstract void atacar(Visitor v, Jugador j);
}
