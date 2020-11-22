package com.ljiangf.DivideAndConquer;

public class BigNumberCalculation {
    public String multiply(String num1, String num2) {
        //此版本无0开头，无+-号
        if(num1.equals("0") || num2.equals("0"))return "0";
        String ans = "";
        short[] a = new short[num1.length()];
        short[] b = new short[num2.length()];
        for (int i=0;i<num1.length();++i) {
            a[i] = Short.parseShort(num1.substring(i,i+1));
        }
        for (int i=0;i<num2.length();++i) {
            b[i] = Short.parseShort(num2.substring(i,i+1));
        }
        short[] res = new short[num1.length()+num2.length()-1];

        for(int i=num1.length()-1;i>=0;--i){
            for(int j=num2.length()-1;j>=0;--j){
                res[i+j] += a[i]*b[j];
            }
        }
        //System.out.println(Arrays.toString(res));

        short addition = 0;
        for(int i=res.length-1;i>=0;--i){
            int temp = addition + res[i];
            ans = ans+String.valueOf(temp%10);
            addition = (short) (temp/10);
        }
        if(addition!=0){
            ans = ans+String.valueOf(addition);
        }
        ans = new StringBuilder(ans).reverse().toString();
        return ans;
    }
}
