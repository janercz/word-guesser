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

    public static char[] guessedLetters = {};
    public static char[] word = {};
    public static char[] lettersGuessedRight = {};

    public static String getWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String newWord = words[randomIndex];
        return newWord;
    }

    public static boolean checkGuessedLetters(char letter) {
        for (int i = 0; i < (guessedLetters.length - 1); i++) {
            if (guessedLetters[i] == letter) {
                return true;
            }
        }
        return false;
    }
    public static void checkLetters(char letter) {
        for (int i = 0; i < (guessedLetters.length - 1); i++) {
            if (word[i] == letter) {
                
            }
        }
    }

    public static void game() {
        System.out.println("Vítej ve hře word guesser!");
        System.out.println("-----------------------------------");
        while (true) {    
            String wordString = getWord();
            word = wordString.toCharArray();
            for (int x = 0; x < (word.length - 1); x++) {
                lettersGuessedRight[x] = '_';
            }
    
            while (true) {
                System.out.print("Zadej písmeno: ");
                Scanner scanner = new Scanner(System.in);
                String scan = scanner.nextLine();
                scanner.close();
                char character = scan.charAt(0);
        
                if (checkGuessedLetters(character)) {
                    System.out.print("Písmeno jsi už hádal, zadej jiné písmeno: ");
                }
                else {
    
                    break;
                }
            }
        }


        }
    public static void main(String[] args) {

    }
}
