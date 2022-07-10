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
            word.strip();
            if (word.length()>(ACs.size()+1)){              //create more anagramCounters if one doesn't exits
                                                            //for this word length
                for (int i = ACs.size()+2; i<=word.length(); i++){
                    ACs.add(new AnagramCounter(i, 0));
                }
            }
            String wrd = sorted(word);
            ACs.get(word.length()-2).addWord(wrd);     //stores all dictionary words of particular length in the
                                                        //relevant anagramcounter
        }
        for (AnagramCounter ac : ACs){
            ac.anagaramCount();         //counts the number of anagrams for that particular word length
        }
        return ACs;
    }

    //sorts characters in alphabetical order
    private String sorted(String word){
        char[] chrs = word.toCharArray();
        Arrays.sort(chrs);
        return new String(chrs);
    }
}

