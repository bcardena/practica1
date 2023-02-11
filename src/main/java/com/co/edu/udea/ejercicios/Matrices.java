package com.co.edu.udea.ejercicios;

public class Matrices {

    public int[][] multiplicarMatriz(int[][] matrizA, int[][] matrizB){

        //Lugar en donde se almacena el resultado
        int[][] producto = new int[matrizB.length][matrizB[0].length];

        // Necesitamos hacer esto por cada columna de la segunda matriz (B)
        for (int a = 0; a < matrizB[0].length; a++) {
            // Dentro recorremos las filas de la primera (A)
            for (int i = 0; i < matrizA.length; i++) {
                int suma = 0;
                // Y cada columna de la primera (A)
                for (int j = 0; j < matrizA[0].length; j++) {
                    // Multiplicamos y sumamos resultado
                    suma += matrizA[i][j] * matrizB[j][a];
                }
                // Lo acomodamos dentro del producto
                producto[i][a] = suma;
            }
        }

        return producto;
    }
}
