package Modelos;

/**
 *
 * @author user
 */
public class Coordenada {

    private float x;
    private float y;

    public Coordenada() 
    {
        this.x = 0;
        this.y = 0;
    }

    public Coordenada(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public Coordenada(Coordenada nva)
    {
        this.x = nva.x;
        this.y = nva.y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public Coordenada Suma(Coordenada coor)
    {
        return new Coordenada(this.x += coor.getX(),this.y += coor.getY());
    }
    
}
