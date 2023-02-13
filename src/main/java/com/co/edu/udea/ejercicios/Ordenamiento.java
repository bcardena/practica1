package com.co.edu.udea.ejercicios;

public class Ordenamiento {

    public Long tiempoEjecucion;

    public Long sumatoriaTiempo = 0L;

    public Long tiempoActual = 0L;

    public int[] quicksort(int array[], int izq, int der) {
        calcularTiempoEjecucion();

        int pivote = array[izq];
        calcularTiempoEjecucion();

        int i = 0;
        calcularTiempoEjecucion();

        int j = der;
        calcularTiempoEjecucion();

        int aux;
        calcularTiempoEjecucion();

        while (i < j) {
            calcularTiempoEjecucion();

            while (array[i] <= pivote && i < j) i++;
            calcularTiempoEjecucion();

            while (array[j] > pivote) j--;
            calcularTiempoEjecucion();

            if (i < j) {
                calcularTiempoEjecucion();

                aux = array[i];
                calcularTiempoEjecucion();

                array[i] = array[j];
                calcularTiempoEjecucion();

                array[j] = aux;
                calcularTiempoEjecucion();
            }
        }

        array[izq] = array[j];
        calcularTiempoEjecucion();

        array[j] = pivote;
        calcularTiempoEjecucion();


        if (izq < j - 1) {
            calcularTiempoEjecucion();

            quicksort(array, izq, j - 1);
            calcularTiempoEjecucion();
        }
        if (j + 1 < der) {
            calcularTiempoEjecucion();

            quicksort(array, j + 1, der);
            calcularTiempoEjecucion();
        }

        return array;
    }

    public int[] burbuja(int[] array) {
        limpiarVariables();
        calcularTiempoEjecucion();

        for (int i = 0; i < array.length; i++) {
            calcularTiempoEjecucion();

            for (int j = 0; j < array.length - 1; j++) {
                calcularTiempoEjecucion();

                int elementoActual = array[j];
                calcularTiempoEjecucion();

                int elementoSiguiente = array[j + 1];
                calcularTiempoEjecucion();

                if (elementoActual > elementoSiguiente) {
                    calcularTiempoEjecucion();

                    array[j] = elementoSiguiente;
                    calcularTiempoEjecucion();

                    array[j + 1] = elementoActual;
                    calcularTiempoEjecucion();
                }
            }
        }

        System.out.println("El tiempo total de ejecución de BURBUJA es " + sumatoriaTiempo);
        return array;
    }

    private void calcularTiempoEjecucion() {
        if (tiempoActual != 0) {
            tiempoEjecucion = System.nanoTime() - tiempoActual;
            sumatoriaTiempo = sumatoriaTiempo + tiempoEjecucion;
            System.out.println("El tiempo acumulado de ejecución es: " + sumatoriaTiempo);
        }
        tiempoActual = System.nanoTime();
    }

    private void limpiarVariables(){
        tiempoActual = 0L;
        tiempoEjecucion = 0L;
        sumatoriaTiempo = 0L;
    }
}
