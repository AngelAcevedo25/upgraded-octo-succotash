package Ejecuciones;
import java.awt.*;
import java.util.ArrayList;
//Importando Todas Las clases del package Modelos.
import Modelos.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int Aleateorio(int max, int min)
    {
        return (int)(Math.random() * (max - 100));
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Ventana ventana = new Ventana("Juego de Naves");
        ArrayList ArrObj = new ArrayList();
        
        Coordenada coor1 = new Coordenada(250,250);
        Coordenada coor2 = new Coordenada(500,300);
        
        //Triangulo
        Coordenada coor3 = new Coordenada(475,525);
        Coordenada coor4 = new Coordenada(445,575);
        Coordenada coor5 = new Coordenada(505,575);
        
        TextoGrafico vidas = new TextoGrafico("Vidas: ",Color.WHITE,1700,50);
        vidas.setSize(35);
        ArrObj.add(vidas);
        

        TextoGrafico vida = new TextoGrafico("3",Color.MAGENTA,1700,150);
        vida.setSize(30);
        ArrObj.add(vida);
        
        
        TextoGrafico puntos = new TextoGrafico("Puntos: ",Color.WHITE,1700,250);
        puntos.setSize(35);
        ArrObj.add(puntos);
        
        TextoGrafico puntaje = new TextoGrafico("0 ",Color.MAGENTA,1700,350);
        puntaje.setSize(40);
        ArrObj.add(puntaje);
        
        TextoGrafico finalText = new TextoGrafico("FIN JUEGO",Color.WHITE,900,350);
        finalText.setSize(40);
        
        NaveGF nave = new NaveGF(coor3, coor4, coor5, Color.BLUE);
        ArrObj.add(nave);
        
        /*RectanguloGF rectangulo1 = new RectanguloGF(coor1,50,30,Color.ORANGE);
        ArrObj.add(rectangulo1);
        
        CirculoGF Circulo1 = new CirculoGF(coor2,50,Color.RED);
        ArrObj.add(Circulo1);*/
        
        int rango = Aleateorio(800,500);
        Coordenada salida = new Coordenada(rango,-25);
        RectanguloGF ast1= new RectanguloGF(salida,25,25,Color.YELLOW);
        
        int rango2 = Aleateorio(800,500);
        Coordenada salida2 = new Coordenada(rango2,-25);
        RectanguloGF ast2= new RectanguloGF(salida2,25,25,Color.YELLOW);
        
        int rango3 = Aleateorio(800,500);
        Coordenada salida3 = new Coordenada(rango3,-25);
        RectanguloGF ast3 = new RectanguloGF(salida3,25,25,Color.YELLOW);
        
        int rango4 = Aleateorio(800,500);
        Coordenada salida4 = new Coordenada(rango4,-25);
        RectanguloGF ast4= new RectanguloGF(salida4,25,25,Color.YELLOW);
        
        int rango5 = Aleateorio(800,500);
        Coordenada salida5 = new Coordenada(rango5,-25);
        RectanguloGF ast5 = new RectanguloGF(salida5,25,25,Color.YELLOW);
        
        
        ArrObj.add(ast1);
        ArrObj.add(ast2);
        ArrObj.add(ast3);
        ArrObj.add(ast4);
        ArrObj.add(ast5);
        
        PanelFG panel = new PanelFG(ArrObj);
        panel.refNave(nave);
        panel.refAst(ast1, ast2, ast3, ast4, ast5);
        panel.refPuntos(puntaje);
        panel.refVidas(vida);
        panel.refFinal(finalText);
        
        ventana.add(panel);
        ventana.setSize(1000,600);
        ventana.setVisible(true);
        panel.iniciar();
    }
    
}
