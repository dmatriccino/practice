/* package whatever; // don't place package name! */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ReverseWord
{

    public static void main (String[] args) throws java.lang.Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List inputLines = new ArrayList<String>();
        String input;

        while((input = br.readLine()) != null) {
            inputLines.add(input);
        }

        boolean validated = validateInput(inputLines);

        if(validated) {
            for(int i = 1; i < inputLines.size(); ++i) {
                printReversedWords(inputLines.get(i).toString());
            }
        }

        return;

    }

    public static void printReversedWords(String sentence) {
        String[] words = sentence.split(" +");
        String newSentence = "";
	    String newSentence2 = "";

        StringBuffer wordBuffer;
        for(int i = 0; i < words.length; ++i) {
            newSentence += reverseWord(words[i]) + " ";
	        newSentence2 += reverseWordPrimitive(words[i]) + " ";
        }
        newSentence.trim();
        newSentence2.trim();
        System.out.println(newSentence);
	System.out.println(newSentence2);
    }

    public static String reverseWord(String word) {

        StringBuilder newWord = new StringBuilder(word);
        return newWord.reverse().toString();
    }

    public static String reverseWordPrimitive(String word) {
        char[] letters = word.toCharArray();
        char[] newWord = new char[letters.length];
        int j = 0;
        for(int i = letters.length - 1; i >= 0; --i) {
            newWord[j++] = letters[i];
        }
        return String.valueOf(newWord);
    }

    public static boolean validateInput(List<String> inputArray) {
        Integer inputSize = inputArray.size();
        //Size of array should be at least 2
        if(inputSize < 2) {
            return false;
        }

        try {
            //First line should be a number greater than 0 and <= 100
            Integer expectedSentenceCount = Integer.valueOf(inputArray.get(0));

            //Determine if number matches number of sentences
            Integer numberOfSentences = inputSize - 1;
            if(expectedSentenceCount != numberOfSentences) {
                return false;
            }

            for(int i = 1; i < inputArray.size(); ++i) {
                //Validate words
                String[] words = inputArray.get(i).split(" +");
                if(words.length > 100) {
                    return false;
                }

                for(int j = 0; j < words.length; ++j) {
                    if(words[j].length() > 20) {
                        return false;
                    }
                }
            }

        } catch(Exception ex) {
            return false;
        }
        return true;

    }

}
