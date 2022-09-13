package palindromes.model;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Palindrome {

    public static boolean isPalindrome(String word) {
        int length = word.length();
        if (length < 2)
            return false;

        return IntStream.range(0, length / 2).noneMatch(i -> word.charAt(i) != word.charAt(length - 1 - i));
    }

    public static int countNumberOfPalindromes(String[] palindromes) {
        int counter = 0;
        for (String palindrome : palindromes) {
            if (isPalindrome(palindrome))
                counter++;
        }
        return counter;
    }

}
