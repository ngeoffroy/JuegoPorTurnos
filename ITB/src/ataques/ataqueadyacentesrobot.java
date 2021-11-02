package ataques;

import java.util.Random;

import Entidades.Jugador;
import General.Juego;

public class ataqueadyacentesrobot extends ataque {
 
	private Jugador j;
	
	public ataqueadyacentesrobot(Jugador j1){
		j=j1;
	}
	
	public void atacar(int dir){
		atacarRobot(dir);
	}
	
	private void atacarRobot(int dir) {
		boolean encontre=false;
		Random r= new Random();
		if(dir==1){
			for(int i=0;i<Juego.getInstance().getEnemigos().size() && !encontre;i++){
				if(Juego.getInstance().getEnemigos().get(i).getPos().x==j.getPos().x-1){
					if(r.nextInt(10)>2)
						j.atacar(Juego.getInstance().getEnemigos().get(i));
					else
						System.out.println("El ataque falló.");
					encontre=true;
					Juego.getInstance().setTurnoAtaque(false);
					System.out.println("Terminó el turno");
					System.out.println();
					Juego.getInstance().siguienteTurno();
				}
			}
		}
		if(dir==2){
			for(int i=0;i<Juego.getInstance().getEnemigos().size() && !encontre;i++){
				if(Juego.getInstance().getEnemigos().get(i).getPos().x==j.getPos().x+1){
					if(r.nextInt(10)>2)
						j.atacar(Juego.getInstance().getEnemigos().get(i));
					else
						System.out.println("El ataque falló.");
					encontre=true;
					Juego.getInstance().setTurnoAtaque(false);
					System.out.println("Terminó el turno");
					System.out.println();
					Juego.getInstance().siguienteTurno();
				}
			}
		}
		if(dir==3){
			for(int i=0;i<Juego.getInstance().getEnemigos().size() && !encontre;i++){
				if(Juego.getInstance().getEnemigos().get(i).getPos().y==j.getPos().y-1){
					if(r.nextInt(10)>2)
						j.atacar(Juego.getInstance().getEnemigos().get(i));
					else
						System.out.println("El ataque falló.");
					encontre=true;
					Juego.getInstance().setTurnoAtaque(false);
					System.out.println("Terminó el turno");
					System.out.println();
					Juego.getInstance().siguienteTurno();
				}
			}	
		}
		if(dir==4){
			for(int i=0;i<Juego.getInstance().getEnemigos().size() && !encontre;i++){
				if(Juego.getInstance().getEnemigos().get(i).getPos().y==j.getPos().y+1){
					if(r.nextInt(10)>2)
						j.atacar(Juego.getInstance().getEnemigos().get(i));
					else
						System.out.println("El ataque falló.");
					encontre=true;
					Juego.getInstance().setTurnoAtaque(false);
					System.out.println("Terminó el turno");
					System.out.println();
					Juego.getInstance().siguienteTurno();
				}
			}
		}
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
}
