package com.telran.collection;

public abstract class List {

    public abstract int size();

    public abstract void append(Object o);

    public abstract Object get(int index);

    public abstract void set(Object o, int index);

    public abstract Object removeById(int index);

    public abstract boolean remove(Object o);

}
