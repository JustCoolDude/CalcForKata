public class Main {
    public static void main(String[] args) {
        String input = "IX * X";
        calc(input);
        System.out.println(calc(input));
    }
    public static String calc(String input) {
        CheckInput checkInput = new CheckInput(input);
        ParceDigit parceDigit = new ParceDigit(checkInput.getInputArrey(), checkInput.getDigitTypeFlag());
        Calculating calculating = new Calculating(parceDigit.getCheckedFirstDigit(), checkInput.getInputArrey()[1], parceDigit.getCheckedSecondDigit(), checkInput.getDigitTypeFlag());
        String result = "";
        result = calculating.getFinalResult();
        return result;
    }
}