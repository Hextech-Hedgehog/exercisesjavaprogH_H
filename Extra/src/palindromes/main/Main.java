package palindromes.main;

import palindromes.model.Palindrome;
import palindromes.model.PalindromePhrase;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("tacocat"));
        System.out.println(Palindrome.isPalindrome("kayak"));
        System.out.println(Palindrome.isPalindrome("radar"));
        System.out.println(Palindrome.isPalindrome("abba"));
        System.out.println(Palindrome.isPalindrome("absinthe"));
        System.out.println(PalindromePhrase.isPalindrome(PalindromePhrase.palindromes[0]));
        String[] palindromes = {"tacocat", "kayak", "radar", "abba", "absinthe"};
        System.out.println(Palindrome.countNumberOfPalindromes(palindromes));
        Palindrome[] palindromes2 = {new Palindrome("tacocat"), new Palindrome("kayak"), new PalindromePhrase("Was it a car or a cat I saw?"), new PalindromePhrase("this is not a palindrome")};
        Arrays.stream(palindromes2).forEach(System.out::println);
    }

}
