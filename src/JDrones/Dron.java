package JDrones;
import java.util.concurrent.Semaphore;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Dron extends Thread{
    private MiX x;
    private MiY y;
    private DibujaDrones panel;
    private int a=5;
    private int b=5;
    private int X;
    private int Y;
    private int mX;
    private int mY;
    private int Dron;
    private int Algoritmo = 0;
    private Semaphore s = new Semaphore(1);
    private Lock mutex;
    Dron(MiX x, MiY y, DibujaDrones panel, int mX, int mY,int Dron){
        this.x=x;
        this.y=y;
        this.panel=panel;
        this.X=mX;
        this.Y=mY;
        this.mX=x.getX();
        this.mY=y.getY();
        this.Dron=Dron;
        mutex = new ReentrantLock();
    }
    public synchronized void run(){
       
        switch(getAlgoritmo()){
            
            case 0:
                while(true){
                    y.setY(y.getY()+b);
                    x.setX(x.getX()+a);        
                    if(x.getX()==X || x.getX()==mX){
                       a=-a;
                    }
                    if(y.getY()==Y || y.getY()==mY){
                       b=-b;
                    }
                    panel.ActuaslizaXY(x,y,Dron);
                    panel.repaint();
                    try{
                    Thread.sleep(5);
                    }catch(Exception e){e.printStackTrace();}    
                    
                }
            
            case 1:
                     while(true){
                         try{
                            if(mutex.tryLock()){
                                mutex.lock();
                                y.setY(y.getY()+b);
                                x.setX(x.getX()+a);
                                mutex.unlock();
                             }
                     if(x.getX()==X || x.getX()==mX){
                        a=-a;
                     }
                    if(y.getY()==Y || y.getY()==mY){
                        b=-b;
                     }
                     panel.ActuaslizaXY(x,y,Dron);
                     panel.repaint();
                    Thread.sleep(5);
                    }catch(Exception e){e.printStackTrace();}
                }
            case 2:
                     while(true){
                      try{   
                        s.acquire();
                      }catch(InterruptedException e1){}

                        y.setY(y.getY()+b);
                        x.setX(x.getX()+a);

                        if(x.getX()==X || x.getX()==mX){
                            a=-a;
                        }
                        if(y.getY()==Y || y.getY()==mY){
                            b=-b;
                        }
                     panel.ActuaslizaXY(x,y,Dron);
                     panel.repaint();
                     s.release();
                    try{
                    Thread.sleep(5);
                    }catch(Exception e){e.printStackTrace();}
                }
            
            case 3:
            
                
            case 4:
            
            
            case 5:
                
        }
       

    }

    /**
     * @return the Algoritmo
     */
    public int getAlgoritmo() {
        return Algoritmo;
    }

    /**
     * @param Algoritmo the Algoritmo to set
     */
    public void setAlgoritmo(int Algoritmo) {
        this.Algoritmo = Algoritmo;
    }
  
    
}
