package Inteligencia;

import java.util.Random;

import Entidades.Avispa;
import Entidades.Edificio;
import Entidades.Enemigo;
import Entidades.Escarabajo;
import Entidades.Jugador;
import General.Juego;
import General.Mapa;
import Visitor.Visitor;

public class IEscarabajo extends Inteligencia{
	private Escarabajo escarabajo;
	private int pasos;

	
	public IEscarabajo(Escarabajo e){
		escarabajo=e;
		pasos=4;
	}

	public void mover(){
		for(int i=0;i<pasos;i++){
			Random r=new Random();
			mover(r.nextInt(4));
		}
	}
	
	private void mover(int dir){
		int xvieja=escarabajo.getPos().x;
		int yvieja=escarabajo.getPos().y;
		switch (dir) {
		case 0 : //Arriba
			if(escarabajo.getPos().y>0 && Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y-1).getTransitable()==true){
				Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y).eliminarEntidad();
				escarabajo.setPos(escarabajo.getPos().x, escarabajo.getPos().y-1);
				Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y).agregarEntidad(escarabajo);
			}
			break;
		case 1 : //Abajo
			if(escarabajo.getPos().y<7 && Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y+1).getTransitable()==true){
				Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y).eliminarEntidad();
				escarabajo.setPos(escarabajo.getPos().x, escarabajo.getPos().y+1);
				Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y).agregarEntidad(escarabajo);
			}
			break;
		case 2 : //Izquierda
			if(escarabajo.getPos().x>0 && Juego.getInstance().getCasillero(escarabajo.getPos().x-1,escarabajo.getPos().y).getTransitable()==true){
				Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y).eliminarEntidad();
				escarabajo.setPos(escarabajo.getPos().x-1, escarabajo.getPos().y);
				Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y).agregarEntidad(escarabajo);
			}
			break;
		case 3 : //Derecha
			if(escarabajo.getPos().x<7 && Juego.getInstance().getCasillero(escarabajo.getPos().x+1,escarabajo.getPos().y).getTransitable()==true){
				Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y).eliminarEntidad();
				escarabajo.setPos(escarabajo.getPos().x+1, escarabajo.getPos().y);
				Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y).agregarEntidad(escarabajo);
			}
			break;
		}
		//escarabajo.getGrafico().setBounds((escarabajo.getPos().x * 35)+11,(escarabajo.getPos().y * 35)+11, 34, 34);
		if(escarabajo.getGrafico() != null){
			Juego.getInstance().getMapa().remove(Juego.getInstance().getCasillero(xvieja, yvieja));
			escarabajo.getGrafico().setBounds((escarabajo.getPos().x * 35)+1,(escarabajo.getPos().y * 35)+1, 34, 34);
			Juego.getInstance().getMapa().add(Juego.getInstance().getCasillero(xvieja,yvieja).getFondo().getGrafico());
			Juego.getInstance().getMapa().remove(Juego.getInstance().getCasillero(escarabajo.getPos().x,escarabajo.getPos().y).getFondo().getGrafico());
			Juego.getInstance().getMapa().repaint();
		}
	}
	


	@Override
	public void atacar(Visitor v,Jugador j) {
		j.serAtacado(v);
	}
	
	
}
