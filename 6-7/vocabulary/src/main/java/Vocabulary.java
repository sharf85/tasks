import java.util.HashSet;
import java.util.Set;

public class Vocabulary {

    public Set<String> revealAllCompositeWords(Set<String> vocabulary) {
        Set<String> res = new HashSet<>();
        Set<String> tempVocabulary = new HashSet<>(vocabulary);
        for (String word : vocabulary) {
            tempVocabulary.remove(word);
            TextSplitter textSplitter = new TextSplitter(tempVocabulary);

            try {
                textSplitter.splitText(word);
                res.add(word);

                tempVocabulary.add(word);
            } catch (NotSplitException e) {
                tempVocabulary.add(word);
            }

        }
        return res;
    }
}
