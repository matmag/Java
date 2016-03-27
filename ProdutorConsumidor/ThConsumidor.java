/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.exer06;

import javax.swing.JProgressBar;

/**
 *
 * @author Matheus
 */
public class ThConsumidor extends Thread {
    
    private ObjCompartilhado obj;
    private JProgressBar pgbConsumidor;
    private JProgressBar pgbProd;
    
    public ThConsumidor(ObjCompartilhado obj, JProgressBar pgbConsumidor, JProgressBar pgbProd){
        this.obj = obj;
        this.pgbConsumidor = pgbConsumidor;
        this.pgbProd = pgbProd;
    }

    @Override
    public void run() {
        
        try {
            int qtd = 0;
            while(obj.contem()){
                qtd = obj.get();
                pgbProd.setValue(qtd);
                pgbConsumidor.setValue(100 - qtd);
            }
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    
}
