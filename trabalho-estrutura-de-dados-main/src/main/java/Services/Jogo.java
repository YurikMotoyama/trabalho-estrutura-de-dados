package Services;

import Models.*;
import Views.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogo {

    private final int NUM_CAVERNAS = 25;
    Caverna[] cavernas = new Caverna[NUM_CAVERNAS];
    ArrayList<Integer> cavernasVisitadas = new ArrayList<>();

    int cavernaAtual = 1;
    Morcego morcego = new Morcego("Bat");
    Wumpus wumpus = new Wumpus("Wumpus");
    Poco poco = new Poco("Pit");
    Mapa mapa = new Mapa();
    Player player = new Player("");
    boolean fimDeJogo = false;

    public int compararCaverna(Caverna caverna) {
        int posicao = 0;
        for(int i = 0; i < cavernas.length; i++) {
            if(cavernas[i].equals(caverna)) {
                posicao = i;
                break;
            }
        }
        return posicao;
    }

    public boolean verificarInimigo(String inimigo) {
        if(cavernas[cavernaAtual].getLeste() != null) {
            if(cavernas[cavernaAtual].getLeste().getInimigo() != null) {
                if (cavernas[cavernaAtual].getLeste().getInimigo().getNome().equals(inimigo)) {
                    return true;
                }
            }
        }
        if(cavernas[cavernaAtual].getOeste() != null) {
            if(cavernas[cavernaAtual].getOeste().getInimigo() != null) {
                if (cavernas[cavernaAtual].getOeste().getInimigo().getNome().equals(inimigo)) {
                    return true;
                }
            }
        }
        if(cavernas[cavernaAtual].getNorte() != null) {
            if(cavernas[cavernaAtual].getNorte().getInimigo() != null) {
                if (cavernas[cavernaAtual].getNorte().getInimigo().getNome().equals(inimigo)) {
                    return true;
                }
            }
        }
        if(cavernas[cavernaAtual].getSul() != null) {
            if(cavernas[cavernaAtual].getSul().getInimigo() != null) {
                if (cavernas[cavernaAtual].getSul().getInimigo().getNome().equals(inimigo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificarVida() {
        if(player.getVida() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void verificarCavernas() {
        if(!fimDeJogo) {
            verificarWumpus();
        }
        if(!fimDeJogo) {
            verificarPoco();
        }
        if(!fimDeJogo) {
            verificarMorcego();
        }
        if(!fimDeJogo) {
            verificarFlechas();
        }
    }

    public void verificarWumpus() {
        Output output = new Output();
        if(verificarInimigo("Wumpus")) {
            output.printNearWumpus();
        }
        if(cavernas[cavernaAtual].getInimigo() != null) {
            if(cavernas[cavernaAtual].getInimigo().getNome().equals("Wumpus")) {
                output.printWumpusAttack();
                finalizarJogo();
            }
        }
    }

    public void verificarPoco() {
        Output output = new Output();
        if(verificarInimigo("Pit")) {
            output.printNearPit();
        }

        if(cavernas[cavernaAtual].getInimigo() != null) {
            if(cavernas[cavernaAtual].getInimigo().getNome().equals("Pit")) {
                player.setVida(player.getVida() - 50);
                output.printFallenPit();
            }
        }
        boolean vivo = verificarVida();
        if(!vivo) {
            output.printDefeat(player);
            finalizarJogo();
        }
    }

    public void verificarFlechas() {
        Output output = new Output();
        if(cavernas[cavernaAtual].getFlecha() != null) {
            player.setFlechas(player.getFlechas() + 1);
            cavernas[cavernaAtual].setFlecha(null);
            output.printArrowPickup();
        }
    }

    public void verificarMorcego() {
        Output output = new Output();
        if(verificarInimigo("Bat")) {
            output.printNearBat();
        }
        if(cavernas[cavernaAtual].getInimigo() != null) {
            if(cavernas[cavernaAtual].getInimigo().getNome().equals("Bat")) {
                Random r = new Random();
                int cavernaAleatoria = r.nextInt(25);
                cavernas[cavernaAleatoria].setPlayer(cavernas[cavernaAtual].getPlayer());
                cavernas[cavernaAtual].setPlayer(null);
                cavernaAtual = compararCaverna(cavernas[cavernaAleatoria]);
                cavernasVisitadas.add(cavernaAleatoria);
                output.printNearBat();
                verificarWumpus();
                verificarPoco();
                verificarMorcego();
            }
        }
    }

    public void iniciarJogo() {
        Output output = new Output();
        output.AskPlayerName();
        Input input = new Input();
        String nomeDoJogador = input.nameOfPlayer();

        player.setNome(nomeDoJogador);

        output.printStartMessage();
        for (int i= 0; i<25;i++){
            cavernas[i]= new Caverna();
        }

        mapa.setRaiz(cavernas[0], cavernas[1]);
        mapa.criarPrimeiraSubArvore(cavernas[1],cavernas[3],cavernas[2],cavernas[4] );

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

        cavernas[cavernaAtual].setPlayer(new Player(nomeDoJogador));

        public void andar(){
            while(!fimDeJogo) {
                String opcaoNorte;
                String opcaoLeste;
                String opcaoSul;
                String opcaoOeste;
                String opcaoFlecha;
                if(cavernas[cavernaAtual].getNorte() != null) {
                    opcaoNorte = "1 - Ir para o norte";
                } else {
                    opcaoNorte = "Não há caminho para o norte!";
                }
                if(cavernas[cavernaAtual].getLeste() != null) {
                    opcaoLeste = "2 - Ir para o leste ";
                } else {
                    opcaoLeste = "Não há caminho para o leste!";
                }
                if(cavernas[cavernaAtual].getSul() != null) {
                    opcaoSul = "3 - Ir para o sul ";
                } else {
                    opcaoSul = "Não há caminho para o sul!";
                }
                if(cavernas[cavernaAtual].getOeste() != null) {
                    opcaoOeste = "4 - Ir para o oeste ";
                } else {
                    opcaoOeste = "Não há caminho para o oeste!";
                }

              //  output.printMoveOptions(, nomeDoJogador, opcaoNorte, opcaoLeste, opcaoSul, opcaoOeste, opcaoFlecha);

                String opcao = input.promptUserForChoice();
                boolean eNumero = input.isValidOption(opcao);
                if (!eNumero) {
                    output.printOnlyNumbersAllowed();
                } else {
                    int numero = Integer.parseInt(opcao);
                    if (numero == 1) {
                        if (cavernas[cavernaAtual].getNorte() != null) {
                            cavernas[cavernaAtual].getNorte().setPlayer(cavernas[cavernaAtual].getPlayer());
                            cavernas[cavernaAtual].setPlayer(null);
                            cavernaAtual = compararCaverna(cavernas[cavernaAtual].getNorte());
                            cavernasVisitadas.add(cavernaAtual);
                            verificarCavernas();
                        } else {
                            output.printInvalidOption();
                        }
                    } else if (numero == 2) {
                        if (cavernas[cavernaAtual].getLeste() != null) {
                            cavernas[cavernaAtual].getLeste().setPlayer(cavernas[cavernaAtual].getPlayer());
                            cavernas[cavernaAtual].setPlayer(null);
                            cavernaAtual = compararCaverna(cavernas[cavernaAtual].getLeste());
                            cavernasVisitadas.add(cavernaAtual);
                            verificarCavernas();
                        } else {
                            output.printInvalidOption();
                        }
                    } else if (numero == 3) {
                        if (cavernas[cavernaAtual].getSul() != null) {
                            cavernas[cavernaAtual].getSul().setPlayer(cavernas[cavernaAtual].getPlayer());
                            cavernas[cavernaAtual].setPlayer(null);
                            cavernaAtual = compararCaverna(cavernas[cavernaAtual].getSul());
                            cavernasVisitadas.add(cavernaAtual);
                            verificarCavernas();
                        } else {
                            output.printInvalidOption();
                        }
                    } else if (numero == 4) {
                        if (cavernas[cavernaAtual].getOeste() != null) {
                            cavernas[cavernaAtual].getOeste().setPlayer(cavernas[cavernaAtual].getPlayer());
                            cavernas[cavernaAtual].setPlayer(null);
                            cavernaAtual = compararCaverna(cavernas[cavernaAtual].getOeste());
                            cavernasVisitadas.add(cavernaAtual);
                            verificarCavernas();
                        } else {
                            output.printInvalidOption();
                        }
                    } else if (numero == 5) {
                        if (player.getFlechas() > 0) {
                            atirar();
                        } else {
                            output.printNoArrows();
                        }
                    } else {
                        output.printInvalidOption();
                    }

                }

            }

        }

    }
    public void finalizarJogo() {
        fimDeJogo = true;
    }

}