package lesson5;

import java.util.Arrays;

/**
 * Java Core. Advanced level. Lesson 5
 *
 * @author Malkhaz Khubulovi
 * @version dated Mart 26, 2023
 */

// Task
//1. Необходимо написать два метода, которые делают следующее:
//        1) Создают одномерный длинный массив, например:
//       static final int size = 10000000;
//       static final int h = size / 2;
//        float[] arr = new float[size];
//        2) Заполняют этот массив единицами;
//        3) Засекают время выполнения: long a = System.currentTimeMillis();
//        4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        5) Проверяется время окончания метода System.currentTimeMillis();
//        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//        Отличие первого метода от второго:
//        Первый просто бежит по массиву и вычисляет значения.
//        Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
//
//        Пример деления одного массива на два:
//        System.arraycopy(arr, 0, a1, 0, h);
//        System.arraycopy(arr, h, a2, 0, h);
//
//        Пример обратной склейки:
//        System.arraycopy(a1, 0, arr, 0, h);
//        System.arraycopy(a2, 0, arr, h, h);
//
//        Примечание:
//        System.arraycopy() копирует данные из одного массива в другой:
//        System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
//        По замерам времени:
//        Для первого метода надо считать время только на цикл расчета:
//        for (int i = 0; i < size; i++) {
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
// 2.       Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.

public class Main {
    private static final int Size = 1000000;
    private static final int h = Size / 2;

    public static void main(String[] args) throws InterruptedException {
        cutArraysToPart();
        countOneArray();
    }

    public static float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }
    public static void countOneArray() {
        float arr[] = new float[Size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        calculate(arr);
        System.currentTimeMillis();
        System.out.println("One Array calculates in : " + (System.currentTimeMillis() - a));
    }

    synchronized public static void cutArraysToPart() throws InterruptedException {
        float arr[] = new float[Size];
        float arr1[] = new float[Size / 2];
        float arr2[] = new float[Size / 2];

        System.arraycopy(arr, 0, arr1, 0, Size / 2);
        System.arraycopy(arr, Size / 2, arr2, 0, Size / 2);
        long a = System.currentTimeMillis();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                calculate(arr1);
                System.currentTimeMillis();
                System.out.println("The calculation time of first array is : " + (System.currentTimeMillis() - a));
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                calculate(arr2);
                System.currentTimeMillis();
                System.out.println("The calculation time of second array is : " + (System.currentTimeMillis() - a));
            }
        };
        t1.start();
        t2.start();
        System.arraycopy(arr1, 0, arr, 0, Size / 2);
        System.arraycopy(arr2, 0, arr, Size / 2, Size / 2);
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The calculation time of two Array :" + (System.currentTimeMillis() - a));
    }
}

