package Services;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner = new Scanner(System.in);

    public String promptUserForChoice() {
        return scanner.next();
    }

    public boolean isValidOption(String option) {
        return option.matches("\\d+");
    }
}
