package Services;

import Models.Caverna;
import Models.Direcao;

public class Mapa {
    public Caverna criarCaverna () {
        Caverna novoNo = new Caverna();
        return novoNo;
    }

    public void criarSubArvore(Caverna atual, Caverna oeste, Caverna leste, Caverna norte, Caverna sul) {
        atual.mapear(Direcao.OESTE, oeste);
        atual.mapear(Direcao.LESTE, leste);
        atual.mapear(Direcao.NORTE, norte);
        atual.mapear(Direcao.SUL, sul);
    }

    public void criarRaiz(Caverna atual, Caverna oeste, Caverna leste, Caverna norte, Caverna sul) {
        criarSubArvore(atual, oeste, leste, norte, sul);
    }
}
