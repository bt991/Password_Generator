public class Password {
    String value;
    int length;

    public Password(String s){
        value = s;
        length = s.length();
    }

    public int charType(char c){
        int category;
        int passwordCharValue = Character.getNumericValue(c);

        //Uppercase check
        if (passwordCharValue >= Character.getNumericValue('A') && passwordCharValue <= Character.getNumericValue('Z')) category = 1;

        //Lowercase check
        else if (passwordCharValue >= Character.getNumericValue('a') && passwordCharValue <= Character.getNumericValue('z')) category = 2;

        //Number check
        else if (passwordCharValue >= Character.getNumericValue('0') && passwordCharValue <= Character.getNumericValue('9')) category = 3;

        //Symbol check
        else category = 4;

        return category;
    }

    public int PasswordStrength(){
        String s = this.value;
        boolean upperCaseUsed = false;
        boolean lowerCaseUsed = false;
        boolean numbersUsed = false;
        boolean symbolsUsed = false;
        int type;

        for(int i = 0; i < s.length(); i++){
            type = charType(s.charAt(i));

            if (type == 1) upperCaseUsed = true;
            if (type == 2) lowerCaseUsed = true;
            if (type == 3) numbersUsed = true;
            if (type == 4) symbolsUsed = true;
        }
        return sumOfOverallRating(upperCaseUsed, lowerCaseUsed, numbersUsed, symbolsUsed, s.length());
    }

    private int sumOfOverallRating(boolean upperUsed, boolean lowerUsed, boolean numbersUsed, boolean symbolsUsed, int length){
        int overallRating = 0;

        if (upperUsed) overallRating += 1;
        if (lowerUsed) overallRating += 1;
        if (numbersUsed) overallRating += 1;
        if (symbolsUsed) overallRating += 1;

        if (length >= 8) overallRating += 1;
        if (length >= 16) overallRating += 1;

        return overallRating;
    }

    public String determineRating() {
        int rating = this.PasswordStrength();

        if (rating == 6) {
            return "This is a strong password. Nice work.";
        } else if (rating >= 4) {
            return "This is an above average password. It's still possible to create a stronger one.";
        } else if (rating == 3) {
            return "This is an average password. Try to make a stronger one.";
        } else {
            return "This is a weak password. It's advised to make a stronger one.";
        }
    }

    @Override
    public String toString(){
        return value;
    }
}
