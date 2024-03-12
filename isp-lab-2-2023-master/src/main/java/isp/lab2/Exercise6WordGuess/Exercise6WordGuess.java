package isp.lab2.Exercise6WordGuess;

import java.util.Scanner;


public class Exercise6WordGuess {

    /**
     * This method will return the number of occurrences of a character in a word
     *
     * @param c
     * @param word
     * @return
     */


    public static int[] getOccurrencePositions(char c, char[] word) {
        int count = 0;
        for (char letter : word) {
            if (letter == c) {
                count++;
            }
        }
        int[] positions = new int[count];
        int index = 0;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == c) {
                positions[index++] = i;
            }
        }
        return positions;
    }


    public static void main(String[] args) {
        char[][] dictionary = {
                {'n', 'a', 'n', 'a', 'n'},
                {'b', 'l', 'a', 'b', 'l', 'a'},
        };

        int randomIndex = (int) (Math.random() * dictionary.length);
        char[] word = dictionary[randomIndex];
        char[] guessedWord = new char[word.length];
        boolean solved = false;
        Scanner scanner = new Scanner(System.in);

        int tries = 0;
        while (tries < 10 && !solved) {
            tries++;
            System.out.println("Guessed word: " + new String(guessedWord));
            System.out.println("Enter a letter: ");
            char letter = scanner.nextLine().charAt(0);

            int[] occurrences = getOccurrencePositions(letter, word);

            if (occurrences.length == 0) {
                System.out.println("Letter '" + letter + "' is not in the word.");
            } else {
                System.out.print("Letter '" + letter + "' is in the word at position(s): ");
                for (int position : occurrences) {
                    guessedWord[position] = letter;
                }
                System.out.println(new String(guessedWord));
            }

            solved = new String(guessedWord).equals(new String(word));
        }

        System.out.println("The word" + new String(word));
        if (solved) {
            System.out.println("You guessed the word in " + tries + " tries.");
        } else {
            System.out.println("You couldn't guess the word");
        }
    }
}


