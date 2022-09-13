package palindromes.main;

import palindromes.model.Palindrome;

public class Main {

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("tacocat"));
        System.out.println(Palindrome.isPalindrome("kayak"));
        System.out.println(Palindrome.isPalindrome("radar"));
        System.out.println(Palindrome.isPalindrome("abba"));
        System.out.println(Palindrome.isPalindrome("absinthe"));
        String[] palindromes = {"tacocat", "kayak", "radar", "abba", "absinthe"};
        System.out.println(Palindrome.countNumberOfPalindromes(palindromes));
    }

}
