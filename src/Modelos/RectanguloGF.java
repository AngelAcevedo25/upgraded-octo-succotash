package Modelos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class RectanguloGF extends Rectangulo implements Dibujable{

    Color Color;

    public RectanguloGF(Coordenada coor,float x, float y ,Color Color) {
        
        super(coor, x, y);
        this.Color = Color;
    }
    
    
    @Override
    public void Dibujar(Graphics g) {
        
        g.setColor(Color);
        g.fillRect((int)this.getX(), (int)this.getY(), (int)this.getLado(1), (int)this.getLado(2));
        
    }
    
    public void Ciclo(int mov)
    {
        float x = this.getY();
        this.setY(x += mov);
    }
    
    public void Pintar(Color color)
    {
        this.Color = color;
    }
    
}
