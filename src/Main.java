import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
        public static void main(String[] args) {
        printNumberWordsInText("мама мыла раму. раму мыла мама");
        System.out.println(printStatistics("мама мыла раму. раму мыла мама"));
    }




    public static void printNumberWordsInText(String text) {
        System.out.println("В тексте " + text.split(" ").length + " слов/а");

    }

    public static HashMap<String, Integer> printStatistics(String text) {
        HashMap<String, Integer> counterWord = new HashMap<>();

        for (String s : text.split(" ")
        ) {
            if (!counterWord.containsKey(s)) {
                counterWord.put(s, 1);
            } else {
                int count = counterWord.get(s);
                count++;
                counterWord.put(s, count);
            }

        }
        return counterWord;
    }




}