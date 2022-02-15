package com.company;
import java.util.Scanner;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) throws Throwable{
	// write your code here
        Scanner num = new Scanner(System.in);
        String str, str1, str2;
        char oper;
        int i, s1, s2,ii;
        System.out.println("Введите математическое выражение в формате x+y");
        str = num.nextLine();
        str = str.replace(" " , "");
        i=0;

        i=GetPosOperator(str);

        str1 = str.substring(0,i);
        str2 = str.substring(i+1,str.length());
        oper = str.charAt(i);
        int num1[] = GetNumber(str1);
        s1 = num1[0];
        /*if (num1[1]==1){
            System.out.println("Число римское");
        }
        else {
            System.out.println("Число  арабское");
        }*/

        int num2[] = GetNumber(str2);
        s2 = num2[0];
        /*if (num2[1]==1){
            System.out.println("Число римское");
        }
        else {
            System.out.println("Число  арабское");
        }
        */

        if (num1[1]!=num2[1])
        {
            throw new Error("Ошибка ввода! Разные числа!");
        }

        //s2 = GetNumber(str2);
        //s1=Integer.parseInt(str1);
        //s2=Integer.parseInt(str2);
        //System.out.println(s1);
        //System.out.println(s2);
        //i = GetNumber(str1);

        switch (oper){
            case '+':
                i = s1+s2;
                break;
            case '-':
                i = s1-s2;
                if (num1[1]==1 && s1<s2)
                {
                    throw new Error("Ошибка ввода римских цифр!");
                }
                break;
            case '*':
                i = s1*s2;
                break;
            case '/':
                i = s1/s2;
                break;
        }
        if (num1[1]==1){
            System.out.println("Результат = "+GetRoman(i));
        }
        else
            System.out.println("Результат = "+ i);
    }
    static int GetPosOperator(String valstr){
        String[] oper = {"+", "-", "*","/"};
        int i, ii, kk;
        kk=0;
        for(i=0;i<4;i++) {
            ii = valstr.indexOf(oper[i]);
            if (ii > 0) {
                kk= ii;
            }
        }
        return kk;
    }

    static String GetRoman(int valstr){
        String [] arab = new String[]{"0","1","2","3","4","5","6","7","8","9","10"};
        String [] rome = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        return rome[valstr];
    }
    static int[] GetNumber(String valstr){
        ArrayList<String> roman = new ArrayList<>() ;//("", "I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        ArrayList<Integer> arabic = new ArrayList<>();//(0,1,2,3,4,5,6,7,8,9,10);
        int b= 0;
        int i1 = 0;
        roman.add("");
        roman.add("I");
        roman.add("II");
        roman.add("III");
        roman.add("IV");
        roman.add("V");
        roman.add("VI");
        roman.add("VII");
        roman.add("VIII");
        roman.add("IX");
        roman.add("X");

        for (int i=0;i<=10;i++){
            arabic.add(i);
        }

        //Integer[] arabic = {0,1,2,3,4,5,6,7,8,9,10};
        //roman = {"", "I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        if (roman.indexOf(valstr)>0) {
            i1 = roman.indexOf(valstr);
            b = 1;
        }
        else
            if (arabic.indexOf(Integer.valueOf(valstr))>0) {
                i1 = arabic.indexOf(Integer.valueOf(valstr));
                b=0;
            }
        return new int[] {i1, b};
    }
    public int opearators(char operand)
    {
        switch (operand) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }
}
