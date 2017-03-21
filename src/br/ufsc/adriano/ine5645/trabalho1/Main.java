package br.ufsc.adriano.ine5645.trabalho1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        
        ExecutorService executarLeitor = Executors.newFixedThreadPool(4);
        ScheduledExecutorService executarEscritor = Executors.newScheduledThreadPool(1);
        Buffer sharedLocation = new Buffer();
        
        try {            
            executarEscritor.scheduleAtFixedRate(new Escritor(sharedLocation), 0, 1, TimeUnit.MILLISECONDS);
            executarLeitor.submit(new Leitor(sharedLocation));
                    
        } catch (Exception e) {            
            e.printStackTrace();
            
        }
        
        executarLeitor.shutdown();
        executarEscritor.shutdown();
    }
}
