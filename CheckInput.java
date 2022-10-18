class CheckInput {
    private short digitTypeFlag;
    final private String[] inputArrey;

    CheckInput(String inputString) {
        try {
            this.digitTypeFlag = setInput(inputString);
        } catch (ThrowsException e) {
            System.err.println("throws Exception. Wrong input!");
            System.exit(0);
        }
        this.inputArrey =inputString.split(" ");
    }

    private short setInput(String input) throws ThrowsException {
        short temp = romeOrArabianDigitsOrException(input);
        if (temp == 0) {
            throw new ThrowsException("Wrong input");

        }
        return temp;
    }

    public short getDigitTypeFlag() {
        return digitTypeFlag;
    }

    public String[] getInputArrey() {
        return inputArrey;
    }

    private short romeOrArabianDigitsOrException(String input) {
        short isRomanian = 0;
        if (input.matches("((\\d{1,2}) (\\+|\\-|\\*|\\/) (\\d{1,2}))")) {
            isRomanian = 1;

        } else if (input.matches("(I|V|X){1,4} (\\+|\\-|\\*|\\/) (I|V|X){1,4}")) {
            isRomanian = 2;

        } else {
            isRomanian = 0; // ThrowsException
        }
        return isRomanian;
    }
}
