package com.btcag.bootcamp;

public class PQueueListGeneric<T> {
    @SuppressWarnings("unchecked")
    private T[] data = (T[]) new Object[10];
    private int elemCnt = 0;
    private int startIndex = 0;


    private T getValueAtIndex(int i){
        if (i >= elemCnt) {
            return null;
        }
        int ind = (startIndex + i) % data.length;
        return data[ind];
    }


    private int increase(int curValue) {
        return (curValue + 1) % data.length;
    }


    private int decrease(int curValue) {
        return (curValue - 1 + data.length) % data.length;
    }


    private void enhanceArray() {
        int i = 0;
        @SuppressWarnings("unchecked")
        T[] newdata = (T[]) new Object[data.length * 2];
        while (i < elemCnt) {
            newdata[i] = getValueAtIndex(i);
            i++;
        }
        startIndex = 0;
        this.data = newdata;
    }


    public T popFront() {
        if (elemCnt <= 0) {
            return null;
        }
        T val = data[startIndex];
        startIndex = increase(startIndex);
        elemCnt--;
        return val;
    }


    public T popLast() {
        if (elemCnt <= 0) {
            return null;
        }
        int lastIndex = (startIndex + elemCnt - 1) % data.length;
        T val = data[lastIndex];
        elemCnt--;
        return val;
    }


    public void pushLast(T i) {
        if (elemCnt == data.length) {
            enhanceArray();
        }
        int maxIndex = (startIndex + elemCnt) % data.length;
        data[maxIndex] = i;
        elemCnt++;
    }


    public void pushFront(T i) {
        if (elemCnt == data.length) {
            enhanceArray();
        }
        startIndex = decrease(startIndex);
        data[startIndex] = i;
        elemCnt++;
    }


    public T get(int index) {
        return getValueAtIndex(index); }


    public int getElemCnt() {
        return elemCnt;
    }
}
