public class Alphabet {
    public static final String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    public static final String numbers = "1234567890";
    public static final String symbols = "!@#$%^&*()-_=+\\/~?";

    private final StringBuilder pool;

    public Alphabet(boolean upperCaseIncluded, boolean lowerCaseIncluded, boolean numbersIncluded, boolean symbolsIncluded){
        pool = new StringBuilder();
        if (upperCaseIncluded) pool.append(upperCaseLetters);
        if (lowerCaseIncluded) pool.append(lowerCaseLetters);
        if (numbersIncluded) pool.append(numbers);
        if (symbolsIncluded) pool.append(symbols);
    }

    public String Alphabet(){
        return pool.toString();
    }
}
