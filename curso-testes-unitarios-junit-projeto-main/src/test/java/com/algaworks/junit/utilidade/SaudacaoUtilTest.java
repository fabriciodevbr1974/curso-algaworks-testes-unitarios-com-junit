package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

  @Test
  public void saudarBomDia() {
    String saudacao = SaudacaoUtil.saudar(9);
    assertEquals("Bom dia", saudacao, "Saudação correta!");
  }

  @Test
  public void saudarBoaTarde(){
    String saudacao = SaudacaoUtil.saudar(13);
    assertEquals("Boa tarde", saudacao);
  }

  @Test
  public void saudarBoaNoite(){
    String saudacao = SaudacaoUtil.saudar(19);
    assertEquals("Boa noite", saudacao);
  }

  @Test
  public void deveLancarException(){
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(-10));
    assertEquals("Hora invalida", illegalArgumentException.getMessage());
  }

  @Test
  public void naoDeveLancarException(){
    assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
  }

}