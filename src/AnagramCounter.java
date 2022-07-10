import java.util.ArrayList;

public class AnagramCounter {

    private int wordLength;
    private int count;
    private ArrayList<String> words;

    public AnagramCounter(int wordLength, int count) {
        this.wordLength = wordLength;
        this.count = count;
        this.words = new ArrayList<>();
    }

    public int getWordLength() {
        return wordLength;
    }

    public void addWord(String word){
        words.add(word);
    }

    public ArrayList<String> getWords(){
        return words;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
