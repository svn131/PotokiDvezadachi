package org.example;

import java.util.Scanner;

public class ReshenyeCherezTread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");


        System.out.println("Введите число потоков");

        Scanner scn = new Scanner(System.in);

        int cauntPotokov = scn.nextInt();

        System.out.println("Введите числа через запятую");

        Scanner scn2 = new Scanner(System.in);

        String[] cifry = scn2.nextLine().split(",");

        int[] cifryInt = new int[cifry.length];


        for (int i = 0; i < cifry.length; i++) {
            cifryInt[i] = Integer.parseInt(cifry[i]);
        }


        int cifrNapotok = cifryInt.length / cauntPotokov;
        int ostatokCifrNapotok = cifryInt.length % cauntPotokov;

        int[] obshiiMasuv = new int[cauntPotokov];




        Thread[] threadsArr = new Thread[cauntPotokov];


        for (int i = 0; i < cauntPotokov; i++) {

            boolean poslednyiCicl = i == cifrNapotok-1;

            final int finalI = i;

            threadsArr[i] = new Thread("Thread" + i) {

                @Override
                public void run() {
                    // Код, который будет выполняться в новом потоке


                    int summ = 0;
                    int skolkoProity = cifrNapotok;

                    if(poslednyiCicl){
                         skolkoProity = cifrNapotok+ostatokCifrNapotok;
                    }

                    for (int x = finalI * cifrNapotok; x <  finalI * cifrNapotok + skolkoProity; x++) {
                        summ += cifryInt[x];
                    }
                    obshiiMasuv[finalI] = summ; // ??

                }


            };





        }



        for (Thread thread : threadsArr) {
            thread.start();
        }
//         Ожидание завершения всех потоков
        for (Thread thread : threadsArr) {
            thread.join();
        }



        int finalSumm = 0;
        for (int i = 0; i < obshiiMasuv.length;i++){
            finalSumm += obshiiMasuv[i];
        }

        System.out.println(finalSumm);

    }
}

//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Hello world!");
//
//        System.out.println("Введите число");
//        Scanner scn = new Scanner(System.in);
//        int cauntPotokov = scn.nextInt();
//
//        System.out.println("Введите числа через запятую");
//        Scanner scn2 = new Scanner(System.in);
//        String[] cifry = scn2.nextLine().split(",");
//        int[] cifryInt = new int[cifry.length];
//
//        for (int i = 0; i < cifry.length; i++) {
//            cifryInt[i] = Integer.parseInt(cifry[i]);
//        }
//
//        int cifrNapotok = cifryInt.length / cauntPotokov;
//        int ostatokCifrNapotok = cifryInt.length % cauntPotokov;
//
//        int[] obshiiMasuv = new int[cauntPotokov];
//
//        Thread[] threads = new Thread[cauntPotokov];
//
//        for (int i = 0; i < cauntPotokov; i++) {
//            boolean poslednyiCicl = i == cifrNapotok-1;
//
//            final int finalI = i;
//
//            Thread thread = new Thread("Thread" + i) {
//                @Override
//                public void run() {
//                    int summ = 0;
//                    int skolkoProity = cifrNapotok;
//
//                    if (poslednyiCicl) {
//                        skolkoProity = cifrNapotok + ostatokCifrNapotok;
//                    }
//
//                    for (int x = finalI * cifrNapotok; x < skolkoProity; x++) {
//                        summ += cifryInt[x];
//                    }
//                    obshiiMasuv[finalI] = summ;
//                }
//            };
//
//            threads[i] = thread;
//            thread.start();
//        }
//
//        // Ожидание завершения всех потоков
//        for (Thread thread : threads) {
//            thread.join();
//        }
//
//        int finalSumm = 0;
//        for (int i = 0; i < obshiiMasuv.length; i++) {
//            finalSumm += obshiiMasuv[i];
//        }
//
//        System.out.println(finalSumm);
//    }
//}
//
//
//

