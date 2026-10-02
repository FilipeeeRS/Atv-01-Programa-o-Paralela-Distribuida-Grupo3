# Atv-01-Programa-o-Paralela-Distribuida
Atividade avaliativa da matéria "Programação Paralela Distribuída" engenheira de software 6º semestre

## O que faz
Ordena um vetor de bytes (-128 a 127) com **Merge Sort**, em modo sequencial ou paralelo, e compara os tempos.

O vetor é dividido em um pedaço por núcleo da CPU. Cada pedaço é ordenado por uma thread (`Ordenadora`) e depois os pedaços são juntados dois a dois, também em paralelo (`Misturadora`).

## Arquivos
- `MergeSortParalelo.java`: programa principal (menu, divisão do vetor e medição de tempo)
- `Ordenadora.java`: thread que ordena um pedaço com merge sort
- `Misturadora.java`: thread que junta dois pedaços já ordenados

## Como rodar
```
javac *.java
java -Xmx4G MergeSortParalelo
```
O programa pede o tamanho do vetor, se os valores serão digitados ou aleatórios e o modo (paralelo, sequencial ou ambos). No modo **3 (ambos)** ele mostra o speedup.
