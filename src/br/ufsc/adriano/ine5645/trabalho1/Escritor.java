package br.ufsc.adriano.ine5645.trabalho1;

import java.util.Random;

public class Escritor implements Runnable {

    private IBuffer sharedLocation;

    private int z;

    public Escritor(IBuffer shared) {

        sharedLocation = shared;

    }

    public void run() {

        for (int z = 0; z <= 120; z++) {

            sharedLocation.escrever(z);

        }

    }

}
