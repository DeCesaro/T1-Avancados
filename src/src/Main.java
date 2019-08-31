import java.util.Random;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        int[] randomArray = populateArray(80, 20);
        System.out.println("|| CONTEÚDO DO VETOR ||");
        System.out.println(Arrays.toString(randomArray));
        int[] arrayComAux = ParImparComVetor(randomArray);
        System.out.println("\nUSANDO VETOR AUXILIAR");
        System.out.println("Ordem do vetor ---->\t" + Arrays.toString(arrayComAux));
        int[] arraySemAux = ParImparSemVetor(randomArray);
        System.out.println("\nSEM VETOR AUXILIAR");
        System.out.println("Ordem do vetor ---->\t" + Arrays.toString(arraySemAux));

    }

    public static int[] populateArray(int numPar, int numImpar) {
        Random randomNumber = new Random();
        int size = numPar + numImpar;
        int[] array = new int[size];
        int countPar = 0;
        int countImpar = 0;
        int i = 0;
        while (i < size) {
            int rand = randomNumber.nextInt(100); //gera até x números randômicos
            if (rand % 2 == 0) {
                if (countPar < numPar) {
                    array[i] = rand;
                    countPar++;
                    i++;
                }
            } else if (countImpar < numImpar) {
                array[i] = rand;
                countImpar++;
                i++;
            }
        }
        return array;
    }

    /**
     * Método que irá percorrer um vetor e agrupar os números pares no inicio e ímpares no final sem o uso de um vetor auxiliar.
     */

        public static int[] ParImparSemVetor(int... array) {
            int i = 0; //1 iteracão
            while (i < array.length) {
                boolean troca = false;
                if (array[i] % 2 == 0) { //Verifica se é par
                    i++;
                } else {
                    int j = i;
                    while (!troca) {
                        if (array[j] % 2 != 0 && j < array.length - 1) { //Verifica se é impar e incrementa o j enquanto ele nao for o último
                            j++;
                        } else { // Realiza a troca entre os pares e impares
                            int aux = array[i];
                            array[i] = array[j];
                            array[j] = aux;
                            i++;
                            troca = true;
                        }
                    }
                }
            }
            return array;
        }

        /**
         * Método irá agrupar os pares no inicio e ímpares no final com o uso de um vetor
         */
        public static int[] ParImparComVetor(int... array) {
            int[] ordenaVet = new int[array.length];
            int quantPar = 0;
            int quantImpar = array.length - 1;
            for (int num : array) {
                if (num % 2 == 0) {
                    ordenaVet[quantPar] = num;
                    quantPar++;
                } else {
                    ordenaVet[quantImpar] = num;
                    quantImpar--;
                }
            }
            return ordenaVet;
        }
    }
