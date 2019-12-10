package com.telran;

public class Censor {

    private String[] vocab;

    public Censor(String[] vocab) {
        this.vocab = new String[vocab.length];
//        System.arraycopy(vocab, 0, this.vocab, 0, vocab.length);
//        this.vocab = Arrays.copyOf(vocab, vocab.length);
        for (int i = 0; i < vocab.length; i++) {
            this.vocab[i] = vocab[i].toLowerCase();
        }
    }

    public boolean isLegal(String text) {
        text = text.toLowerCase();

        for (int i = 0; i < vocab.length; i++) {
            if (text.contains(vocab[i]))
                return false;
        }

        return true;
    }
}
