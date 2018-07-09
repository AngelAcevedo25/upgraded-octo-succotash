package Modelos;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Nave extends Coordenada{
    
    //Toma el lugar de la coordenada del al izquierda
    public Coordenada coor1 = new Coordenada();
    //Toma el lugar de la coordenada de la derecha
    public Coordenada coor2 = new Coordenada();
    ArrayList balas = new ArrayList();
    
    public Nave ()
    {
        super();
        this.coor1.setX(0);
        this.coor1.setY(0);
        
        this.coor2.setX(0);
        this.coor2.setY(0);
    }
    
    public Nave (Coordenada a, Coordenada b, Coordenada c)
    {
        super(a.getX(),a.getY());
        
        this.coor1.setX(b.getX());
        this.coor1.setY(b.getY());
        
        this.coor2.setX(c.getX());
        this.coor2.setY(c.getY());
    }
    
    public Nave (Nave nva)
    {
        super(nva.getX(),nva.getY());
        
        this.coor1.setX((nva.getX()));
        this.coor1.setY((nva.getY()));
        
        this.coor2.setX((nva.getX()));
        this.coor2.setY((nva.getY()));
    }
    
    public void setVertice(Coordenada nva, int lado)
    {
        
        if(lado == 1)
        {
            this.setX(nva.getX());
            this.setY(nva.getY());
        }
        if(lado == 2)
        {
            this.coor1.setX(nva.getX());
            this.coor1.setY(nva.getY());
        }
        if(lado == 3)
        {
            this.coor2.setX(nva.getX());
            this.coor2.setY(nva.getY());
        }        
    }
    
    public void Mover(Coordenada coor)
    {
        setVertice(this.Suma(coor),1);
        setVertice(this.coor1.Suma(coor),2);
        setVertice(this.coor2.Suma(coor),3);
    }
    
}
