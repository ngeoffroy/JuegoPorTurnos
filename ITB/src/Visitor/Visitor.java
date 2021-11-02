package Visitor;

import Entidades.Edificio;
import Entidades.Enemigo;
import Entidades.Jugador;

public abstract class Visitor {
	protected int danio;

	
	public abstract void atacar(Enemigo j,Jugador j1);
	
	public abstract void atacar(Edificio e);

	public abstract void atacar(Jugador e);
}
