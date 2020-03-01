/**
 * @author jiofeng
 * @date 2020/3/1
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 8, 9};
        for (int digit : new PlusOneSolution().plusOne(digits)) {
            System.out.println(digit);
        }
    }
}

class PlusOneSolution {
    public int[] plusOne(int[] digits) {
        boolean carryFlag = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carryFlag) {
                digits[i] = ++digits[i];
                carryFlag = false;
            }
            if (digits[i] >= 10) {
                digits[i] %= 10;
                carryFlag = true;
            }
            if (!carryFlag) {
                break;
            }
        }
        if (carryFlag) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
}
