package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

  @Test
  public void saudarBomDia() {
    String saudacao = SaudacaoUtil.saudar(9);
    assertEquals("Bom dia", saudacao, "Saudação correta!");
  }

  @Test
  public void saudarBomDiaAPartir5h() {
    //Arrange
    int horaValida = 5;
    //Act
    String saudacao = SaudacaoUtil.saudar(horaValida);
    //Assert
    assertEquals("Bom dia", saudacao);
  }

  @Test
  public void saudarBoaTarde(){
    int horaValida = 13;
    String saudacao = SaudacaoUtil.saudar(horaValida);
    assertEquals("Boa tarde", saudacao);
  }

  @Test
  public void saudarBoaNoite(){
    int horaValida = 19;
    String saudacao = SaudacaoUtil.saudar(horaValida);
    assertEquals("Boa noite", saudacao);
  }

  @Test
  public void saudarBoaNoiteAs4h(){
    int horaValida = 4;
    String saudacao = SaudacaoUtil.saudar(horaValida);
    assertEquals("Boa noite", saudacao);
  }

  @Test
  public void deveLancarException(){
    //Arrange
    int horaInvalida = -10;

    //Act
    Executable chamadaDeMetodoInvalida = () -> SaudacaoUtil.saudar(horaInvalida);
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, chamadaDeMetodoInvalida);

    //Assert
    assertEquals("Hora invalida", illegalArgumentException.getMessage());
  }

  @Test
  public void naoDeveLancarException(){
    //Arrange;
    int horaValida = 0;
    //Act
    Executable chamadaValidaDeMetodo = () -> SaudacaoUtil.saudar(horaValida);
    //Assert
    assertDoesNotThrow(chamadaValidaDeMetodo);
  }

}