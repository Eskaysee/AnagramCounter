import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramService {

    public List<AnagramCounter> compute(String dictionaryLocation) throws IOException {
        List<String> words = FileUtils.readLines(new File(dictionaryLocation));

        List<AnagramCounter> ACs = new ArrayList<>(Arrays.asList(new AnagramCounter(2, 0)));

        for (String word : words) {
            // TODO: process word
            word.strip(); word.toString();
            //System.out.println("WORD IS: " + word.toString() + " COUNT IS: " + word.length());
            if (word.length()>(ACs.size()+1)){
                //System.out.println("Word Length: " + word.length() + " ACs Size: " + ACs.size());
                for (int i = ACs.size(); i<=(word.length()-2); i++){
                    ACs.add(new AnagramCounter(word.length(), 0));
                }
            }
            String wrd = sorted(word);
            ACs.get(word.length()-2).addWord(wrd);     //stores all dictionary words of particular length in the
                                                        //relevant anagramcounter
            //System.out.println("TODO process word: " + word + " and " + str);
        }
        for (AnagramCounter ac : ACs){
            ac.anagaramCount();
            /*ArrayList<String> wrds = ac.getWords();     //for each anagramcounter we get the list of dictionary
                                                        //words that correspond with the anagram counter length
            while (!wrds.isEmpty()) {               //Loops for each unique anagram or word thats not an anagaram
                                                    //in the list
                String wrd = wrds.get(0); wrds.remove(0);   //pops the first element of the list
                wrd = sorted(wrd);                          //sorts characters of a word in alphabetical order
                int count = 1;
                for (int i = 0; i < wrds.size(); i++) {
                    if (sorted(wrds.get(i)).equals(wrd)){
                        count++;
                        wrds.remove(i);
                    }
                }
                if (count>1){
                    int anaCount = ac.getCount() + count; 
                    ac.setCount(anaCount);
                }
                //System.out.println("Words Array Is Size: " + wrds.size());
            }*/
        }

        // TODO: This is just a placeholder - you should change this
        return ACs;
    }

    //sorts characters in alphabetical order
    private String sorted(String word){
        char[] chrs = word.toCharArray();
        Arrays.sort(chrs);
        return new String(chrs);
    }
}

