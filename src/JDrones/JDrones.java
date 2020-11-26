package JDrones;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.ButtonGroup;
import java.util.ArrayList;
public class JDrones extends javax.swing.JFrame {
    private DibujaDrones panel;
    private NumDron n;
    private BufferedImage ima;
    private MiX []x = new MiX[10];
    private MiY []y = new MiY[10];
    public int num=0;
    private Dron []d = new Dron[10];
    public JDrones() {
        
        initComponents();
        try{                                        // PASARLO a MENU
            ima = ImageIO.read(new File("mapaCU.png"));
        }catch(IOException e){e.printStackTrace();}
        ButtonGroup Algoritmo = new ButtonGroup();
        Algoritmo.add(Nada);
        Algoritmo.add(Muteps);
        Algoritmo.add(Sem);
        Algoritmo.add(var);
        Algoritmo.add(Moni);
        Algoritmo.add(Barr);
        panel= new DibujaDrones(ima,num);
        panel.setBounds(0, 0, 1345, 600);
        add(panel);
        inicia();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        Btncrea = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        Nada = new javax.swing.JRadioButtonMenuItem();
        Muteps = new javax.swing.JRadioButtonMenuItem();
        Sem = new javax.swing.JRadioButtonMenuItem();
        var = new javax.swing.JRadioButtonMenuItem();
        Moni = new javax.swing.JRadioButtonMenuItem();
        Barr = new javax.swing.JRadioButtonMenuItem();
        jMenu1 = new javax.swing.JMenu();
        borra = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Concurrente");
        setPreferredSize(new java.awt.Dimension(1200, 600));
        setResizable(false);

        jMenu2.setText("Drones");

        Btncrea.setText("Nuevo");
        Btncrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtncreaActionPerformed(evt);
            }
        });
        jMenu2.add(Btncrea);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Sincronizacion");

        Nada.setSelected(true);
        Nada.setText("Ningun metodo");
        jMenu5.add(Nada);

        Muteps.setText("Mutex");
        jMenu5.add(Muteps);

        Sem.setText("Semaforo");
        Sem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SemActionPerformed(evt);
            }
        });
        jMenu5.add(Sem);

        var.setText("Variable de condicion");
        jMenu5.add(var);

        Moni.setText("Monitores");
        jMenu5.add(Moni);

        Barr.setText("Barreras");
        jMenu5.add(Barr);

        jMenuBar1.add(jMenu5);

        jMenu1.setText("Otros");

        borra.setText("Limpiar");
        borra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borraActionPerformed(evt);
            }
        });
        jMenu1.add(borra);

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1487, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void BtncreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtncreaActionPerformed
       
        switch(num){
            case 0: 
                panel = new DibujaDrones(ima,num+1);
                 panel.setBounds(0, 0, 1345, 600);
                add(panel);
                d[0] = new Dron(x[0],y[0],panel,1200,550,0);
                panel.CreaCirculo();
                crea(1);
                
       break;
       
            case 1:
                
                mata(1);
                inicia();
                panel = new DibujaDrones(ima,num+1);
                 panel.setBounds(0, 0, 1345, 600);
                add(panel);
               
               d[0] = new Dron(x[0],y[0],panel,600,550,0);
               x[1] = new MiX(600);
               y[1] = new MiY(0);
               d[1] = new Dron(x[1],y[1],panel,1200,550,1);
               panel.CreaCirculo();
              crea(2);
       break;
       
            case 2:
               mata(2);
              inicia();
              panel = new DibujaDrones(ima,num+1);
                 panel.setBounds(0, 0, 1345, 600);
                add(panel);
                x[1] = new MiX(600);
                y[1] = new MiY(0);
                x[2] = new MiX(0);
                y[2] = new MiY(300);
                x[3] = new MiX(600);
                y[3] = new MiY(300);
                d[0] = new Dron(x[0],y[0],panel,600,300,0);
                d[1] = new Dron(x[1],y[1],panel,1200,300,1);
                d[2] = new Dron(x[2],y[2],panel,600,550,2);
                d[3] = new Dron(x[3],y[3],panel,1200,550,3);
                panel.CreaCirculo();
                crea(4);         
       break;
       
            case 3:
             mata(4);
              inicia();
              panel = new DibujaDrones(ima,num+1);
                 panel.setBounds(0, 0, 1345, 600);
                add(panel);
                x[1] = new MiX(600);
                y[1] = new MiY(0);
                x[2] = new MiX(0);
                y[2] = new MiY(200);
                x[3] = new MiX(0);
                y[3] = new MiY(400);
                x[4] = new MiX(600);
                y[4] = new MiY(200);
                x[5] = new MiX(600);
                y[5] = new MiY(400);
                d[0] = new Dron(x[0],y[0],panel,600,200,0);
                d[1] = new Dron(x[1],y[1],panel,1200,200,1);
                d[2] = new Dron(x[2],y[2],panel,600,400,2);
                d[3] = new Dron(x[3],y[3],panel,600,550,3);
                d[4] = new Dron(x[4],y[4],panel,1200,400,4);
                d[5] = new Dron(x[5],y[5],panel,1200,550,5);
                panel.CreaCirculo();
                crea(6);
                
        break;
        
            case 4:
              mata(6);
              inicia();
              panel = new DibujaDrones(ima,num+1);
                 panel.setBounds(0, 0, 1345, 600);
                add(panel);
                
                x[1] = new MiX(300);
                y[1] = new MiY(0);
                x[2] = new MiX(600);
                y[2] = new MiY(0);
                x[3] = new MiX(900);
                y[3] = new MiY(0);
                x[4] = new MiX(0);
                y[4] = new MiY(300);
                x[5] = new MiX(300);
                y[5] = new MiY(300);
                x[6] = new MiX(600);
                y[6] = new MiY(300);
                x[7] = new MiX(900);
                y[7] = new MiY(300);
                d[0] = new Dron(x[0],y[0],panel,300,300,0);
                d[1] = new Dron(x[1],y[1],panel,600,300,1);
                d[2] = new Dron(x[2],y[2],panel,900,300,2);
                d[3] = new Dron(x[3],y[3],panel,1200,300,3);
                d[4] = new Dron(x[4],y[4],panel,300,550,4);
                d[5] = new Dron(x[5],y[5],panel,600,550,5);
                d[6] = new Dron(x[6],y[6],panel,900,550,6);
                d[7] = new Dron(x[7],y[7],panel,1200,550,7);
                panel.CreaCirculo();
                crea(8);
                
        break;
        
            case 5:
                 mata(8);
              inicia();
              panel = new DibujaDrones(ima,num+1);
                 panel.setBounds(0, 0, 1345, 600);
                add(panel);
                
                x[1] = new MiX(240);
                y[1] = new MiY(0);
                x[2] = new MiX(480);
                y[2] = new MiY(0);
                x[3] = new MiX(720);
                y[3] = new MiY(0);
                x[4] = new MiX(960);
                y[4] = new MiY(0);
                x[5] = new MiX(0);
                y[5] = new MiY(300);
                x[6] = new MiX(240);
                y[6] = new MiY(300);
                x[7] = new MiX(480);
                y[7] = new MiY(300);
                x[8] = new MiX(720);
                y[8] = new MiY(300);
                x[9] = new MiX(960);
                y[9] = new MiY(300);
                d[0] = new Dron(x[0],y[0],panel,240,300,0);
                d[1] = new Dron(x[1],y[1],panel,480,300,1);
                d[2] = new Dron(x[2],y[2],panel,720,300,2);
                d[3] = new Dron(x[3],y[3],panel,960,300,3);
                d[4] = new Dron(x[4],y[4],panel,1200,300,4);
                d[5] = new Dron(x[5],y[5],panel,240,550,5);
                d[6] = new Dron(x[6],y[6],panel,480,550,6);
                d[7] = new Dron(x[7],y[7],panel,720,550,7);
                d[8] = new Dron(x[8],y[8],panel,960,550,8);
                d[9] = new Dron(x[9],y[9],panel,1200,550,9);
                panel.CreaCirculo();
                crea(10);
            break;
        }
        num++;
        if(num>5){
            Btncrea.setEnabled(false);
        }
    }//GEN-LAST:event_BtncreaActionPerformed

    private void SemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SemActionPerformed

    private void borraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borraActionPerformed
        // TODO add your handling code here:
        switch(num){
            case 1:
                    mata(1);
                    num=0;
                    panel= new DibujaDrones(ima,num);
                    panel.setBounds(0, 0, 1345, 600);
                    add(panel);
                    panel.CreaCirculo();
                    inicia();
            break;
            
            case 2:
                    mata(2);
                    num=0;
                    panel= new DibujaDrones(ima,num);
                    panel.setBounds(0, 0, 1345, 600);
                    add(panel);
                    panel.CreaCirculo();
                    inicia();                
            break;
            
            case 3:
                    mata(4);
                    num=0;
                    panel= new DibujaDrones(ima,num);
                    panel.setBounds(0, 0, 1345, 600);
                    add(panel);
                    panel.CreaCirculo();
                    inicia();                
            break;
            
            case 4:
                    mata(6);
                    num=0;
                    panel= new DibujaDrones(ima,num);
                    panel.setBounds(0, 0, 1345, 600);
                    add(panel);
                    panel.CreaCirculo();
                    inicia();                
            break;
            
            case 5:
                    mata(8);
                    num=0;
                    panel= new DibujaDrones(ima,num);
                    panel.setBounds(0, 0, 1345, 600);
                    add(panel);
                    panel.CreaCirculo();
                    inicia();                
            break;
            
            case 6:
                    mata(10);
                    num=0;
                    panel= new DibujaDrones(ima,num);
                    panel.setBounds(0, 0, 1345, 600);
                    add(panel);
                    panel.CreaCirculo();
                    inicia();
                    Btncrea.setEnabled(true);
            break;
        }
        
        
    }//GEN-LAST:event_borraActionPerformed
   
    public void crea(int f){
        
        try{
            for(int j = 0;j < f;j++){
                
                if(Nada.isSelected()){
                d[j].setAlgoritmo(0);
                }
                
                if(Muteps.isSelected()){
                d[j].setAlgoritmo(1);
                }
                if(Sem.isSelected()){
                d[j].setAlgoritmo(2);
                }
                if(var.isSelected()){
                d[j].setAlgoritmo(3);
                }
                if(Moni.isSelected()){
                d[j].setAlgoritmo(4);
                }
                if(Barr.isSelected()){
                d[j].setAlgoritmo(5);
                }
                
                d[j].start();
            }
            }catch(IllegalThreadStateException ex){ex.printStackTrace();}
    }
    
    public void inicia(){
         for(int i = 0;i < 10;i++){
            x[i] = new MiX(0);
            y[i] = new MiY(0);
        }
    }
    
    public void mata(int k){
       for(int i = 0;i < k;i++){
           if(d[i].isAlive())
                d[i].stop();               
        }
    }
    
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDrones().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem Barr;
    private javax.swing.JMenuItem Btncrea;
    private javax.swing.JRadioButtonMenuItem Moni;
    private javax.swing.JRadioButtonMenuItem Muteps;
    private javax.swing.JRadioButtonMenuItem Nada;
    private javax.swing.JRadioButtonMenuItem Sem;
    private javax.swing.JMenuItem borra;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButtonMenuItem var;
    // End of variables declaration//GEN-END:variables
}
