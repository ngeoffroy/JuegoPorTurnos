 package General;

import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

import Entidades.Edificio;
import Entidades.Jugador;

public class Mapa extends JFrame{
	
	private Juego j;
	private JPanel pantalla;
	private static String respuestaX;
	private static String respuestaY; 
	private static int numEntero;
    private boolean añadirBuenos=true;
    private ArrayList<Jugador> buenos=new ArrayList<Jugador>();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mapa frame = new Mapa();
					frame.setVisible(true);
					frame.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Mapa(){
		
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 320);
                          
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     	setLayout(null);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(351, 351));
		Juego.inicializar(this);
		j=Juego.getInstance();
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//moverJugador(arg0);		
				
				/*Con espacio agregar los aliados al mapa*/
				if(arg0.getKeyCode()==KeyEvent.VK_SPACE && añadirBuenos){
						int nx=CoordenadaXRobot();
						int n=CoordenadaYRobot();
						if(n>3){
							JOptionPane.showMessageDialog(null,"Coordenada incorrecta, el programa se cerrará","Error", JOptionPane.WARNING_MESSAGE);
							System.exit( 0 ); }
						if(j.getCasillero(nx, n).getTransitable()==false){
							JOptionPane.showMessageDialog(null,"Coordenada incorrecta, el programa se cerrará","Error", JOptionPane.WARNING_MESSAGE);
							System.exit( 0 ); }
						j.agregarRobot(nx, n);
						
				
						nx=CoordenadaXTanque();
						int n2=CoordenadaYTanque();
						if(n2>3){
							JOptionPane.showMessageDialog(null,"Coordenada incorrecta, el programa se cerrará","Error", JOptionPane.WARNING_MESSAGE);
							System.exit( 0 ); }
						if(j.getCasillero(nx, n2).getTransitable()==false){
							JOptionPane.showMessageDialog(null,"Coordenada incorrecta, el programa se cerrará","Error", JOptionPane.WARNING_MESSAGE);
							System.exit( 0 ); }
						j.agregarTanque(nx, n2);
						añadirBuenos=false;
						j.iniciarTurnoEnemigo();
				}
					
				
				
				if(j.getAliados().size()>0)
					if(j.getTurnoEnemigo()==false){
						if(j.getTurnoMovimiento()){
							if(arg0.getKeyCode()==KeyEvent.VK_UP){
								j.getjugActual().mover(3);
							}
							if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
								j.getjugActual().mover(4);
							}
							if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
								j.getjugActual().mover(2);
							}
							if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
								j.getjugActual().mover(1);
							}
						}
				
						if(j.getTurnoAtaque()){
							if(arg0.getKeyCode()==KeyEvent.VK_W){
								j.getjugActual().atacar(3);
							}
							if(arg0.getKeyCode()==KeyEvent.VK_S){
								j.getjugActual().atacar(4);
							}
							if(arg0.getKeyCode()==KeyEvent.VK_D){
								j.getjugActual().atacar(2);
							}
							if(arg0.getKeyCode()==KeyEvent.VK_A){
								j.getjugActual().atacar(1);
							}
						}
						if(arg0.getKeyCode()==KeyEvent.VK_K){
							if(j.getTurnoMovimiento()){
								j.setTurnoMovimiento(false);
								System.out.println("Terminó la fase de movimiento. Ahora puedes atacar.");
								j.setTurnoAtaque(true);
							}else{
								if(j.getTurnoAtaque()){
									j.setTurnoAtaque(false);
									System.out.println("Terminó el turno");
									System.out.println();
									j.getjugActual().resetearPasos();
									j.siguienteTurno();
								}
							}
						}
					}}
			});
		
		}


		
	/*protected void moverJugador(KeyEvent key){
		j.moverJ(key.getKeyCode());
		this.repaint();
	}*/
	
	public static int CoordenadaXRobot(){
		respuestaX = JOptionPane.showInputDialog("Escribe la coordenada X para insertar el robot");
		numEntero = Integer.parseInt(respuestaX);
		return numEntero-1;
	}
	
	public static int CoordenadaYRobot(){
		respuestaY = JOptionPane.showInputDialog("Escribe la coordenada Y para insertar el robot, si el numero es mayor a 4 se cerrará el programa");
		numEntero = Integer.parseInt(respuestaY);
		return numEntero-1;
	}
	
	public static void verificarCasilleroRobot(){
		if(Juego.getInstance().getCasillero(CoordenadaXRobot(),CoordenadaYRobot()).getTransitable()==false){
			JOptionPane.showMessageDialog(null,"Coordenada incorrecta, el programa se cerrará","Error", JOptionPane.WARNING_MESSAGE);
			System.exit( 0 ); }
	}
	
	public static int CoordenadaXTanque(){
		respuestaX = JOptionPane.showInputDialog("Escribe la coordenada X para insertar el tanque");
		numEntero = Integer.parseInt(respuestaX);
		return numEntero-1;
	}
	
	public static int CoordenadaYTanque(){
		respuestaY = JOptionPane.showInputDialog("Escribe la coordenada y para insertar el tanque,si el numero es mayor a 4 se cerrará el programa");
		numEntero = Integer.parseInt(respuestaY);
		return numEntero-1;
	}
	
	public static void verificarCasilleroTanque(){
		if(Juego.getInstance().getCasillero(CoordenadaXTanque(),CoordenadaYTanque()).getTransitable()==false){
			JOptionPane.showMessageDialog(null,"Coordenada incorrecta, el programa se cerrará","Error", JOptionPane.WARNING_MESSAGE);
			System.exit( 0 ); }
	}

                  
    
}