import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner input;

    public Generator(Scanner input){
        input = input;
    }

    public Generator(boolean includeUpperCase, boolean includeLowerCase, boolean includeNumbers, boolean includeSymbols){
        alphabet = new Alphabet(includeUpperCase, includeLowerCase, includeNumbers, includeSymbols);
    }

    public void mainLoop(){
        System.out.println("Welcome to password generator");
        printMenu();

        String userOption = "-1";

        while(!userOption.equals(4)){
            userOption = input.next();

            switch (userOption){
                //Request a new password
                case "1": {
                    requestPassword();
                    printMenu();
                }
                //Check password strength
                case "2": {
                    printMenu();
                }
                //Gives useful password information
                case "3": {
                    printMenu();
                }
                //Quit
                case "4": printQuitMessage();
                default: {
                    System.out.println();
                    System.out.println("Please select one of the options below.");
                    printMenu();
                }
            }
        }
    }

    private void requestPassword() {
    }

    private void printQuitMessage() {
        System.out.println("Ending program.");
    }

    private void printMenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Check Password Strength");
        System.out.println("Enter 3 - Password Creation Tips");
        System.out.println("Enter 4 - Quit Program");
        System.out.println("Choice:");
    }
}
