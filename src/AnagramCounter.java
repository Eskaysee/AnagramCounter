import java.util.HashMap;
import java.util.Map;

public class AnagramCounter {

    private int wordLength;
    private int count;
    private Map<String, Integer> words;

    public AnagramCounter(int wordLength, int count) {
        this.wordLength = wordLength;
        this.count = count;
        this.words = new HashMap<>();
    }

    public int getWordLength() {
        return wordLength;
    }

    public void addWord(String word){
        //words.add(word);
        if (words.containsKey(word)){
            int counter = words.get(word);
            words.replace(word, counter, ++counter);
        }
        else words.put(word, 1);
    }

    /*public ArrayList<String> getWords(){
        return words;
    }*/

    public void anagaramCount(){
        for (String str : words.keySet()){
            if (words.get(str)>1) setCount(++count);
        }
    }

    /*public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }*/

    public int getCount() {
        return count;
    }

    private void setCount(int count) {
        this.count = count;
    }
}
