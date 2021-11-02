package Inteligencia;

import java.util.Random;

import Entidades.Avispa;
import Entidades.Edificio;
import Entidades.Enemigo;
import Entidades.Jugador;
import General.Casilla;
import General.Juego;
import Visitor.Visitor;

public class IAvispa extends Inteligencia{
	private Avispa avispa;
	
	public IAvispa(Avispa a){
		avispa=a;
	}
	
	public void atacar(Visitor v,Jugador j) {
		j.serAtacado(v);
	}
	
	public void mover(){
		int xvieja=avispa.getPos().x;
		int yvieja=avispa.getPos().y;
		Random r = new Random();
		int n = r.nextInt(4);
		boolean movi=false;
		while(!movi){
			if(n==0){
				if(avispa.getPos().y>0){
					moverY(avispa.getPos().y,r.nextInt(avispa.getPos().y),avispa.getPos().x);
					movi = true;
				}
			}else{
				if(n==1){
					if(avispa.getPos().y<8){
						moverY(avispa.getPos().y,r.nextInt(8-avispa.getPos().y),avispa.getPos().x);
						movi=true;
					}
				}else{
					if(n==2){
						if(avispa.getPos().x>0){
							moverX(avispa.getPos().x,r.nextInt(avispa.getPos().x),avispa.getPos().y);
							movi=true;
						}
					}else{
						if(avispa.getPos().x<8){
							moverX(avispa.getPos().x,r.nextInt(8-avispa.getPos().x),avispa.getPos().y);
							movi=true;
						}
					}
				}
			}
			n = r.nextInt(4);
		}
		if(avispa.getGrafico() != null){
			Juego.getInstance().getMapa().remove(Juego.getInstance().getCasillero(xvieja, yvieja));
			avispa.getGrafico().setBounds((avispa.getPos().x * 35)+1,(avispa.getPos().y * 35)+1, 34, 34);
			Juego.getInstance().getMapa().add(Juego.getInstance().getCasillero(xvieja,yvieja).getFondo().getGrafico());
			Juego.getInstance().getMapa().remove(Juego.getInstance().getCasillero(avispa.getPos().x,avispa.getPos().y).getFondo().getGrafico());
			Juego.getInstance().getMapa().repaint();
		}

		
	}
	
	private boolean moverX(int x1,int x2,int y){
		boolean termine=false;
		int n=x2-x1;
		while(!termine && n!=0){
			if(Juego.getInstance().getCasillero(x1+n, y).getEntidad()==null){
				Juego.getInstance().getCasillero(x1,y).eliminarEntidad();
				Juego.getInstance().getCasillero(x1+n, y).agregarEntidad(avispa);
				avispa.setPos(x1+n,y);
				termine=true;
			}
			else
				if(n<0)
					n++;
				else
					n--;
		}

		return termine;
			
	}
	
	private boolean moverY(int y1,int y2,int x){
		boolean termine=false;
		int n=y2-y1;
		while(!termine && n!=0){
			if(Juego.getInstance().getCasillero(x, y1+n).getEntidad()==null){
				Juego.getInstance().getCasillero(x,y1).eliminarEntidad();
				Juego.getInstance().getCasillero(x,y1+n).agregarEntidad(avispa);
				avispa.setPos(x,y1+n);
				termine=true;
			}
			else
				if(n<0)
					n++;
				else
					n--;
		}
		return termine;
	}

	
}