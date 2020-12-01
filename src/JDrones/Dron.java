package JDrones;
import java.util.concurrent.Semaphore;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
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
    private Lock Vcondi;
    private Condition condi;
    private Lock mutex;
    private Lock mutexv;
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
        mutexv = new ReentrantLock();
        Vcondi = new ReentrantLock();
        condi = Vcondi.newCondition();
        
    }
    public synchronized void run(){
       
        switch(getAlgoritmo()){
            
            case 0: //Ningun metodo de sincronizacion
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
            
            case 1: //Mutex
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
            case 2:  //Semaforos
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
            
            case 3: //VAriable de condicion
            while(true){
            Vcondi.lock();
            try{
                condi.signal();
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
            }catch(Exception e){
            }
            finally{
                Vcondi.unlock();
            }
            try{
                Thread.sleep(5);
            }catch(Exception e){e.printStackTrace();} }
                
            case 4: //Monitores
                    while(true){
                    synchronized(panel){
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
                    }
                    try{
                        Thread.sleep(5);
                    }catch(Exception e){e.printStackTrace();} }
            
            case 5: //Barreras
                
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
