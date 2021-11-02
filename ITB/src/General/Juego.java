package General;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import Entidades.*;
import Terreno.*;


public class Juego {

	private static Juego instancia;
	private static Mapa mapa;
	private ArrayList<Jugador> aliados;
	private ArrayList<Enemigo> enemigos;
    private Casilla [][] tablero ;
    private ArrayList<Edificio> misedificios;
    private boolean turnoTanque;
    private boolean turnoRobot;
    private Jugador jugActual;
	private boolean turnoMovimiento;
	private boolean turnoAtacar;
	private boolean turnoEnemigo;
	
	public static Juego getInstance() {
		if(instancia==null){
			instancia=new Juego(mapa);
		}
		return instancia;
	}

	public static void inicializar(Mapa m) {
		instancia=new Juego(m);
	}
	
	
	private Juego(Mapa m){
		mapa = m;
		aliados = new ArrayList<Jugador>();
		enemigos = new ArrayList<Enemigo>();
		misedificios=new ArrayList<Edificio>();
		crearTablero();
		agregarEnemigos();
		turnoEnemigo=true;
	}
	
	
	public void agregarEnemigos(){
		Enemigo e1;
		e1=new Escarabajo();
		enemigos.add(e1);
		e1=new Escarabajo();
		enemigos.add(e1);
		e1=new Avispa();
		enemigos.add(e1);
		Random r = new Random();
		int cantidadEnemigos = enemigos.size();
		boolean termine = false;
		while(!termine){
			int x = r.nextInt(8);
			int y = r.nextInt(4);
			y+=4;
			if(tablero[x][y].getTransitable()){
				Enemigo e = enemigos.get(cantidadEnemigos-1);

				mapa.remove(tablero[x][y].getFondo().getGrafico());
				tablero[x][y].agregarEntidad(e);
				enemigos.get(cantidadEnemigos-1).setPos(x, y);
				mapa.add(tablero[x][y].getEntidad().getGrafico());
				tablero[x][y].getEntidad().getGrafico().setBounds((x * 35)+1,(y * 35)+1, 34, 34);
				cantidadEnemigos--;
			}
			if(cantidadEnemigos==0)
				termine = true;
		}
	}
	
	public void agregarRobot(int x,int y){
		Jugador j=new Robot(x,y);
		aliados.add(j);
		mapa.remove(tablero[x][y].getFondo().getGrafico());
		tablero[x][y].agregarEntidad(j);
		mapa.add(tablero[x][y].getEntidad().getGrafico());
		tablero[x][y].getEntidad().getGrafico().setBounds((x * 35)+1,(y * 35)+1, 34, 34);
		tablero[x][y].setLocation(x, y);
		mapa.repaint();
	}
		
	public void agregarTanque(int x,int y){
		Jugador j = new Tanque(x,y);
		aliados.add(j);
		mapa.remove(tablero[x][y].getFondo().getGrafico());
		tablero[x][y].agregarEntidad(j);
		mapa.add(tablero[x][y].getEntidad().getGrafico());
		tablero[x][y].getEntidad().getGrafico().setBounds((x * 35)+1,(y * 35)+1, 34, 34);
		tablero[x][y].setLocation(x, y);
		mapa.repaint();
	}

	 public void crearTablero(){
         int x,y;
         tablero = new Casilla[8][8];
         for (int i = 0; i < 8; i++){
             for (int j = 0; j < 8; j++){
            	 tablero[i][j] = new Casilla(i,j); 
                 x = (i * 35)+1;
                 y = (j * 35)+1;
                 tablero[i][j].setFondo(new Tierra());
                 tablero[i][j].getFondo().getGrafico().setBounds(x, y, 34, 34);
 				 mapa.add(tablero[i][j].getFondo().getGrafico());
             }
         }
         generarTerrenoIntransitable();
    }
    
    private void generarTerrenoIntransitable(){
		Random r= new Random();
		//Añade aleatoriamente el terreno de la parte superior
		//int valor=r.nextInt(5);
    	for(int i=0; i<8;i++){
    		for(int j=0;j<8;j++){
    			if(j==0 || j==7 || j!=0 && j!=7 && i==0 || j!=0 && j!=7 && i==7){
    				int n= r.nextInt(2);
    				if(n==1){
    					mapa.remove(tablero[i][j].getFondo().getGrafico());
    					n=r.nextInt(2);
    					if(n==0)
    						tablero[i][j].setFondo(new Agua());
    					else
    						tablero[i][j].setFondo(new Montaña());
    					tablero[i][j].setTransitable(false);
    					mapa.add(tablero[i][j].getFondo().getGrafico());
    					tablero[i][j].getFondo().getGrafico().setBounds((i * 35)+1,(j * 35)+1, 34, 34);
    				}
    			}
    		/*	else{
    				int n= r.nextInt(10);
    				if(valor>0 && (n<5)){
    					valor--;
    					this.remove(casillas[i][j].getFondo().getGrafico());
    					n=r.nextInt(2);
    					if(n==0)
    						casillas[i][j].setFondo(new Agua());
    					else
    						casillas[i][j].setFondo(new Montaña());
    					casillas[i][j].getFondo().getGrafico().setBounds((i * 35)+1,(j * 35)+1, 34, 34);
    				}
    			}*/
    			}
    		}
    			int cantEdificios=8;
    			while(cantEdificios>0){
    				int n= r.nextInt(7);
    				if(n==0)
    					n++;
    				int m=r.nextInt(7);
    				if(m==0)
    					m++;
    				if(tablero[n][m].getTransitable()==true){
    					mapa.remove(tablero[n][m].getFondo().getGrafico());
    					Edificio nuevo= new Edificio();
    					nuevo.setPos(n, m);
    					tablero[n][m].agregarEntidad(nuevo);
    					mapa.add(tablero[n][m].getEntidad().getGrafico());
    					tablero[n][m].getEntidad().getGrafico().setBounds((n * 35)+1,(m * 35)+1, 34, 34);
    					cantEdificios--;
    	 				misedificios.add(nuevo);
    				}
    			}
    	}
    
    public Casilla[][] getTablero(){
    	return tablero;
    }
    
    public Mapa getMapa(){
    	return mapa;
    }
    
    public Casilla getCasillero(int i, int j){
    	return tablero[i][j];
    }
    
    public void agregarEnemigo(int f,int c,Entidad e){
    	tablero[f][c].agregarEntidad(e);
    }
    /*public Casilla edificioMasCercano(int x, int y){
    	Casilla nueva=null;
    	int distanciaMinima=20;
    	for(Edificio e:misedificios){
    		if(Math.abs((x-e.getPos().x)+(y-e.getPos().y))<distanciaMinima){
    			nueva=tablero[e.getPos().x][e.getPos().y];
    			distanciaMinima=Math.abs((x-e.getPos().x)+(y-e.getPos().y));
    		}
    	}
    	System.out.println("Posicion x del edificio"+nueva.getx());
    	System.out.println("Posicion y del edificio"+nueva.gety());
    	return nueva;
    }*/
    
    public ArrayList<Enemigo> getEnemigos(){
    	return enemigos;
    }
    
    public ArrayList<Jugador> getAliados(){
    	return aliados;
    }
    
    public ArrayList<Edificio> getEdificios(){
    	return misedificios;
    }

    public Enemigo obtenerEnemigo(int x, int y){
    	for(Enemigo e:enemigos){
    		if(e.getPos().x==x && e.getPos().y==y)
    			return e;
    	}
    	return null;
    }
    
    public void iniciarTurnoEnemigo(){
    	for(Enemigo e:enemigos){
    		if(!verificarVictoria()){
    			System.out.println("Turno enemigo.");
    			e.mover();
    			e.getattack().atacar();
    		}
    	}
    	if(aliados.size()>0 && misedificios.size()>4){
    		System.out.println("Turno aliado.");
    		siguienteTurno();
    	}
    	else
    		System.out.println("Perdiste.");
    }
 
    public boolean verificarVictoria(){
    	if(enemigos.size()==0)
    		return true;
    	return false;
    }
  
    
    public Jugador getjugActual(){
    	return jugActual;
    }
    
    public void setjugActual(Jugador j){
    	jugActual=j;
    }
    
    public Jugador obtenerTanque(){
    	if(aliados.size()==2)
    		return aliados.get(1);
    	else
    		if(aliados.size()==1)
    			if(aliados.get(0).getPasos()==5)
    				return aliados.get(0);
    	return null;
    }
    
    public Jugador obtenerRobot(){
    	if(aliados.size()==2)
    		return aliados.get(0);
    	else
    		if(aliados.size()==1)
    			if(aliados.get(0).getPasos()==3)
    				return aliados.get(0);
    	return null;
    }
    
    public void turnoJugadorAtaque(){
    	
    }
    
    public boolean getTurnoMovimiento(){
    	return turnoMovimiento;
    }
    
    public boolean getTurnoAtaque(){
    	return turnoAtacar;
    }
    
    public void setTurnoMovimiento(boolean b){
    	turnoMovimiento=b;
    }
    
    public void setTurnoAtaque(boolean b){
    	turnoAtacar=b;
    }

    public void TurnoJugadorRobot(){
    	turnoMovimiento=true;
    	if(turnoMovimiento==false){
    		turnoAtacar=true;
    	}
    }
    
    public void TurnoJugadorTanque(){
    	turnoMovimiento=true;
    	if(turnoMovimiento==false){
    		turnoAtacar=true;
    	}
    }
    
    /*public void siguienteTurno(){
    	if(turnoEnemigo){
    		turnoEnemigo=false;
    		jugActual=aliados.get(0);
			System.out.println("El jugador actual es " + jugActual.getNombre() + " y tiene " + jugActual.getPasos() + " pasos.");
    		turnoMovimiento=true;
    		turnoRobot=true;
    	}else
    		if(turnoRobot&&aliados.size()==2){
    			turnoRobot=false;
    			jugActual=aliados.get(1);
    			System.out.println("El jugador actual es " + jugActual.getNombre() + " y tiene " + jugActual.getPasos() + " pasos.");
    			turnoTanque=true;
    			turnoMovimiento=true;
    		}else{
    			turnoRobot=false;
    			turnoEnemigo=true;
    			iniciarTurnoEnemigo();
    		}		
    }*/
    
    public void siguienteTurno(){
    	if(!verificarVictoria()){
    		if(turnoEnemigo){
    			turnoEnemigo=false;
    			jugActual=obtenerTanque();
    			turnoTanque=true;
    			turnoMovimiento=true;
    			if(jugActual==null){
    				jugActual=obtenerRobot();
    				turnoTanque=false;
    				turnoRobot=true;
    			}
    			jugActual.resetearPasos();
    			System.out.println("Es el turno de " + jugActual.getNombre() +".");
    		}else{
    			if(turnoTanque){
    				turnoTanque=false;
    				jugActual=obtenerRobot();
    				turnoRobot=true;
    				turnoMovimiento=true;
    				jugActual.resetearPasos();
    				System.out.println("Es el turno de " + jugActual.getNombre() +".");
    				if(jugActual==null){
    					turnoMovimiento=false;
    					turnoEnemigo=true;
    					turnoRobot=false;
    					iniciarTurnoEnemigo();
    				}
    			}else{
    				turnoEnemigo=true;
    				turnoRobot=false;
    				iniciarTurnoEnemigo();
    			}
    		}
    	}else
    		System.out.println("Ganaste.");
    }
    

    public boolean getTurnoEnemigo(){
    	return turnoEnemigo;
    }
    
    public void matarEnemigo(){
    	
    }
    
    public boolean getTurnoTanque(){
    	return turnoTanque;
    }
    
    public boolean getTurnoRobot(){
    	return turnoRobot;
    }
    
}
