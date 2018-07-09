package Modelos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class CirculoGF extends Circulo implements Dibujable{

    Color color;
    
    public CirculoGF(Coordenada coor, float radio, Color color)
    {
        super(coor,radio);
        this.color= color;
    }
    
    @Override
    public void Dibujar(Graphics g) {
    
        g.setColor(color);
        g.fillOval( (int) (this.getX() - this.getRadio()),
                    (int) (this.getY() - this.getRadio()),
                    (int) (2 * this.getRadio()),
                    (int) (2 * this.getRadio()));
        
    }
    
    public void Pintar(Color color)
    {
        this.color = color;
    }
    
}
