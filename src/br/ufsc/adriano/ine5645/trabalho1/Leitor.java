package br.ufsc.adriano.ine5645.trabalho1;

import java.util.Random;

public class Leitor implements Runnable {

    private IBuffer sharedLocation;

    public Leitor(IBuffer shared) {

        sharedLocation = shared;

    }

    public void run() {

        for (int x = 0; x <= 120; x++) {
            sharedLocation.ler();
        }

    }

}
