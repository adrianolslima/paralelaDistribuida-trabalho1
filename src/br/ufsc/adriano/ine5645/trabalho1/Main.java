package br.ufsc.adriano.ine5645.trabalho1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        
        ExecutorService executar_leitor = Executors.newFixedThreadPool(4);
        ScheduledExecutorService executar_escritor = Executors.newScheduledThreadPool(1);
        Buffer sharedLocation = new Buffer();
        
        try {
            
            executar_escritor.scheduleAtFixedRate(new Escritor(sharedLocation), 0, 1, TimeUnit.MILLISECONDS);
            executar_leitor.submit(new Leitor(sharedLocation));
                    
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
        
        executar_leitor.shutdown();
        executar_escritor.shutdown();
    }
}
