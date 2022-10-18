import java.util.HashMap;

class ParceDigit {
    private short firstDigit;
    private short secondDigit;
    private short checkedFirstDigit;
    private short checkedSecondDigit;

    ParceDigit(String[] arreyInput, short digitTypeFlag) {
        if (digitTypeFlag == 1) {
            this.firstDigit = (short) Integer.parseInt(arreyInput[0]);
            this.secondDigit = (short) Integer.parseInt(arreyInput[2]);

        } else if (digitTypeFlag == 2) {
            this.firstDigit = (short) romanToInt(arreyInput[0]);
            this.secondDigit = (short) romanToInt(arreyInput[2]);
        }

        try {
            if (isLesThenTen(firstDigit) && isLesThenTen(secondDigit)) {
                this.checkedFirstDigit = firstDigit;
                this.checkedSecondDigit = secondDigit;
            }
        } catch (ThrowsException e) {
            System.err.println("throws Exception. One of digits more than 10!");
            System.exit(0);
        }
    }

    public short getCheckedFirstDigit() {
        return checkedFirstDigit;
    }

    public short getCheckedSecondDigit() {
        return checkedSecondDigit;
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = map.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = map.get(arr[i]);

            if (arabian < map.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }

    private boolean isLesThenTen(short input) throws ThrowsException {
        if (input <= 10) {
            return true;
        } else {
            throw new ThrowsException("Digit more than 10");
        }
    }
}
