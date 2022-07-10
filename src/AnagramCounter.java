import java.util.HashMap;
import java.util.Map;

/**
 * Computes the number of anagrams (of a particular word
 * length) exist in the specified Dictionary
 * @author Sihle Calana 
 */
public class AnagramCounter {

    private int wordLength; //length of the words in this anagramCounter
    private int count;      //anagram count
    private Map<String, Integer> words; //sorted words mapped to their
                                        //in the dictionary

    public AnagramCounter(int wordLength, int count) {
        this.wordLength = wordLength;
        this.count = count;
        this.words = new HashMap<>();
    }

    /**
     * gives back wordlength of this anagramCounter
     * @return Integer: wordLength
     */
    public int getWordLength() {
        return wordLength;
    }

    /***
     * Updates map of sorted words and their respective counter
     * @param word  sorted dictionary word of AnagramCounter wordLenght
     */
    public void addWord(String word){
        if (words.containsKey(word)){       //if the word is already in the map
            int counter = words.get(word);      //number of appearances of
                                                //the sorted word
            words.replace(word, counter, ++counter);
        }
        else words.put(word, 1);
    }

    public void anagaramCount(){
        for (String str : words.keySet()){
            if (words.get(str)>1) setCount(++count);
        }
    }

    /***
     * Returns the integer count of the number of anagrams
     * in this anagramCounter
     * @return count
     */
    public int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = count;
    }
}
