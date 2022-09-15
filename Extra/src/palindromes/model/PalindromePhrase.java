package palindromes.model;

public class PalindromePhrase extends Palindrome {

    public static String[] palindromes = {"Never odd or even", "A Toyota's a Toyota", "Was it a car or a cat I saw?"};

    public PalindromePhrase(String phrase) {
        super(phrase);
    }

    public static boolean isPalindrome(String sentence) {
        sentence = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        sentence = sentence.replaceAll("\\s+", "");
        return Palindrome.isPalindrome(sentence);
    }

    @Override
    public boolean isPalindrome() {
        String sentence = this.getWord();
        sentence = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        sentence = sentence.replaceAll("\\s+", "");
        this.setWord(sentence);
        return Palindrome.isPalindrome(this.getWord());
    }

    @Override
    public String toString() {
        System.out.println("called");
        String str = "\"" + this.getWord() + "\"";
        str += this.isPalindrome() ? " is a palindrome" : " isn't a palindrome";
        return str;
    }

}
