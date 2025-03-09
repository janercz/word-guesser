import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGuesser {
    static String[] words = {
        "chleba", "rohlik", "maslo", "syr", "sunka", "salam", "vejce", "mleko", "jogurt", "tvaroh",
        "maso", "ryba", "slanina", "brambory", "ryze", "testoviny", "chleb", "knedlik", "bageta", "kolac",
        "mrkev", "paprika", "rajce", "okurka", "cibule", "cesnek", "zeli", "spenat", "hrach", "cocka",
        "hruska", "jablko", "broskev", "merunka", "tresen", "svestka", "banan", "pomeranc", "citron", "grep",
        "meloun", "jahoda", "malina", "ostruzina", "boruvka", "rybiz", "med", "orech", "mandle", "pistacie"
    };

    static ArrayList<Character> guessedLetters = new ArrayList<>();
    static char[] word = {};
    static char[] lettersGuessedRight = {};
    static Scanner scanner = new Scanner(System.in);

    static String getWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    static boolean checkGuessedLetters(char letter) {
        return guessedLetters.contains(letter);
    }

    static boolean checkLetterInWord(char letter) {
        boolean x = false;
        for (int i = 0; i < lettersGuessedRight.length; i++) {
            if (word[i] == letter) {
                lettersGuessedRight[i] = letter;
                x = true;
            }
        }
        for (char c : lettersGuessedRight) {
            System.out.print(c + " ");
        }
        return x;
    }

    static boolean checkIfSame() {
        for (int i = 0; i < lettersGuessedRight.length; i++) {
            if (word[i] != lettersGuessedRight[i]) {
                return false;
            }
        }
        return true;
    }

    static void game() {
        int health = 10;
        guessedLetters.clear();
        String wordString = getWord();
        word = wordString.toCharArray();
        lettersGuessedRight = new char[word.length];
        for (int x = 0; x < word.length; x++) {
            lettersGuessedRight[x] = '_';
        }
        System.out.println("\nPočet životů: " + health);
        checkLetterInWord('0');
        while (true) {
            if (health == 0) {
                System.out.print("\nProhrál jsi!\nSlovo bylo: " + new String(word));
                break;
            }
            if (checkIfSame()) {
                System.out.print("\nVyhrál jsi! Uhádl jsi slovo: " + new String(word));
                break;
            }
            System.out.print("\nZadej písmeno: ");
            while (true) {
                try {
                    String input = scanner.nextLine();
                    char character = input.charAt(0);
                    System.out.println("\n");
                    if (checkGuessedLetters(character)) {
                        System.out.print("Písmeno jsi už hádal, zadej jiné písmeno: ");
                    } else {
                        guessedLetters.add(character);
                        if (checkLetterInWord(character)) {
                            System.out.print("\nPočet životů: " + health);
                            break;
                        } else {
                            health--;
                            System.out.print("\nPočet životů: " + health);
                            break;
                        }
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.print("Chybný vstup. Zkus to znovu: ");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Vítej ve hře word guesser!");
        System.out.println("-----------------------------------");
        while (true) {
            game();
            System.out.print("\n\nChceš hrát znovu (a/n): ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Chybný vstup. Ukončuji hru.");
                break;
            }
            char character = input.charAt(0);
            if (character == 'a') {
                continue;
            } else break;
        }
        scanner.close();
    }
}
