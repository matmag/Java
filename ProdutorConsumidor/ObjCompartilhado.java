package br.edu.utfpr.exer06;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JProgressBar;

/**
 *
 * @author Matheus
 */
public class ObjCompartilhado {
    
    private List<Integer> lista = new ArrayList<>();
    private Integer maxBuffer = 100;
    private Integer minBuffer = 60;
    private Boolean finalizouProducao = false;
    
    
    public synchronized Integer add(Integer value) throws Exception{
        
        if (lista.size() == maxBuffer){
            wait();
            return add(value);
        }else {
            lista.add(value);
            notify();
            return lista.size();
        }
    }
    
    public synchronized Integer get() throws Exception{
        if (!lista.isEmpty()){
            
            try{
                lista.remove(0);
                return lista.size();
            }finally{
                if (lista.size() < minBuffer){
                    notify();
                }
            }                        
        }else {           
            wait();          
            return get();
        }
                       
    }
    
    
    public synchronized void finalizouProducao(){
        finalizouProducao = true;
    }
    
    public synchronized Boolean contem() throws Exception{
        
        if(finalizouProducao == false){
            if(!lista.isEmpty()){
                return true;
            }else{
                wait();
                return contem();
            }
        }else if(lista.isEmpty()){
            return false;
        }
        return true;
    }
}
