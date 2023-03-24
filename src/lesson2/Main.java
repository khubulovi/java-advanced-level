package lesson2;

/**
 * Java Core. Advanced level. Lesson 2
 *
 * @author Malkhaz Khubulovi
 * @version dated November 24, 2023
 */


// Task
//  1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//  2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
//  3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "2", "2", "3"},
                {"1", "4", "2", "1"},
                {"1", "2", "3", "4"},
                {"4", "2", "3", "1"}};
        try {
            int count = method(arr);
            System.out.println(count);
        } catch (MyArraySizeExpextion | MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Somthing's going wrong");
        }
    }

    public static int method(String[][] arr) throws MyArraySizeExpextion, MyArrayDataException {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 4 || arr.length != 4) {
                    throw new MyArraySizeExpextion();
                }
                try {
                    count += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }
        return count;
    }
}

