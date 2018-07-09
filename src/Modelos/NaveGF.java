package Modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;



/**
 *
 * @author user
 */
public class NaveGF extends Nave implements Dibujable{

    Color color;
    
    public NaveGF (Coordenada a,Coordenada b,Coordenada c, Color color)
    {
        super(a,b,c);
        this.color = color;
    }
    
    @Override
    public void Dibujar(Graphics g) 
    {
        g.setColor(this.color);
        
        int x[] = {(int)this.getX(),(int)this.coor1.getX(),(int)this.coor2.getX()};
        int y[] = {(int)this.getY(),(int)this.coor1.getY(),(int)this.coor2.getY()};
        
        Polygon p = new Polygon(x,y,3);
        
        g.fillPolygon(p);
    }
    
    public void Pintar(Graphics g, Color c) 
    {
        g.setColor(c);
        
        int x[] = {(int)this.getX(),(int)this.coor1.getX(),(int)this.coor2.getX()};
        int y[] = {(int)this.getY(),(int)this.coor1.getY(),(int)this.coor2.getY()};
        
        Polygon p = new Polygon(x,y,3);
        
        g.fillPolygon(p);
    }
    
    public CirculoGF BalaGF()
    {
        Coordenada salida = new Coordenada(this.getX(),this.getY());
        return new CirculoGF(salida, 10, Color.WHITE);
    }
    
    public void Ciclo()
    {
        for(int i= 0; i < this.balas.size(); i++)
        {
            CirculoGF y = (CirculoGF)this.balas.get(i);
            float x = y.getY();
            y.setY(x -= 20);
        }
    }
}
