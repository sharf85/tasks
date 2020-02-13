package com.telran.collection;

public abstract class OurAbstractSet<E> implements OurSet<E> {
    @Override
    public boolean addAll(OurSet<E> other) {

        boolean res = false;
        for (E elt : other) {
            res |= this.add(elt);
        }

        return res;
    }

    @Override
    public boolean removeAll(OurSet<E> other) {
        boolean res = false;

        for (E elt : other) {
            res |= this.remove(elt);
        }
        return res;
    }

    @Override
    public boolean retainAll(OurSet<E> other) {
//        Iterator<E> iterator = iterator();
//
//        while (iterator.hasNext()) {
//            E elt = iterator.next();
//
//            if (!other.contains(elt)) {
//                iterator.remove();
//                res = true;
//            }
//        }

        OurSet<E> thisMinusOther = new OurHashSet<>();

        for (E elt : this) {
            if (!other.contains(elt))
                thisMinusOther.add(elt);
        }

        return this.removeAll(thisMinusOther);
    }
}
