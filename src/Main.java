import java.util.*;

public class Main {
    public static void main(String[] args) {
        printNumberWordsInText("мама мыла раму.раму мыла мама?");
        printStatistics2(" Данный итератор представляет собой стандартный итератор с дополнительными функциями. " +
                "Он может «идти» по коллекции не только вперед, но и назад." +
                "                Добавлены методы previous и hasPrevious, которые работают так же, как next и hasNext, но в обратную сторону. " +
                "                        Также были добавлены методы nextIndex и previousIndex, позволяющие получить индекс элемента, которые возвращены next или previous.");
        printStatistics2(" мама мыла раму.раму мыла мама? мама мыла раму");
    }

    public static void printNumberWordsInText(String text) {

        String text2 = text.replace(".", " ");
        text2 = text2.replace(",", "");
        text2 = text2.replace("!", " ");
        text2 = text2.replace("?", " ");
        text2 = text2.replace("'", "");
        System.out.println("В тексте " + text2.split(" ").length + " слов/а");
    }

    public static void printStatistics2(String text) {
        String textWithoutExcess = text.replace(".", " ");
        textWithoutExcess = textWithoutExcess.replace(",", "");
        textWithoutExcess = textWithoutExcess.replace("!", " ");
        textWithoutExcess = textWithoutExcess.replace("?", " ");
        textWithoutExcess = textWithoutExcess.replace("'", "");
        String textCopy = textWithoutExcess;
        HashMap<Integer, String> wordСounter = new HashMap<>();
        for (String wordThatIsBeingСompared : textWithoutExcess.split(" ")
        ) {
            int count = 0;
            for (String e :
                    textWithoutExcess.split(" ")) {
                if (wordThatIsBeingСompared.equals(e)) {
                    count++;
                    textWithoutExcess = textWithoutExcess.replace(wordThatIsBeingСompared, "");
                }
            }
            if (!wordСounter.containsKey(count) && count != 0) {
                wordСounter.put(count, wordThatIsBeingСompared);


            } else {
                String newValue = wordСounter.get(count) + " " + wordThatIsBeingСompared;
                wordСounter.replace(count, wordСounter.get(count), newValue);
            }
        }
        ArrayList<String> stringsAll = new ArrayList<>();
        int topNumber = 10;
        for (int i = topNumber; i > 0; i--) {
            if (wordСounter.containsKey(i)) {
                ArrayList<String> value = new ArrayList<>();
                String values = wordСounter.get(i);
                for (String a :
                        values.split(" ")) {
                    if (!a.equals("")) {
                        value.add(i + "-" + a);
                    }
                    value.sort(Comparator.naturalOrder());
                }
                stringsAll.addAll(value);
            }
        }
        for (int i = stringsAll.size() - 1; i >= topNumber; i--) {
            if (stringsAll.listIterator(i).hasPrevious()) {
                stringsAll.remove(i);
            }
        }
        System.out.println("TOP10:");
        for (String stringForPrint :
                stringsAll) {
            System.out.println(stringForPrint);

        }
        System.out.println();
    }

}
