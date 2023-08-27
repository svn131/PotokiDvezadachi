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

// Решение от гпт чата

// это решение неучитывает что чисел может быть наприме 7мь а потко 3 и тогда одному потоку прийдеться поработать с тремя числамиза место двух - тость данная модель работает только нколичесве цифр -кратному количеству потоков.

//public class ExecutorServicee {
//
//    public static void main(String[] args) {
//
//        System.out.println("Введите количество потоков");
//
//        Scanner scn = new Scanner(System.in);
//
//        int chisloPotokov = scn.nextInt();
//
//        System.out.println("Введите числа через запятую");
//
//        Scanner scn2 = new Scanner(System.in);
//
//        // логика получения массива чисел
//
//        String[] cifry = scn2.nextLine().split(",");
//        int[] cifryInt = new int[cifry.length];
//
//        for (int i = 0; i < cifry.length; i++) {
//            cifryInt[i] = Integer.parseInt(cifry[i]);
//        }
//
//        // логика получения массива чисел
//
//        ExecutorService executorServiceee = Executors.newFixedThreadPool(chisloPotokov);
//
//        Future<?>[] futures = new Future[chisloPotokov];
//
//        for (int i = 0; i < chisloPotokov; i++) {
//            final int startIndex = i * cifryInt.length / chisloPotokov;
//            final int endIndex = (i + 1) * cifryInt.length / chisloPotokov;
//
//            futures[i] = executorServiceee.submit(() -> {
//                int sum = 0;
//                for (int j = startIndex; j < endIndex; j++) {
//                    sum += cifryInt[j];
//                }
//                return sum;
//            });
//        }
//
//        int totalSum = 0;
//        for (Future<?> future : futures) {
//            try {
//                totalSum += (int) future.get();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        executorServiceee.shutdown();
//
//        System.out.println("Итоговая сумма всех чисел: " + totalSum);
//    }
//}

// В этой версии кода используется метод submit() для выполнения задач в пуле потоков. Каждый поток обрабатывает свою часть массива чисел и возвращает сумму этой части. Затем мы суммируем все значения из каждого потока, чтобы получить итоговую сумму.
//
//Попробуйте запустить исправленный код и убедитесь, что он работает корректно. Если у вас возникнут дополнительные вопросы или потребуется помощь, не стесняйтесь спрашивать!