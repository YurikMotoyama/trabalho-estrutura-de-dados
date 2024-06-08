package Views;

import Models.Player;
import java.util.ArrayList;

public class Output {

    private static final String MENU_TITLE = "BEM-VINDO AO HUNT THE WUMPUS";
    private static final String MENU_START_GAME = "1 - Iniciar o jogo";
    private static final String MENU_EXIT = "2 - Sair";
    private static final String INVALID_OPTION = "Opção inválida. Tente novamente.";
    private static final String ONLY_NUMBERS_ALLOWED = "Somente números são permitidos!";
    private static final String YOU_AWAKE_IN_CAVERN = "Você acorda em uma caverna escura e úmida...";
    private static final String PATH_TRAVERSED = "Caminho percorrido: ";
    private static final String LIFE_STATUS = "Vida: ";
    private static final String ARROW_STATUS = "Flechas: ";
    private static final String BACK_OPTION = "5 - Voltar";
    private static final String NO_ARROWS_MESSAGE = "Você está sem flechas!";
    private static final String VICTORY_MESSAGE = "Você derrotou o terrível monstro Wumpus!";
    private static final String DEFEAT_MESSAGE = "Que pena! Você morreu...";
    private static final String MISS_MESSAGE = "Errou o alvo!";
    private static final String BREEZE_NEARBY = "Você sente uma brisa suave...";
    private static final String FALLEN_IN_PIT = "Você caiu em um poço e se machucou (-50 de vida)";
    private static final String BAT_FLAPPING_NEARBY = "Ouviu um bater de asas...";
    private static final String CARRIED_BY_BAT = "Um morcego te encontrou e te levou para outra caverna!";
    private static final String WUMPUS_ODOR_NEARBY = "Você sente um cheiro horrível...";
    private static final String WUMPUS_ATTACK = "Você entrou na caverna do Wumpus e ele te atacou!";
    private static final String PICKED_UP_ARROW = "Você pegou uma flecha";
    private static final String OUT_OF_ARROWS = "Todas as flechas acabaram. Você não pode mais matar o monstro!";
    private static final String GAME_OVER = "Obrigado por jogar! Volte novamente a qualquer momento";

    public void printMainMenuOptions() {
        System.out.println(MENU_TITLE);
        System.out.println(MENU_START_GAME);
        System.out.println(MENU_EXIT);
    }

    public void printOnlyNumbersAllowed() {
        System.out.println(ONLY_NUMBERS_ALLOWED);
    }

    public void printInvalidOption() {
        System.out.println(INVALID_OPTION);
    }

    public void printStartMessage() {
        System.out.println(YOU_AWAKE_IN_CAVERN);
    }

    public void printMoveOptions(ArrayList<Integer> visitedCaves, Player player, String northOption,
                                 String eastOption, String southOption, String westOption, String shootOption) {
        StringBuilder sb = new StringBuilder();
        sb.append(PATH_TRAVERSED).append(visitedCaves).append("\n")
                .append(LIFE_STATUS).append(player.getVida()).append("\n")
                .append(ARROW_STATUS).append(player.getFlechas()).append("\n")
                .append(northOption).append("\n")
                .append(eastOption).append("\n")
                .append(southOption).append("\n")
                .append(westOption).append("\n")
                .append(shootOption);
        System.out.println(sb.toString());
    }

    public void printShootOptions(ArrayList<Integer> visitedCaves, Player player, String northOption,
                                  String eastOption, String southOption, String westOption) {
        StringBuilder sb = new StringBuilder();
        sb.append(PATH_TRAVERSED).append(visitedCaves).append("\n")
                .append(LIFE_STATUS).append(player.getVida()).append("\n")
                .append(ARROW_STATUS).append(player.getFlechas()).append("\n")
                .append(northOption).append("\n")
                .append(eastOption).append("\n")
                .append(southOption).append("\n")
                .append(westOption).append("\n")
                .append(BACK_OPTION);
        System.out.println(sb.toString());
    }

    public void printNoArrows() {
        System.out.println(NO_ARROWS_MESSAGE);
    }

    public void printVictory() {
        System.out.println(VICTORY_MESSAGE);
    }

    public void printDefeat(Player player) {
        System.out.println(LIFE_STATUS + player.getVida());
        System.out.println(DEFEAT_MESSAGE);
    }

    public void printMiss() {
        System.out.println(MISS_MESSAGE);
    }

    public void printNearPit() {
        System.out.println(BREEZE_NEARBY);
    }

    public void printFallenPit() {
        System.out.println(FALLEN_IN_PIT);
    }

    public void printNearBat() {
        System.out.println(BAT_FLAPPING_NEARBY);
    }

    public void printCarriedByBat() {
        System.out.println(CARRIED_BY_BAT);
    }

    public void printNearWumpus() {
        System.out.println(WUMPUS_ODOR_NEARBY);
    }

    public void printWumpusAttack() {
        System.out.println(WUMPUS_ATTACK);
    }

    public void printArrowPickup() {
        System.out.println(PICKED_UP_ARROW);
    }

    public void printOutOfArrows() {
        System.out.println(OUT_OF_ARROWS);
    }
    public void printGameOver(){
        System.out.println(GAME_OVER);
    }
}
