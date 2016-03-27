package br.edu.utfpr.exer06;

import javax.swing.JProgressBar;

/**
 *
 * @author Matheus
 */
public class ThTempo extends Thread {
    
    private Integer tempo;
    private JProgressBar pgbProducao;
    private ThProdutor thProd;

    public ThTempo(Integer tempo, JProgressBar pgbProducao, ThProdutor thProd) {
        this.tempo = tempo;
        this.pgbProducao = pgbProducao;
        this.thProd = thProd;
    }

    @Override
    public void run() {
    
        int timer = (1000*60*tempo)/100;
        
        pgbProducao.setMaximum(timer);
        
        for (int i = 0; i < timer; i++) {
            pgbProducao.setValue(i);
            
            try{
                Thread.sleep(100);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            
        }
        
        thProd.acabouTempo();
   
    }
    
    
    
}
