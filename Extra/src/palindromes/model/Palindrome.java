package palindromes.model;

import palindromes.exceptions.NotAPalindromeException;

import java.util.stream.IntStream;

public class Palindrome {

    private String word;

    public Palindrome(String word) {
        this.word = word;
    }

    public static boolean isPalindrome(String word) {
        int length = word.length();
        boolean isPalindrome = length > 2 && IntStream.range(0, length / 2).noneMatch(i -> word.charAt(i) != word.charAt(length - 1 - i));
        if (!isPalindrome)
            throw new NotAPalindromeException(word + "isn't a palindrome");
        return isPalindrome;
    }

    public boolean isPalindrome() {
        return Palindrome.isPalindrome(this.word);
    }

    public static int countNumberOfPalindromes(String[] palindromes) {
        int counter = 0;
        for (String palindrome : palindromes) {
            if (isPalindrome(palindrome))
                counter++;
        }
        return counter;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        String str = "\"" + this.getWord() + "\"";
        str += this.isPalindrome(this.getWord()) ? " is a palindrome" : " isn't a palindrome";
        return str;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
