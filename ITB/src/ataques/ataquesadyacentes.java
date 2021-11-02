package ataques;

import java.util.Random;

import Entidades.Enemigo;
import Entidades.Entidad;
import Entidades.Jugador;
import Entidades.Tanque;
import General.Casilla;
import General.Juego;

public class ataquesadyacentes extends ataque{

	protected Enemigo enti;

	
	public ataquesadyacentes(Enemigo e){
		enti=e;
	}
	
	@Override
	public void atacar() {
		boolean encontre=false;
		Random r=new Random();
		if(Juego.getInstance().getAliados()!=null)
			for(int i=0;i<Juego.getInstance().getAliados().size() && !encontre;i++)
				if(Juego.getInstance().getAliados().get(i).getPos().x==enti.getPos().x-1&&Juego.getInstance().getAliados().get(i).getPos().y==enti.getPos().y){
					encontre=true;
					if(r.nextInt(10)>2){
						enti.atacar(Juego.getInstance().getAliados().get(i));
						System.out.println("El enemigo atacó a la izquierda");}
					else
						System.out.println("El ataque falló.");	
				}else
					if(Juego.getInstance().getAliados().get(i).getPos().x==enti.getPos().x+1&&Juego.getInstance().getAliados().get(i).getPos().y==enti.getPos().y){
						encontre=true;
						if(r.nextInt(10)>2){
							enti.atacar(Juego.getInstance().getAliados().get(i));
							System.out.println("El enemigo atacó a la derecha");}
						else
							System.out.println("El ataque falló.");	
					}else
						if(Juego.getInstance().getAliados().get(i).getPos().y==enti.getPos().y-1&&Juego.getInstance().getAliados().get(i).getPos().x==enti.getPos().x){
							encontre=true;
							if(r.nextInt(10)>2){
								enti.atacar(Juego.getInstance().getAliados().get(i));
								System.out.println("El enemigo atacó arriba");}
							else
								System.out.println("El ataque falló.");	
						}else
							if(Juego.getInstance().getAliados().get(i).getPos().y==enti.getPos().y+1&&Juego.getInstance().getAliados().get(i).getPos().x==enti.getPos().x){
								encontre=true;
								if(r.nextInt(10)>2){
									enti.atacar(Juego.getInstance().getAliados().get(i));
									System.out.println("El enemigo atacó abajo");}
								else
									System.out.println("El ataque falló.");	
							}
		if(!encontre&&Juego.getInstance().getEdificios()!=null)
			for(int i=0;i<Juego.getInstance().getEdificios().size() && !encontre;i++)
				if(Juego.getInstance().getEdificios().get(i).getPos().x==enti.getPos().x-1&&Juego.getInstance().getEdificios().get(i).getPos().y==enti.getPos().y){
					encontre=true;
					System.out.println("El enemigo atacó a la izquierda");
					enti.atacar(Juego.getInstance().getEdificios().get(i));
				}else
					if(Juego.getInstance().getEdificios().get(i).getPos().x==enti.getPos().x+1&&Juego.getInstance().getEdificios().get(i).getPos().y==enti.getPos().y){
						encontre=true;
						System.out.println("El enemigo atacó a la derecha");
						enti.atacar(Juego.getInstance().getEdificios().get(i));
					}else
						if(Juego.getInstance().getEdificios().get(i).getPos().y==enti.getPos().y-1&&Juego.getInstance().getEdificios().get(i).getPos().x==enti.getPos().x){
							encontre=true;
							System.out.println("El enemigo atacó arriba");
							enti.atacar(Juego.getInstance().getEdificios().get(i));
						}else
							if(Juego.getInstance().getEdificios().get(i).getPos().y==enti.getPos().y+1&&Juego.getInstance().getEdificios().get(i).getPos().x==enti.getPos().x){
								encontre=true;
								System.out.println("El enemigo atacó abajo");
								enti.atacar(Juego.getInstance().getEdificios().get(i));
							}
	}

	@Override
	public void atacar(int dir) {
		// TODO Auto-generated method stub
		
	}

}
