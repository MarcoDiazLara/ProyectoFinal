package JDrones;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.ArrayList;
public class DibujaDrones extends JPanel{
    private MiX []x =  new MiX[10];
    private MiY []y = new MiY[10];
    private NumDron n;
    private BufferedImage ima;
    private ArrayList<Ellipse2D> circulos;
    private int num;
    DibujaDrones(BufferedImage ima, int num){
        setBackground(Color.BLACK);
        this.ima=ima;
        this.n=n;
        this.num=num;
        circulos= new ArrayList<Ellipse2D>();
        for(int i = 0; i < 10;i++){
            x[i] = new MiX(0);
            y[i] = new MiY(0);
        }
    }
    public void paintComponent(Graphics g){
        int k = 0;
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
         g2.drawImage(ima, 0, 0, this);
        switch(num){
            case 1:   
        
            break;
            
            case 2:
            g2.setColor(Color.black);
            g2.fill(new Rectangle2D.Double(600, 0, 1, 700));
        
            break;
            
            case 3:
                g2.setColor(Color.black);
                g2.fill(new Rectangle2D.Double(600, 0, 1, 700));
                g2.fill(new Rectangle2D.Double(0,300,1200,1));
            break;
            
            case 4:
                g2.setColor(Color.black);
                g2.fill(new Rectangle2D.Double(600, 0, 1, 700));
                g2.fill(new Rectangle2D.Double(0,200,1200,1));
                g2.fill(new Rectangle2D.Double(0,400,1200,1));
            break;
            
            case 5:
                g2.setColor(Color.black);
                g2.fill(new Rectangle2D.Double(0, 300, 1200, 1));
                g2.fill(new Rectangle2D.Double(300, 0, 1, 700));
                g2.fill(new Rectangle2D.Double(600, 0, 1, 700));
                g2.fill(new Rectangle2D.Double(900, 0, 1, 700));
                break;
            
            case 6:
                g2.setColor(Color.black);
                g2.fill(new Rectangle2D.Double(0, 300, 1200, 1));
                g2.fill(new Rectangle2D.Double(240, 0, 1, 700));
                g2.fill(new Rectangle2D.Double(480, 0, 1, 700));
                g2.fill(new Rectangle2D.Double(720, 0, 1, 700));
                g2.fill(new Rectangle2D.Double(960, 0, 1, 700));
                //g2.fill(new Rectangle2D.Double(1200, 0, 1, 700));
                break;
        }
        for(Ellipse2D c:circulos){
            c.setFrame(x[k].getX(), y[k].getY(), 20, 20);
            g2.fill((Ellipse2D)c);
            k++;
            }
             g2.setColor(Color.white);
        
    }
    public void CreaCirculo(){
        int aux=0;
        circulos.clear();
        switch(num){
            case 0:
                aux=0;
            break;
            
            case 1:
                aux=1;
            break;
            
            case 2:
                aux=2;
            break;
            
            case 3:
                aux=4;
            break;
            
            case 4:
                aux=6;
            break;
            
            case 5:
                aux=8;
            break;
            
            case 6:
                aux=10;
            break;
        }
        for(int i = 0; i < aux;i++){
        circulos.add(new Ellipse2D.Double());
        }
    }
    public void ActuaslizaXY(MiX x, MiY y,int nd){
        this.x[nd] = x;
        this.y[nd] = y;
    }
}
