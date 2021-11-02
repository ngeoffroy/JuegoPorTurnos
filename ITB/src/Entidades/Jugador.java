package Entidades;

import General.Juego;
import General.Mapa;
import Terreno.Tierra;
import Visitor.Visitor;
import Visitor.VisitorAliado;
import ataques.ataque;

public abstract class Jugador extends Entidad{

	protected int energia;
	protected int daño;
	protected int pasos;
	protected String nombre;
	protected ataque attack;
	protected boolean dispare=false;
	
	public void atacar(Enemigo e){
		e.serAtacado(v,this);
		System.out.println("Ataque al enemigo y ahora su vida es de "+e.getEnergia());
	}
	
	public void atacar(int dir){
		if(Juego.getInstance().getTurnoAtaque()){
			attack.atacar(dir);
		}
		Juego.getInstance().setTurnoAtaque(false);
	}
	
	public void serAtacado(Visitor v) {
		v.atacar(this);
	}
	
	public void serAtacado(Visitor v,Jugador j){
		
	}
	
	public int getDaño(){
		return daño;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String s) {
		nombre=s;		
	}
	
	public int getPasos(){
		return pasos;
	}
	
	public void setPasos(int n){
		pasos=n;
	}
	
	public void mover(int dir){
		int xvieja=pos.x;
		int yvieja=pos.y;
		if(Juego.getInstance().getTurnoMovimiento()){
				if(pasos>0){
					switch (dir) {
						case 1 : //Izquierda
							if(pos.x>0){
								//if(Juego.getInstance().getCasillero(i, j))
								if(Juego.getInstance().getCasillero(pos.x-1, pos.y).getTransitable()==true){
									Juego.getInstance().getCasillero(pos.x, pos.y).eliminarEntidad();
									pos.setLocation(pos.x-1, pos.y);
									Juego.getInstance().getCasillero(pos.x, pos.y).agregarEntidad(this);
									pasos--;
									verificarPasos();
								}
								else
									System.out.println("No puedes pasar por un terreno intransitable");
							}	
							break;
						case 2 : //Derecha
							if(pos.x<7){
								if(Juego.getInstance().getCasillero(pos.x+1, pos.y).getTransitable()==true){
									Juego.getInstance().getCasillero(pos.x, pos.y).eliminarEntidad();
									pos.setLocation(pos.x+1, pos.y);
									Juego.getInstance().getCasillero(pos.x, pos.y).agregarEntidad(this);
									pasos--;
									verificarPasos();
								}
								else
									System.out.println("No puedes pasar por un terreno intransitable");
							}
							break;
						case 3 : //Arriba
							if(pos.y>0){
								if(Juego.getInstance().getCasillero(pos.x, pos.y-1).getTransitable()==true){
									Juego.getInstance().getCasillero(pos.x, pos.y).eliminarEntidad();
									pos.setLocation(pos.x, pos.y-1);
									Juego.getInstance().getCasillero(pos.x, pos.y).agregarEntidad(this);
									pasos--;
									verificarPasos();
								}
								else
									System.out.println("No puedes pasar por un terreno intransitable");
							}
							break;
						case 4 : //Abajo
						if(pos.y<7){
							if(Juego.getInstance().getCasillero(pos.x, pos.y+1).getTransitable()==true){
								Juego.getInstance().getCasillero(pos.x, pos.y).eliminarEntidad();
								pos.setLocation(pos.x, pos.y+1);
								Juego.getInstance().getCasillero(pos.x, pos.y).agregarEntidad(this);
								pasos--;
								verificarPasos();
							}
							else
								System.out.println("No puedes pasar por un terreno intransitable");
						}
						break;		
					
					}
				}
			}
			if(this.grafico != null){
				Juego.getInstance().getMapa().remove(Juego.getInstance().getCasillero(xvieja, yvieja));
				this.grafico.setBounds((pos.x * 35)+1,(pos.y * 35)+1, 34, 34);
				Juego.getInstance().getMapa().add(Juego.getInstance().getCasillero(xvieja,yvieja).getFondo().getGrafico());
				Juego.getInstance().getMapa().remove(Juego.getInstance().getCasillero(pos.x,pos.y).getFondo().getGrafico());
				Juego.getInstance().getMapa().repaint();
			}
		}
	
	private void verificarPasos(){
		if(pasos==0){
			Juego.getInstance().setTurnoMovimiento(false);
			Juego.getInstance().setTurnoAtaque(true);
			System.out.println("Te quedaste sin pasos. Ahora puedes atacar.");
			resetearPasos();
		}
	}
	
	public void resetearPasos(){	}
	
}

	


