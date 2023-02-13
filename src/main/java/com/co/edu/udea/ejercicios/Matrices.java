package com.co.edu.udea.ejercicios;

public class Matrices {

    public Long tiempoEjecucion;
    public Long sumatoriaTiempo = 0L;

    public Long tiempoActual = 0L;

    public int[][] multiplicarMatriz(int[][] matrizA, int[][] matrizB){
        calcularTiempoEjecucion();

        int[][] producto = new int[matrizB.length][matrizB[0].length];
        calcularTiempoEjecucion();

        for (int a = 0; a < matrizB[0].length; a++) {
            calcularTiempoEjecucion();

            for (int i = 0; i < matrizA.length; i++) {
                calcularTiempoEjecucion();

                int suma = 0;
                calcularTiempoEjecucion();

                for (int j = 0; j < matrizA[0].length; j++) {
                    calcularTiempoEjecucion();

                    suma += matrizA[i][j] * matrizB[j][a];
                    calcularTiempoEjecucion();
                }
                producto[i][a] = suma;
                calcularTiempoEjecucion();
            }
        }

        return producto;
    }

    private void calcularTiempoEjecucion(){
        if (tiempoActual != 0){
            tiempoEjecucion = System.nanoTime() - tiempoActual;
            sumatoriaTiempo =  sumatoriaTiempo + tiempoEjecucion;
            System.out.println("El tiempo acumulado de ejecución es: " + sumatoriaTiempo);
        }
        tiempoActual = System.nanoTime();
    }
}
