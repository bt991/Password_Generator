import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner input;

    public Generator(Scanner scanner){
        input = scanner;
    }

    public Generator(boolean includeUpperCase, boolean includeLowerCase, boolean includeNumbers, boolean includeSymbols){
        alphabet = new Alphabet(includeUpperCase, includeLowerCase, includeNumbers, includeSymbols);
    }

    public void mainLoop(){
        System.out.println("Welcome to password generator");
        printMenu();

        String userOption = "-1";

        while(!userOption.equals("4")){
            userOption = input.next();

            switch (userOption){
                //Request a new password
                case "1": {
                    requestPassword();
                    printMenu();
                    break;
                }
                //Check password strength
                case "2": {
                    ratePasswordStrength();
                    printMenu();
                    break;
                }
                //Gives useful password information
                case "3": {
                    passwordTips();
                    printMenu();
                    break;
                }
                //Quit
                case "4": {
                    printQuitMessage();
                    break;
                }

                default: {
                    System.out.println("\nPlease select one of the options below.");
                    printMenu();
                }
            }
        }
    }
    private void requestPassword() {
        boolean includeUpperCase = false;
        boolean includeLowerCase = false;
        boolean includeNumbers = false;
        boolean includeSymbols = false;

        boolean correctParams;

        System.out.println("\nPlease answer the following questions about the type of password you would like to make.\n");

        do {
            String create;
            correctParams = false;

            do {
                System.out.println("Would you like to include uppercase letters?");
                create = input.next();
                passwordRequestError(create);
            } while (!create.equalsIgnoreCase("yes") && !create.equalsIgnoreCase("no"));

            if(isIncluded(create)) includeUpperCase = true;

            do {
                System.out.println("Would you like to include lowercase letters?");
                create = input.next();
                passwordRequestError(create);
            } while (!create.equalsIgnoreCase("yes") && !create.equalsIgnoreCase("no"));

            if(isIncluded(create)) includeLowerCase = true;

            do {
                System.out.println("Would you like to include numbers?");
                create = input.next();
                passwordRequestError(create);
            } while (!create.equalsIgnoreCase("yes") && !create.equalsIgnoreCase("no"));

            if(isIncluded(create)) includeNumbers = true;

            do {
                System.out.println("Would you like to include symbols?");
                create = input.next();
                passwordRequestError(create);
            } while (!create.equalsIgnoreCase("yes") && !create.equalsIgnoreCase("no"));

            if(isIncluded(create)) includeSymbols = true;

            if (!includeUpperCase && !includeLowerCase && !includeNumbers && !includeSymbols) {
                System.out.println("You have selected no characters to be included for your password, " +
                        "please specify yes for at least one category.\n");
                correctParams = true;
            }

        } while (correctParams);

        System.out.println("Please enter the length of the password you would like to create.");
        int length = input.nextInt();

        final Generator generator = new Generator(includeUpperCase,includeLowerCase,includeNumbers,includeSymbols);
        final Password password = generator.generatePassword(length);

        System.out.println("Your generated password is: " + password);
    }
    private void ratePasswordStrength() {
        String test;

        System.out.print("\nEnter your password: ");
        test = input.next();

        final Password password = new Password(test);
        System.out.println(password.determineRating());
    }
    private void passwordTips() {
        System.out.println("Use a minimum password length of 8." +
                "\nUse as many categories (uppercase, lowercase, numbers, symbols) as possibly allowed." +
                "\nAvoid using the same password twice." +
                "\nAvoid using any form of pattern or character repetition which may be easily identifiable." +
                "\nAvoid using passwords which may consist of birthdays or personal information which may be sensitive." +
                "\nWhere applicable, make sure to use randomly generated passwords for increased security.");
    }
    private Password generatePassword(int length) {
        final StringBuilder password = new StringBuilder();
        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++){
            int index = (int) ((Math.random() * range) + min);
            password.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(password.toString());
    }
    private void passwordRequestError(String create) {
        if (!create.equalsIgnoreCase("yes") && !create.equalsIgnoreCase("no")){
            System.out.println("Not a valid answer, please try again.");
        }
    }
    private void printQuitMessage() {
        System.out.println("Ending program.");
    }
    private boolean isIncluded(String input){
        return input.equalsIgnoreCase("yes");
    }
    private void printMenu(){
        System.out.println("\n" +
                "Enter 1 - Password Generator\n" +
                "Enter 2 - Check Password Strength\n" +
                "Enter 3 - Password Creation Tips\n" +
                "Enter 4 - Quit Program\n" +
                "Choice: ");
    }
}
