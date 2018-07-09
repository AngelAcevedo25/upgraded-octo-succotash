package Modelos;

/**
 *
 * @author user
 */

public class Rectangulo extends Coordenada{
    
    private float lado1;
    private float lado2;

    public Rectangulo() {
        
        //Se inicializa el contructor de Coordenada;
        super();
        this.lado1 = 0;
        this.lado2 = 0;
    }

    public Rectangulo(Coordenada coor,float lado1, float lado2) {
        
        super(coor);
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    
    public Rectangulo(Rectangulo nvo)
    {
        super(nvo.getX(),nvo.getY());
        this.lado1 = nvo.lado1;
        this.lado2 = nvo.lado2;
    }
    
    public float getLado(int lado)
    {
        if (lado == 1)
        {
            return this.lado1;
        }
        if (lado == 2)
        {
            return this.lado2;
        }
        return 0;
    }
    
    
}
