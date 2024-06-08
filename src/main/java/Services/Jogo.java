package Services;

import Models.*;
import Views.Output;

import java.util.ArrayList;
import java.util.List;

public class Jogo {

    private final int NUM_CAVERNAS = 25;
    Caverna[] cavernas = new Caverna[NUM_CAVERNAS];
    List<Integer> cavernasVisitadas = new ArrayList<>();
    int cavernaAtual;
    int flechasRestantes = 3;
    boolean fimDeJogo = false;

     Mapa mapa = new Mapa();

     Player jogador = new Player("Jogador");
     Wumpus wumpus = new Wumpus("Wumpus");
     Poco poco1 = new Poco("Poço1");
     Poco poco2 = new Poco("Poço2");
     Morcego morcego = new Morcego("Morcego");




    public void iniciarJogo(){
        Output output = new Output();
        output.printStartMessage();

        for (int j = 0; j < cavernas.length; j++) {
            cavernas[j] = mapa.criarCaverna();
        }
        mapa.criarSubArvore(cavernas[24], cavernas[23], null, cavernas[19], null);
        mapa.criarSubArvore(cavernas[23], cavernas[22], cavernas[24], cavernas[18], null);
        mapa.criarSubArvore(cavernas[22], cavernas[21], cavernas[23], cavernas[17], null);
        mapa.criarSubArvore(cavernas[21], cavernas[20], cavernas[22], cavernas[16], null);
        mapa.criarSubArvore(cavernas[20], null, cavernas[21], cavernas[15], null);
        mapa.criarSubArvore(cavernas[19], cavernas[18], null, cavernas[14], cavernas[24]);
        mapa.criarSubArvore(cavernas[18], cavernas[17], cavernas[19], cavernas[13], cavernas[23]);
        mapa.criarSubArvore(cavernas[17], cavernas[16], cavernas[18], cavernas[12], cavernas[22]);
        mapa.criarSubArvore(cavernas[16], cavernas[15], cavernas[17], cavernas[11], cavernas[21]);
        mapa.criarSubArvore(cavernas[15], null, cavernas[16], cavernas[10], cavernas[20]);
        mapa.criarSubArvore(cavernas[14], cavernas[13], null, cavernas[9], cavernas[19]);
        mapa.criarSubArvore(cavernas[13], cavernas[12], cavernas[14], cavernas[8], cavernas[18]);
        mapa.criarSubArvore(cavernas[12], cavernas[11], cavernas[13], cavernas[7], cavernas[17]);
        mapa.criarSubArvore(cavernas[11], cavernas[10], cavernas[12], cavernas[6], cavernas[16]);
        mapa.criarSubArvore(cavernas[10], null, cavernas[11], cavernas[5], cavernas[15]);
        mapa.criarSubArvore(cavernas[9], cavernas[8], null, cavernas[4], cavernas[14]);
        mapa.criarSubArvore(cavernas[8], cavernas[7], cavernas[9], cavernas[3], cavernas[13]);
        mapa.criarSubArvore(cavernas[7], cavernas[6], cavernas[8], cavernas[2], cavernas[12]);
        mapa.criarSubArvore(cavernas[6], cavernas[5], cavernas[7], cavernas[1], cavernas[11]);
        mapa.criarSubArvore(cavernas[5], null, cavernas[6], cavernas[0], cavernas[10]);
        mapa.criarSubArvore(cavernas[4], cavernas[3], null, null, cavernas[9]);
        mapa.criarSubArvore(cavernas[3], cavernas[2], cavernas[4], null, cavernas[8]);
        mapa.criarSubArvore(cavernas[2], cavernas[1], cavernas[3], null, cavernas[7]);
        mapa.criarSubArvore(cavernas[1], cavernas[0], cavernas[2], null, cavernas[6]);
        mapa.criarRaiz(cavernas[0], null, cavernas[1], null, cavernas[5]);

    }
}
