/**Nomes: Bernardo de Cesaro e Gustavo Possebon
 * Disciplina de Algoritmos Avançados - Turma: 127
 * Complexidade de Algoritmos
 */

import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] VetorPopulado = PopulaArray(80, 20);
        System.out.println("|| CONTEÚDO DO VETOR ||");
        System.out.println(Arrays.toString(VetorPopulado));
        int[] arrayComAux = ParImparComVetor(VetorPopulado);
        System.out.println("\nUSANDO VETOR AUXILIAR");
        System.out.println("Ordem do vetor ---->\t" + Arrays.toString(arrayComAux));
        int[] arraySemAux = ParImparSemVetor(VetorPopulado);
        System.out.println("\nSEM VETOR AUXILIAR");
        System.out.println("Ordem do vetor ---->\t" + Arrays.toString(arraySemAux));

    }

    public static int[] PopulaArray(int numPar, int numImpar) {
        Random randomNum = new Random();
        int tamanho = numPar + numImpar;
        int[] array = new int[tamanho];
        int countPar = 0, countImpar = 0, i = 0;
        while (i < tamanho) {
            int rand = randomNum.nextInt(100); //gera até x números randômicos
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
     * Método que irá percorrer o vetor e agrupar os números pares no inicio e ímpares no final sem o uso de um vetor auxiliar.
     */

        public static int[] ParImparSemVetor(int... vet) { //Indica um número indeterminado de inteiros a serem colocados no array
            int i = 0; //1 iteracão
            while (i < vet.length) { // 2 iterações
                boolean troca = false; //1 +
                if (vet[i] % 2 == 0) { //Verifica se é par 3 +
                    i++; // 2 +
                } else {
                    int j = i; // 1 +
                    while (!troca) { // 1 +
                        if (vet[j] % 2 != 0 && j < vet.length - 1) { //Verifica se é impar e incrementa o j enquanto ele nao for o último // 6 +
                            j++; // 2 +
                        } else { // Realiza a troca entre os pares e impares
                            int aux = vet[i];
                            vet[i] = vet[j];
                            vet[j] = aux;
                            i++;
                            troca = true;
                        }
                    }
                }
            }
            return vet;
        }

        /**
         * Método irá agrupar os pares no inicio e ímpares no final com o uso de um vetor auxiliar
         */
        public static int[] ParImparComVetor(int... vet) {
            int[] ordenaVet = new int[vet.length]; // 2 +
            int quantPar = 0; // 1 +
            int quantImpar = vet.length - 1; //3 +
            for (int num : vet) { // 1 +
                if (num % 2 == 0) { // 2 +
                    ordenaVet[quantPar] = num; // 2 +
                    quantPar++; // 2 +
                } else {
                    ordenaVet[quantImpar] = num; // 2 +
                    quantImpar--; // 2 +
                }
            }
            return ordenaVet; // 1 +
        }
    }
