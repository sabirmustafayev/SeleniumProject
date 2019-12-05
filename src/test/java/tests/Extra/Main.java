package tests.Extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import utils.Driver;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


            String word1 = "listen";
            String word2 = "Silent";
        System.out.println( isAnagram(word1, word2));
            //System.out.println();
        }

    public static boolean isAnagram(String word1, String word2) {
        char[]char1 = word1.toLowerCase().toCharArray();
        char[]char2 = word2.toLowerCase().toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        //System.out.println(Arrays.toString(char2));
        //System.out.println(Arrays.toString(char1));
        String str1 = "";
        String str2 = "";
        for(char each: char1)
            str1+= each;
        for(char each: char2)
            str2+=each;
        str2.equalsIgnoreCase(str1);
        // System.out.println(str2+" "+str1);
        //System.out.println(str1.equalsIgnoreCase(str2) ? true : false);
        return (str1.equalsIgnoreCase(str2) ? true: false);
    }
}
