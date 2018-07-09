package Modelos;

/**
 *
 * @author user
 */
public class Circulo extends Coordenada{

    private float radio;
    
    public Circulo()
    {
        super();
        this.radio = 0;
    }
    
    public Circulo(Coordenada coor, float radio)
    {
        super(coor);
        this.radio = radio;
    }
    
    public Circulo(Circulo cr)
    {
        super(cr);
        this.radio =  cr.radio;
                
    }
    
    public float getRadio()
    {
        return this.radio;
    }
    
    public void setRadio(float radio)
    {
        this.radio = radio;
    }
    
    public Coordenada getCentro()
    {
        return new Coordenada(this.getX(),this.getY());
    }
}
