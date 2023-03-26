package lesson3;

import java.util.HashMap;
import java.util.Map;

/**
 * Java Core. Advanced level. Lesson 3
 *
 * @author Malkhaz Khubulovi
 * @version dated Mart 25, 2023
 */

//    1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
//     Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
//    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи.
//     С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

public class Main {
    public static void main(String args[]) {
        //Task #1a
        Map<String ,Integer> map = new HashMap<>();
        String[] words = {"Alik", "Artem", "Maxo", "Nika", "Alik", "Artem", "Maxo", "Alik", "Nika", "Alik","Giorgi"};
        for (String word:words
        ) {map.put(word,map.getOrDefault(word,0)+1);}
        System.out.println(map + "\n" + map.size());

        //task #1b
        Map<String,Integer> freqeuncyByWord=new HashMap<>();
        for (String word:words
        ) {Integer frequency= freqeuncyByWord.get(word);
            if(frequency==null){
                frequency=0;
            }freqeuncyByWord.put(word,++frequency);
        }
        for (Map.Entry<String,Integer> entry: freqeuncyByWord.entrySet()
        ) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

//Task #2
        Phonebook phonebook=new Phonebook();
        phonebook.add("Alik","23412412341");
        phonebook.add("Nika","234123412431");
        phonebook.add("Mgoyan","@13412341");
        phonebook.add("Khubulovi","23412341");
        phonebook.add("Meliqianc","12341341");
        phonebook.add("Mgoyan","214314231");
        phonebook.add("Khubulovi","!@3412341");

        System.out.println(phonebook.get("Khubulovi"));
        System.out.println(phonebook.get("Mgoyan"));
    }
}
