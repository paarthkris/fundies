package uk.ac.nulondon;

import java.io.IOException;
import java.util.Scanner;

/*APPLICATION CONTROLLER LAYER*/
public final class Main {
    private final ImageEditor editor = new ImageEditor();

    /**
     * Print the UI menu options to the user
     */
    private static void printMenu() {
        System.out.println("Please enter a command");
        System.out.println("g - Remove the greenest column");
        System.out.println("r[number] - Remove a specified column");
        System.out.println("u - Undo previous edit");
        System.out.println("q - Quit");
    }


    private void undo(Scanner scan) throws IOException {
        //todo
    }

    private void removeSpecific(Scanner scan, String choice) throws IOException {
        
        //todo
    }

    private void removeGreenest(Scanner scan) throws IOException {
        //todo
    }

    private void run() throws IOException {
        //Scanner is closeable, so we put it into try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            // src/main/resources/beach.png
            System.out.println("Welcome! Enter file path");
            String filePath = scan.next();
            // import the file
            editor.load(filePath);
            System.out.printf("The image contains %d columns%n", editor.getWidth());
            String choice = "";
            while (!"q".equalsIgnoreCase(choice)) {
                // display the menu after every edit
                printMenu();
                // get and handle user input
                choice = scan.next();
                String command = choice.isEmpty() ? "" : choice.substring(0, 1);
                switch (command.toLowerCase()) {
                    //Extract all the actions into methods besides the trivial ones
                    case "g" -> removeGreenest(scan);
                    case "r" -> removeSpecific(scan, choice);
                    case "u" -> undo(scan);
                    case "q" -> System.out.println("Thanks for playing.");
                    default -> System.out.println("That is not a valid option.");
                }
            }
            // After the user exits, export the final image
            editor.save("target/newImg.png");
        }
    }


    public static void main(String[] args) {
        /*Keep main method short. Only create a main class and execute
        the entry point. Also, you may handle specific exceptions here*/
        try {
            new Main().run();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
