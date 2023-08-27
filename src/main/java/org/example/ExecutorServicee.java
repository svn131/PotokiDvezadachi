package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServicee {

    public static void main(String[] args) {

        System.out.println("Введите количество потоков");

        Scanner scn = new Scanner(System.in);

        int chisloPotokov = scn.nextInt();


        System.out.println("Введите числа через запятую");

        Scanner scn2 = new Scanner(System.in);

        // логика получения масива чисел

        String[] cifry = scn2.nextLine().split(",");

        int[] cifryInt = new int[cifry.length];


        for (int i = 0; i < cifry.length; i++) {
            cifryInt[i] = Integer.parseInt(cifry[i]);
        }

    // логика получения масива чисел




        ExecutorService executorServiceee = Executors.newFixedThreadPool(chisloPotokov);


        final int[] summ = {0};

        for (int i = 0; i <= cifryInt.length; i++) {
            final int index = i;

executorServiceee.execute(() -> {

            System.out.println( Thread.currentThread().getName());

    summ[0] += index;



        }




        );













        }

        executorServiceee.shutdown();//Метод shutdown() в классе ExecutorService используется для завершения работы пула исполнения. Когда вы вызываете этот метод, пул исполнения больше не принимает новые задачи на выполнение, но дожидается завершения всех ранее запущенных задач.

        //  После вызова shutdown(), пул исполнения будет ожидать завершения всех задач. Как только все задачи выполнены, пул исполнения полностью остановится и будет готов к закрытию.

        while (!executorServiceee.isTerminated()) {
            // Ожидание завершения всех задач
        }

        System.out.println(Arrays.toString(summ));






    }
}
