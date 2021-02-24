import java.util.*;

public class Dictionary {

    private final Set<String> words;

    public Dictionary(Collection<String> words) {
        this.words = new HashSet<>();
        this.words.addAll(words);
    }

    /**
     * Tries to split the 'text' onto the 'words'
     *
     * @param text to split
     * @return a sequence of words which compose the text or null if not split.
     */
    public List<String> splitText(String text) {
        if (text == null || text.length() == 0)
            return null;

        Deque<String> sequence = new ArrayDeque<>();

        if (splitRecursively(text, 0, sequence))
            return new ArrayList<>(sequence);

        return null;
    }

//    public List<String> splitText(String text) {
//        Deque<String> sequence = new ArrayDeque<>();
//
//        try {
//            splitRecursively(text, 0, sequence);
//        } catch (TextNotSplitException e) {
//            return null;
//        }
//
//        return new ArrayList<>(sequence);
//    }

    private boolean splitRecursively(String text, int startIndex, Deque<String> sequence) {
        if (startIndex == text.length())
            return true;

        for (String word : words) {
            if (text.startsWith(word, startIndex)) {
                sequence.addLast(word);

                boolean isSplit = splitRecursively(text, startIndex + word.length(), sequence);
                if (isSplit)
                    return true;

                sequence.removeLast();
            }
        }

        return false;
    }

//    private void splitRecursively(String text, int startIndex, Deque<String> sequence) throws TextNotSplitException {
//        if (startIndex == text.length())
//            return;
//
//        for (String word : words) {
//            if (text.startsWith(word, startIndex)) {
//                sequence.addLast(word);
//
//                try {
//                    splitRecursively(text, startIndex + word.length(), sequence);
//                    return;
//                } catch (TextNotSplitException e) {
//                    sequence.removeLast();
//                }
//            }
//        }
//
//        throw new TextNotSplitException();
//    }
}

class TextNotSplitException extends Exception {

}
