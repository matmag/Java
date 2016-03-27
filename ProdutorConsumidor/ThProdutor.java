package br.edu.utfpr.exer06;

import javax.swing.JProgressBar;

/**
 *
 * @author Matheus
 */
public class ThProdutor extends Thread {
    
    private ObjCompartilhado obj;
    private JProgressBar pgbBuffer;
    private Boolean continua = true;
    
    public ThProdutor(ObjCompartilhado obj, JProgressBar pgbBuffer){
        this.obj = obj;
        this.pgbBuffer = pgbBuffer;
    }

    @Override
    public void run() {
        
        try {
            
            int qtd = 0;
            while(continua == true){
                qtd = obj.add((int)(Math.random()*10000));
                pgbBuffer.setValue(qtd);
            }   
            obj.finalizouProducao();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void acabouTempo(){
        continua = false;
    }
    
    
}
