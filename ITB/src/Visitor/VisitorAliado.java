package Visitor;

import java.util.Random;

import Entidades.Edificio;
import Entidades.Enemigo;
import Entidades.Jugador;
import General.Juego;

public class VisitorAliado extends Visitor{

	public VisitorAliado(int d){
		danio=d;
	}
	
	@Override
	public void atacar(Jugador e) {
		
	}

	@Override
	public void atacar(Enemigo j, Jugador j1) {
		j.setEnergia(j.getEnergia()-danio);
		if(j.getEnergia()<=0){
			j.setEnergia(0);
			j.morir();
		}
		/*}else{
			Random r= new Random();
			int n=r.nextInt(3); 
			if(n==0)
				j.getInteligencia().setObjetivo(null);
			else
				if(n==1)
					j.getInteligencia().setObjetivo(Juego.getInstance().getCasillero(j1.getPos().x,j1.getPos().y));
		}*/
		
	}

	@Override
	public void atacar(Edificio e) {
		// TODO Auto-generated method stub
		
	}




}
