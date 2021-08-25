package com.ljiangf.String;

public class StringBuilderUsage {
    public static void main(String[] args){
        StringBuilder strB = new StringBuilder();
        strB.append(1);
        strB.append('c');
        strB.append(true);
        System.out.println(strB.toString());

        strB.setCharAt(2, 'd');
        System.out.println("StringBuilder.setCharAt:" + strB);

        System.out.println("StringBuilder.insertString:"+ strB.insert(2, "LS"));

        System.out.println("StringBuilder.delete:"+ strB.delete(2, 4));
    }
}
