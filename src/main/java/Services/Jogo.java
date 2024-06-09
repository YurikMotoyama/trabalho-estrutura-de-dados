package Services;

import Models.*;
import Views.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {

    private final int NUM_CAVERNAS = 25;
    Caverna[] cavernas = new Caverna[NUM_CAVERNAS];

    Morcego morcego = new Morcego("Bat");
    Wumpus wumpus = new Wumpus("Wumpus");
    Poco poco = new Poco("poco");

    Mapa mapa = new Mapa();


    public void iniciarJogo() {
        Output output = new Output();
        output.AskPlayerName();
        Input input = new Input();
        String nomeDoJogador = input.nameOfPlayer();
        output.printStartMessage();
        for (int i= 0; i<25;i++){
            cavernas[i]= new Caverna();
        }

        mapa.setRaiz(cavernas[0], cavernas[1]);
        mapa.criarPrimeiraSubArvore(cavernas[1],cavernas[2],cavernas[3],cavernas[4] );

        cavernas[2].mapear(Direcao.NORTE, cavernas[1]);
        cavernas[2].mapear(Direcao.LESTE, cavernas[5]);
        cavernas[2].mapear(Direcao.SUL, cavernas[6]);
        cavernas[2].mapear(Direcao.OESTE, cavernas[7]);

        cavernas[3].mapear(Direcao.NORTE, cavernas[1]);
        cavernas[3].mapear(Direcao.LESTE, cavernas[8]);
        cavernas[3].mapear(Direcao.SUL, cavernas[9]);
        cavernas[3].mapear(Direcao.OESTE, cavernas[10]);

        cavernas[4].mapear(Direcao.NORTE, cavernas[1]);
        cavernas[4].mapear(Direcao.LESTE, cavernas[11]);
        cavernas[4].mapear(Direcao.SUL, cavernas[12]);
        cavernas[4].mapear(Direcao.OESTE, cavernas[13]);

        cavernas[5].mapear(Direcao.NORTE, cavernas[2]);
        cavernas[5].mapear(Direcao.LESTE, cavernas[14]);
        cavernas[5].mapear(Direcao.SUL, cavernas[15]);
        cavernas[5].mapear(Direcao.OESTE, cavernas[16]);

        cavernas[6].mapear(Direcao.NORTE, cavernas[2]);
        cavernas[6].mapear(Direcao.LESTE, cavernas[17]);
        cavernas[6].mapear(Direcao.SUL, cavernas[18]);
        cavernas[6].mapear(Direcao.OESTE, cavernas[19]);

        cavernas[7].mapear(Direcao.NORTE, cavernas[2]);
        cavernas[7].mapear(Direcao.LESTE, cavernas[20]);
        cavernas[7].mapear(Direcao.SUL, cavernas[21]);
        cavernas[7].mapear(Direcao.OESTE, cavernas[22]);

        cavernas[8].mapear(Direcao.NORTE, cavernas[3]);
        cavernas[8].mapear(Direcao.LESTE, cavernas[23]);
        cavernas[8].mapear(Direcao.SUL, cavernas[24]);
        cavernas[8].mapear(Direcao.OESTE, null);

        Random r = new Random();
        int cavernaMorcego = r.nextInt(24);
        cavernas[cavernaMorcego].inimigo=morcego;
        int cavernaPoco =0;
        while (cavernaPoco != cavernaMorcego){
            cavernaPoco=r.nextInt(24);
        }
        int cavernaWumpus =0;

        while (cavernaWumpus != cavernaMorcego && cavernaWumpus != cavernaPoco){
            cavernaWumpus=r.nextInt(24);
        }
        cavernas[cavernaWumpus].inimigo=wumpus;
        cavernas[cavernaPoco].inimigo=poco;
        cavernas[r.nextInt(24)].setFlecha(new Flecha("flecha 1"));
        cavernas[r.nextInt(24)].setFlecha( new Flecha("flecha 2"));
        cavernas[r.nextInt(24)].setFlecha(new Flecha("flecha 3"));

        cavernas[1].setPlayer(new Player(nomeDoJogador));


    }
}
