package com.telran;

public enum Calculator {
    SUM {
        @Override
        public int action(int x, int y) {
            return x + y;
        }
    },

    MUL {
        @Override
        public int action(int x, int y) {
            return x * y;
        }
    },

    SUB {
        @Override
        public int action(int x, int y) {
            return x - y;
        }
    },
    DIV {
        @Override
        public int action(int x, int y) {
            return x / y;
        }
    };

    public abstract int action(int x, int y);
}
