package ru.geekbrains.something;

import java.util.Arrays;

public class Counter {

        static final int SIZE = 10;
        static final int HALF = SIZE/2;

        float[] array;
        float[] a1;
        float[] a2;

        public Counter() {
            array = new float[SIZE];
            a1 = new float[HALF];
            a2 = new float[HALF];
        }

        public void method1(){
            for (int i = 0; i < SIZE; i++) {
                array[i] = 1;
            }
            System.out.println(Arrays.toString(array));

            long a = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println(Arrays.toString(array));
            System.out.println("time: " + (System.currentTimeMillis() - a));

        }

        private void divideArray(){
            System.arraycopy(array, 0, a1, 0, HALF);
            System.arraycopy(array, HALF, a2, 0, HALF);
            System.out.println("divide "+Arrays.toString(a1));
            System.out.println("divide "+Arrays.toString(a2));
        }

        private void restoreArray(){
            System.arraycopy(a1, 0, array, 0, HALF);
            System.arraycopy(a2, 0, array, HALF, HALF);
            System.out.println("restore "+Arrays.toString(array));
        }

        public void countValues(){
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }

        public void method2(){

            for (int i = 0; i < SIZE; i++) {
                array[i] = 1;
            }

            long a = System.currentTimeMillis();
            divideArray();

            countValues();

            restoreArray();
            System.out.println("time: " + (System.currentTimeMillis() - a));

        }
}
