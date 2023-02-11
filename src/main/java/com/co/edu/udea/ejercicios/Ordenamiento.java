package com.co.edu.udea.ejercicios;

public class Ordenamiento {

    public int[] quicksort(int array[], int izq, int der) {

        int pivote = array[izq]; // tomamos primer elemento como pivote
        int i = 0;         // i realiza la búsqueda de izquierda a derecha
        int j = der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {                          // mientras no se crucen las búsquedas
            while (array[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while (array[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux = array[i];                      // los intercambia
                array[i] = array[j];
                array[j] = aux;
            }
        }

        array[izq] = array[j];      // se coloca el pivote en su lugar de forma que tendremos
        array[j] = pivote;      // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1)
            quicksort(array, izq, j - 1);          // ordenamos subarray izquierdo
        if (j + 1 < der)
            quicksort(array, j + 1, der);          // ordenamos subarray derecho

        return array;
    }

    public int[] burbuja(int[] array) {

        for (int i = 0; i < array.length; i++) {
            // Aquí "y" se detiene antes de llegar
            // a length - 1 porque dentro del for, accedemos
            // al siguiente elemento con el índice actual + 1
            for (int j = 0; j < array.length - 1; j++) {
                int elementoActual = array[j],
                    elementoSiguiente = array[j + 1];
                if (elementoActual > elementoSiguiente) {
                // Intercambiar
                    array[j] = elementoSiguiente;
                    array[j + 1] = elementoActual;
                }
            }
        }

        return array;
    }
}
