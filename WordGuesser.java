import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGuesser {
    public static String[] words = {
        "chleba", "rohlik", "maslo", "syr", "sunka", "salam", "vejce", "mleko", "jogurt", "tvaroh",
        "maso", "ryba", "slanina", "brambory", "ryze", "testoviny", "chleb", "knedlik", "bageta", "kolac",
        "mrkev", "paprika", "rajce", "okurka", "cibule", "cesnek", "zeli", "spenat", "hrach", "cocka",
        "hruska", "jablko", "broskev", "merunka", "tresen", "svestka", "banan", "pomeranc", "citron", "grep",
        "meloun", "jahoda", "malina", "ostruzina", "boruvka", "rybiz", "med", "orech", "mandle", "pistacie"
    };

    public static ArrayList<Character> guessedLetters = new ArrayList<>();
    public static char[] word = {};
    public static char[] lettersGuessedRight = {};

    public static String getWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String newWord = words[randomIndex];
        return newWord;
    }

    public static boolean checkGuessedLetters(char letter) {
        return guessedLetters.contains(letter);
    }

    public static boolean checkLetterInWord(char letter) {
        boolean x = false;
        for (int i = 0; i < (lettersGuessedRight.length - 1); i++) {
            if (word[i] == letter) {
                lettersGuessedRight[i] = letter;
                x = true;
            }
        }
        for (int i = 0; i < (lettersGuessedRight.length - 1); i++) {
            System.out.print(lettersGuessedRight[i] + " ");
        }
        return x;
    }

    public static boolean checkIfSame() {
        for (int i = 0; i < (lettersGuessedRight.length - 1); i++) {
            if (word[i] != lettersGuessedRight[i]) {
                return false;
            }
        }
        return true;
    }

    public static void game() {
        System.out.println("Vítej ve hře word guesser!");
        System.out.println("-----------------------------------");
        while (true) {
            int health = 6;
            String wordString = getWord();
            word = wordString.toCharArray();
            lettersGuessedRight = new char[word.length];
            for (int x = 0; x < (word.length - 1); x++) {
                lettersGuessedRight[x] = '_';
            }
            checkLetterInWord('0');
            while (true) {
                if (checkIfSame()) {
                    System.out.println("Uhádl jsi slovo!");
                    break;
                }
                System.out.print("\nZadej písmeno: ");
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    char character = input.charAt(0);
            
                    if (checkGuessedLetters(character)) {
                        System.out.print("Písmeno jsi už hádal, zadej jiné písmeno: ");
                    }
                    else {
                        guessedLetters.add(character);
                        checkLetterInWord(character);
                        break;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        game();
    }
}
