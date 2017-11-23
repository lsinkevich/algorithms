package Graphs;

import java.util.Random;

public class IsBinarySearchTree {

    public static class Unit<T extends Comparable<T>> {
        private Unit<T> l;
        private Unit<T> r;
        private T data;

        public Unit(final T v) {
            this.data = v;
            this.l = null;
            this.r = null;
        }

        public void setLeft(final Unit<T> left) {
            this.l = left;
        }

        public Unit<T> getLeft() {
            return l;
        }

        public void setRight(final Unit<T> r) {
            this.r = r;
        }

        public Unit<T> getRight() {
            return r;
        }

        public T getValue() {
            return data;
        }
    }

    public static Unit<Integer> insertUnit(final Unit<Integer> source, final int data) {
        if (source == null) {
            Unit<Integer> source_node = new Unit<Integer>(data);
            return source_node;
        }
        if (data > source.getValue())
            source.setRight(insertUnit(source.getRight(), data));
        else if (data < source.getValue())
            source.setLeft(insertUnit(source.getLeft(), data));
        return source;
    }

    private static class index {
        int data;

        public index(int data) {
            this.data = data;
        }

        public index update(int data) {
            this.data = data;
            return this;
        }
    }

    public static boolean isBinarySearchTree(Unit<Integer> data, int min, int max) {
        if (data == null)
            return true;
        if (data.getValue() < min || data.getValue() > max)
            return false;
        return isBinarySearchTree(data.getLeft(), min, data.getValue()) && isBinarySearchTree(data.getRight(), data.getValue(), max);
    }

    public static void main(String[] args) {
        Random random = new Random();
        Unit<Integer> data = null;
        for (int i = 0; i < 10; i++)
            data = insertUnit(data, Math.abs(random.nextInt()) % 50);
        System.out.println(isBinarySearchTree(data, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
