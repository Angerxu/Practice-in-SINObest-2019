package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6};
        int[] temp = new int[10];
        System.arraycopy(array,2,temp,0,1);
        System.out.println(temp[0]);

        char[] charArray={'x','a','n','g','e','r','y'};
        char[] name = new char[10];
        System.arraycopy(charArray,1,name,0,5);
        System.out.println(name);
        if (-1<temp[0])
            System.out.println(name);
    }
}
