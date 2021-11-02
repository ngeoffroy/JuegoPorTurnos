package General;

	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

import Entidades.Entidad;
import Terreno.Terreno;
	public class Casilla extends javax.swing.JPanel implements MouseListener {
	    
	    private Terreno fondo;
	    private Entidad entidadEnCasilla;
	    private int x;
	    private int y;
	    private boolean transitable;
	    private boolean transitableAntiguo;
	    
	    public Casilla(int x1,int y1) {
	        initComponents();       
	        x=x1;
	    	y=y1;
	    	transitable=true;
	    	entidadEnCasilla=null;
	    	transitableAntiguo=false;
	    }
	    
	    public void setFondo(Terreno fondo){
	        this.fondo = fondo;
	    }
	    
	    public Terreno getFondo(){        
	        return this.fondo;
	    }
	    
	                          
	    private void initComponents() {
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 161, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 193, Short.MAX_VALUE)
	        );
	    }                       
	    
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        //g.drawImage(fondo.getImage(), 0,0,this.getWidth(),this.getHeight(),this);
	    }
	    
	    public void mouseClicked(MouseEvent e){}
	    public void mouseEntered(MouseEvent e){}
	    public void mouseExited(MouseEvent e){}
	    public void mousePressed(MouseEvent e){}
	  /*          this.setCasillaMarcada(tablero.getCoordenadas((CasillasGUI)e.getComponent())); 
	            this.tablero.pintar(this.getCasillaMarcada()[0],this.getCasillaMarcada()[1]);
	    }*/
	    public void mouseReleased(MouseEvent e){}
	            
	    public void agregarEntidad(Entidad e){
	    	entidadEnCasilla=e;
	    	transitableAntiguo=transitable;
	    	transitable=false;
	    }
	    
	    public void eliminarEntidad(){
	    	entidadEnCasilla = null;
	    	transitable = transitableAntiguo;
	    	transitableAntiguo=false;
	    }
	    
	    public int getx(){
	    	return x;
	    }
	    
	    public int gety(){
	    	return y;
	    }

		public boolean getTransitable() {
			return transitable;
		}
	    
		public void setTransitable(boolean t){
			transitable=t;
		}
		
		public Entidad getEntidad(){
			return entidadEnCasilla;
		}

}