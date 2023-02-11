package com.co.edu.udea;

import com.co.edu.udea.ejercicios.Matrices;
import com.co.edu.udea.ejercicios.Ordenamiento;

import java.util.Arrays;

public class Main {

    static Ordenamiento ordenamiento = new Ordenamiento();
    static Matrices matrices = new Matrices();

    public static void main(String[] args) {
        System.out.println("Comenzaremos a comparar los diferentes algoritmos...");

        int[] array = hacerArray();
        Long tiempoQuicksort = ejecutarQuicksort(array);
        Long tiempoBurnuja = ejecutarBurbuja(array);

        int[][] matrizA = hacerMatriz();
        int[][] matrizB = hacerMatriz();
        Long tiempoMultiplicacionDeMatrices = ejecutarMultiplicacionDeMatrices(matrizA, matrizB);

        hallarMasOptimo(tiempoQuicksort, tiempoBurnuja, tiempoMultiplicacionDeMatrices);
    }

    private static int[] hacerArray() {

        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 9) + 1;
        }

        return array;
    }

    private static int[][] hacerMatriz() {

        int matriz[][] = new int[4][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 9 + 1);
            }
        }

        return matriz;
    }

    private static Long ejecutarQuicksort(int[] array) {

        System.out.println("El array original es: " + Arrays.toString(array));
        long tiempoInicial = System.nanoTime();
        System.out.println("El array ordenado con QUICKSORT es: " + Arrays.toString(ordenamiento.quicksort(array, 0, array.length - 1)));
        long tiempoFinal = System.nanoTime() - tiempoInicial;
        System.out.println("El tiempo tardado en QUICKSORT es: " + tiempoFinal + " nanosegundos");

        return tiempoFinal;
    }

    private static Long ejecutarBurbuja(int[] array) {

        long tiempoInicial = System.nanoTime();
        System.out.println("El array ordenado con BURBUJA es" + Arrays.toString(ordenamiento.burbuja(array)));
        long tiempoFinal = System.nanoTime() - tiempoInicial;
        System.out.println("El tiempo tardado en BURBUJA es: " + tiempoFinal + " nanosegundos");

        return tiempoFinal;
    }

    private static Long ejecutarMultiplicacionDeMatrices(int[][] matrizA, int[][] matrizB) {

        System.out.println("la matriz A original es: ");

        for (int x = 0; x < matrizA.length; x++) {
            System.out.print("|");

            for (int y = 0; y < matrizA[x].length; y++) {
                System.out.print(matrizA[x][y]);
                if (y != matrizA[x].length - 1) System.out.print("\t");
            }

            System.out.println("|");
        }

        System.out.println("las matriz B original es: ");

        for (int x = 0; x < matrizB.length; x++) {
            System.out.print("|");

            for (int y = 0; y < matrizB[x].length; y++) {
                System.out.print(matrizB[x][y]);
                if (y != matrizB[x].length - 1) System.out.print("\t");
            }

            System.out.println("|");
        }

        long tiempoInicial = System.nanoTime();
        int[][] matrizMultiplicada = matrices.multiplicarMatriz(matrizA, matrizB);
        long tiempoFinal = System.nanoTime() - tiempoInicial;

        System.out.println("la matriz MULTIPLICADA es: ");

        for (int x = 0; x < matrizMultiplicada.length; x++) {
            System.out.print("|");

            for (int y = 0; y < matrizMultiplicada[x].length; y++) {
                System.out.print(matrizMultiplicada[x][y]);
                if (y != matrizMultiplicada[x].length - 1) System.out.print("\t");
            }

            System.out.println("|");
        }

        System.out.println("El tiempo tardado en MULTIPLICAR las matrices es: " + tiempoFinal + " nanosegundos");

        return tiempoFinal;
    }

    private static void hallarMasOptimo(Long tiempoQuicksort, Long tiempoBurnuja, Long tiempoMultiplicacionDeMatrices) {

        if (tiempoQuicksort < tiempoBurnuja) {
            if (tiempoQuicksort < tiempoMultiplicacionDeMatrices) {
                System.out.println("El algoritmo más optimo es QUICKSORT");
            } else {
                System.out.println("El algoritmo más optimo es MULTIPLICACIÓN DE MATRICES");
            }
        } else if (tiempoBurnuja < tiempoMultiplicacionDeMatrices) {
            System.out.println("El algoritmo más optimo es BURBUJA");

        } else {
            System.out.println("El algoritmo más optimo es MULTIPLICACIÓN DE MATRICES");
        }
    }
}