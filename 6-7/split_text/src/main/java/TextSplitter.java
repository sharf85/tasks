import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TextSplitter {
    private Set<String> vocabulary;

    public TextSplitter(Set<String> vocabulary) {
        this.vocabulary = vocabulary;
    }

    public List<String> splitText(String text) throws NotSplitException {
        LinkedList<String> res = new LinkedList<>();

        splitTextRecursively(text, res);
        return res;
    }

    private void splitTextRecursively(String text, LinkedList<String> result) throws NotSplitException {
        if (text.equals(""))
            return;

        for (String word : vocabulary) {
            int wordLength = word.length();
            if (text.startsWith(word)) {
                result.add(word);
                try {
                    splitTextRecursively(text.substring(wordLength), result);
                    return;
                } catch (NotSplitException e) {
                    result.removeLast();
                }
            }
        }

        throw new NotSplitException();
    }
}

class NotSplitException extends Exception {
}
