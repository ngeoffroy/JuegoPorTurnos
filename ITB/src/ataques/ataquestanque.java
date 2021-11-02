package ataques;

import java.util.Random;

import Entidades.Enemigo;
import Entidades.Jugador;
import Entidades.Tanque;
import General.Juego;

public class ataquestanque extends ataque{

	private Jugador miTanque;
	private Juego juego;
	
	public ataquestanque(Tanque t){
		miTanque=t;
	}
	
	@Override
	public void atacar(int dir) {
		Enemigo enemigo;
		Random r=new Random();
		Jugador tanqueAux=Juego.getInstance().obtenerTanque();
		if(dir==1){
			enemigo=buscarIzquierda();
			if(enemigo!=null){
				if(r.nextInt(10)>2)
					tanqueAux.atacar(enemigo);	
				else
					System.out.println("El ataque falló.");				
				Juego.getInstance().setTurnoAtaque(false);
				System.out.println("Terminó el turno");
				System.out.println();
				Juego.getInstance().siguienteTurno();
			}
		}
		if(dir==2){
			enemigo=buscarDerecha();
			if(enemigo!=null){
				if(r.nextInt(10)>2)
					tanqueAux.atacar(enemigo);	
				else
					System.out.println("El ataque falló.");			
				Juego.getInstance().setTurnoAtaque(false);
				System.out.println("Terminó el turno");
				System.out.println();
				Juego.getInstance().siguienteTurno();
			}
		}
		if(dir==3){
			enemigo=buscarArriba();
			if(enemigo!=null){
				if(r.nextInt(10)>2)
					tanqueAux.atacar(enemigo);	
				else
					System.out.println("El ataque falló.");	
				Juego.getInstance().setTurnoAtaque(false);
				System.out.println("Terminó el turno");
				System.out.println();
				Juego.getInstance().siguienteTurno();
			}
		}
		if(dir==4){
			enemigo=buscarAbajo();
			if(enemigo!=null){
				if(r.nextInt(10)>2)
					tanqueAux.atacar(enemigo);	
				else
					System.out.println("El ataque falló.");	
				Juego.getInstance().setTurnoAtaque(false);
				System.out.println("Terminó el turno");
				System.out.println();
				Juego.getInstance().siguienteTurno();
			}
		}
	}
	
	private Enemigo buscarIzquierda(){
		boolean encontre=false;
		Enemigo enemigo=null;
		Jugador tanqueAux=Juego.getInstance().obtenerTanque();
		for(int i=0;i<Juego.getInstance().getEnemigos().size() && !encontre;i++){
			if(Juego.getInstance().getEnemigos().get(i).getPos().x<tanqueAux.getPos().x && Juego.getInstance().getEnemigos().get(i).getPos().y==tanqueAux.getPos().y){
				encontre=true;
				enemigo=Juego.getInstance().getEnemigos().get(i);
			}
		}
		return enemigo;
	}
	
	private Enemigo buscarDerecha(){
		boolean encontre=false;
		Enemigo enemigo=null;
		Jugador tanqueAux=Juego.getInstance().obtenerTanque();
		for(int i=0;i<Juego.getInstance().getEnemigos().size() && !encontre;i++){
			if(Juego.getInstance().getEnemigos().get(i).getPos().x>tanqueAux.getPos().x && Juego.getInstance().getEnemigos().get(i).getPos().y==tanqueAux.getPos().y){
				encontre=true;
				enemigo=Juego.getInstance().getEnemigos().get(i);
			}
		}
		return enemigo;
	}
	
	private Enemigo buscarArriba(){
		boolean encontre=false;
		Enemigo enemigo=null;
		Jugador tanqueAux=Juego.getInstance().obtenerTanque();
		for(int i=0;i<Juego.getInstance().getEnemigos().size() && !encontre;i++){
			if(Juego.getInstance().getEnemigos().get(i).getPos().y<tanqueAux.getPos().y && Juego.getInstance().getEnemigos().get(i).getPos().x==tanqueAux.getPos().x){
				encontre=true;
				enemigo=Juego.getInstance().getEnemigos().get(i);
			}
		}
		return enemigo;
	}
	
	private Enemigo buscarAbajo(){
		boolean encontre=false;
		Enemigo enemigo=null;
		Jugador tanqueAux=Juego.getInstance().obtenerTanque();
		for(int i=0;i<Juego.getInstance().getEnemigos().size() && !encontre;i++){
			if(Juego.getInstance().getEnemigos().get(i).getPos().y>tanqueAux.getPos().y && Juego.getInstance().getEnemigos().get(i).getPos().x==tanqueAux.getPos().x){
				encontre=true;
				enemigo=Juego.getInstance().getEnemigos().get(i);
			}
		}
		return enemigo;
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	
}
