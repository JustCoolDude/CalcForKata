class Calculating {
    int result;
    int checkedResult;
    String finalResult;

    Calculating(short firstDigit, String operation, short secondDigit, short DigitTypeFlag) {
        this.result = calculation(operation, firstDigit, secondDigit);
        try {
            this.checkedResult = checkingResult(this.result, DigitTypeFlag);
        } catch (ThrowsException e) {
            System.err.println("throws Exception. Negative result for roman type digits!");
            System.exit(0);
        }
        if (DigitTypeFlag == 2) {
            this.finalResult = convertToRoman(this.checkedResult);
        } else {
            this.finalResult = Integer.toString(this.checkedResult);
        }

    }

    public String getFinalResult() {
        return finalResult;
    }

    private int calculation(String parseString, short firstDigit, short secondDigit) {
        int result = 0;
        switch (parseString) {
            case "-":
                result = firstDigit - secondDigit;
                break;
            case "+":
                result = firstDigit + secondDigit;
                break;
            case "*":
                result = firstDigit * secondDigit;
                break;
            case "/":
                result = firstDigit / secondDigit;
                break;
        }
        return result;
    }

    int checkingResult(int result, short digitTypeFlag) throws ThrowsException {
        if (result < 0 && digitTypeFlag == 2) {
            throw new ThrowsException("Wrong input");

        } else {
            return result;
        }
    }

    String convertToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
}
