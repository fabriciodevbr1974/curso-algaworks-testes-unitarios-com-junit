package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FiltroNumerosTest {

  @Test
  public void deveRetornarNumerosPares() {
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
    List<Integer> numerosParesEsperados = Arrays.asList(2,4);
    List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);
    Assertions.assertIterableEquals(numerosParesEsperados, resultadoFiltro);//Verifica a ordem
  }

  @Test
  public void deveRetornarNumerosImpares() {
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
    List<Integer> numerosImparesEsperados = Arrays.asList(1,3);
    List<Integer> resultadoFiltro = FiltroNumeros.numerosImpares(numeros);
    Assertions.assertIterableEquals(numerosImparesEsperados, resultadoFiltro);//Verifica a ordem
  }

}