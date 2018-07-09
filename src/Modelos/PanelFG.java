package Modelos;
import static Ejecuciones.Main.Aleateorio;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
/**
 *
 * @author user
 */

public class PanelFG extends JPanel implements KeyListener{

    ArrayList v;
    ArrayList ast = new ArrayList();
    Coordenada movDer = new Coordenada(25,0);
    Coordenada movIzq = new Coordenada(-25,0);
    Coordenada movNull = new Coordenada(0,0);
    NaveGF nave;
    
    int contAst = 5;
    TextoGrafico puntos;
    TextoGrafico vidas;
    TextoGrafico finalText;
    TextoGrafico nivelText;
    boolean cantVidas = true;
    int puntaje = 0;
    int vidasTotal = 3;
    int nivel;
    
    int mov = 10;
    int maxAst = 5;
    
    public  PanelFG   (ArrayList v) 
    {
        this.v = v;
        this.addKeyListener(this);
        setFocusable(true);
    }
    
    public void paint(Graphics g)
    {
        Dibujable dib;
        Dimension d = getSize();
        Image img = createImage(d.width, d.height);
        Graphics buff = img.getGraphics();
        
        for (int i = 0; i < v.size(); i++)
        {
            dib = (Dibujable)(v.get(i));
            dib.Dibujar(buff);
        }
        
        g.drawImage(img,0,0,null);
    }
    
    public void update(Graphics g)
    {
        paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int tecla = e.getKeyCode();
        
        if(tecla  == KeyEvent.VK_LEFT) this.nave.Mover(movIzq);
        
        if(tecla  == KeyEvent.VK_RIGHT) this.nave.Mover(this.movDer);
        
        if(tecla  == KeyEvent.VK_Z)
        {
            CirculoGF bala = nave.BalaGF();
            nave.balas.add(bala);
            v.add(bala);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        int tecla = e.getKeyCode();
        
        if(tecla  == KeyEvent.VK_LEFT) this.nave.Mover(this.movNull);
        
        if(tecla  == KeyEvent.VK_RIGHT) this.nave.Mover(this.movNull);
    }
    
    public void refNave(NaveGF n)
    {
        this.nave = n;
    }
    
    public void refPuntos(TextoGrafico a)
    {
        this.puntos = a;
    }
    
    public void refVidas(TextoGrafico a)
    {
        this.vidas = a;
    }
    
    public void refFinal(TextoGrafico a)
    {
        this.finalText = a;
    }
    
    public void refAst(RectanguloGF a, RectanguloGF b, RectanguloGF c, RectanguloGF d, RectanguloGF e)
    {
        ast.add(a);
        ast.add(b);
        ast.add(c);
        ast.add(d);
        ast.add(e);
    }
    
    public void Colision()
    {
        for (int i = 0; i < nave.balas.size(); i ++)
        {
            CirculoGF bala = (CirculoGF) nave.balas.get(i);
            for(int j = 0; j< ast.size();j++)
            {
                RectanguloGF aste    = (RectanguloGF) ast.get(j);
                Coordenada corBala   = new Coordenada (bala.getX(), bala.getY());
                Coordenada centro    = new Coordenada (aste.getX(),aste.getY());
                Coordenada derecha   = new Coordenada (aste.getX() + 35,aste.getY());
                Coordenada izquierda = new Coordenada (aste.getX() - 35,aste.getY());
                
                if(corBala.getX() > izquierda.getX() && corBala.getX() < derecha.getX() && corBala.getY() < centro.getY())
                {
                    aste.Pintar(Color.DARK_GRAY);
                    bala.Pintar(Color.DARK_GRAY);
                    bala.setY(-100);
                    aste.setX(-100);
                    nave.balas.remove(bala);
                    ast.remove(aste);
                    contAst--;
                    
                    this.puntaje += 5;
                    puntos.setColor(Color.DARK_GRAY);
                    TextoGrafico puntajeF = new TextoGrafico(""+this.puntaje,Color.MAGENTA,1700,350);
                    puntajeF.setSize(40);
                    puntos = puntajeF;
                    v.add(puntos);
                }
                
                if(centro.getY() > 525 && centro.getY() < 575 && 
                        nave.coor1.getX() < centro.getX()
                        && nave.coor2.getX() > centro.getX())
                {
                    vidasTotal = vidasTotal -1;
                    vidas.setColor(Color.DARK_GRAY);
                    TextoGrafico vida = new TextoGrafico(""+vidasTotal,Color.MAGENTA,1700,150);
                    vida.setSize(30);
                    this.vidas = vida;
                    v.add(vidas);
                    
                    ast.remove(aste);
                    aste.setY(-100);
                    contAst--;
                    
                    System.out.println("YES");
                }
            }
        }
    }
    
    public void iniciar()
    {
        while(cantVidas)
        {
            try
            {
                int i;
                for(i = 0; i < ast.size(); i++)
                {
                    RectanguloGF rect = (RectanguloGF) ast.get(i);
                    rect.Ciclo(mov);
                    if(rect.getY() > 600)
                    {
                        int rango = Aleateorio(800,500);
                        rect.setY(0);
                        rect.setX(rango);
                        
                    }
                }
                if(contAst < maxAst)
                {
                    int rango = Aleateorio(800,500);
                    Coordenada inicio = new Coordenada(rango,0);
                    RectanguloGF nvo = new RectanguloGF(inicio,25,25,Color.yellow);
                    ast.add(nvo);
                    nvo.Ciclo(mov);
                    v.add(nvo);
                    contAst++;
                }
                if(puntaje < 50)
                {
                    nivel = 1;
                    String niv = ""+nivel;
                    TextoGrafico texto = new TextoGrafico("NIVEL",Color.RED,1700,500);
                    texto.setSize(50);
                    TextoGrafico texto1 = new TextoGrafico(niv,Color.RED,1700,600);
                    texto1.setSize(50);
                    v.add(texto);
                    v.add(texto1);
                    finalText = texto1;
                }
                if(puntaje >= 50 && puntaje < 250)
                {
                    nivel = 2;
                    finalText.setColor(Color.DARK_GRAY);
                    TextoGrafico texto3 = new TextoGrafico(""+nivel,Color.RED,1700,600);
                    texto3.setSize(50);
                    v.add(texto3);
                    finalText = texto3;
                    mov = 12;
                    maxAst = 6;
                    for(i = 0; i < ast.size(); i++)
                    {
                        RectanguloGF rect = (RectanguloGF) ast.get(i);
                        rect.Pintar(Color.CYAN);
                    }
                }
                if(puntaje >= 250 && puntaje< 500)
                {
                    nivel = 3;
                    finalText.setColor(Color.DARK_GRAY);
                    TextoGrafico texto4 = new TextoGrafico(""+nivel,Color.RED,1700,600);
                    texto4.setSize(50);
                    v.add(texto4);
                    finalText = texto4;
                    mov = 14;
                    maxAst = 7;
                    for(i = 0; i < ast.size(); i++)
                    {
                        RectanguloGF rect = (RectanguloGF) ast.get(i);
                        rect.Pintar(Color.RED);
                    }
                }
                if(puntaje >= 500)
                {
                    nivel = 4;
                    finalText.setColor(Color.DARK_GRAY);
                    TextoGrafico texto5 = new TextoGrafico(""+nivel,Color.RED,1700,600);
                    texto5.setSize(50);
                    v.add(texto5);
                    finalText = texto5;
                    mov = 19;
                    maxAst = 9;
                    for(i = 0; i < ast.size(); i++)
                    {
                        RectanguloGF rect = (RectanguloGF) ast.get(i);
                        rect.Pintar(Color.PINK);
                    }
                }
                
                Colision();
                if(this.vidasTotal == 0)
                {
                    cantVidas = false;
                    v.add(finalText);
                    System.out.println("FIN JUEGO");
                }
                if(!nave.balas.isEmpty()) nave.Ciclo();
                Thread.sleep(50);
            }
            catch(InterruptedException err) { System.out.println(err);}
            
            repaint();
        }
    }
    
}
