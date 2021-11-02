package Visitor;

import Entidades.Edificio;
import Entidades.Enemigo;
import Entidades.Jugador;

public class VisitorEnemigo extends Visitor{

	private int danioedificio;
	
	public VisitorEnemigo(int d, int de){
		danio=d;
		danioedificio=de;
	}
	
	@Override
	public void atacar(Jugador e) {
		System.out.println("La vida del " + e.getNombre() + " antes del ataque es de " + e.getEnergia());
		e.setEnergia(e.getEnergia()-danio);
		System.out.println("El daño es " + danio);
		if(e.getEnergia()<0){
			e.setEnergia(0);
			e.morir();
			System.out.println(e.getNombre()+" ha sido destruido.");
		}
		else{
			System.out.println("La vida del " + e.getNombre() + " después del ataque es de " + e.getEnergia());
			System.out.println();
		}
	}
	

	@Override
	public void atacar(Enemigo j, Jugador j1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacar(Edificio e) {
		System.out.println("La vida del edificio antes del ataque es de " + e.getEnergia());
		e.setEnergia(e.getEnergia()-danioedificio);
		System.out.println("El daño es " + danioedificio);
		if(e.getEnergia()<=0){
			e.setEnergia(0);
			e.morir();
			System.out.println("Se ha destruido el edificio.");
		}else{
			System.out.println("La vida del edificio después del ataque es de " + e.getEnergia());
			System.out.println();
		}
		
	}



}
