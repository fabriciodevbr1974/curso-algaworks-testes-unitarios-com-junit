package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

  @Test
  void deveLancarIllegalArgumentExceptionQuandoValorPassadoNoConstrutorForNulo() {
    BigDecimal valor = null;
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(valor));
    assertEquals("Saldo não pode ser nulo", illegalArgumentException.getMessage());
  }

  @Test
  void naoDeveLancarIllegalArgumentExceptionQuandoValorPassadoNoConstrutorNaoForNulo() {
    BigDecimal valor = BigDecimal.TEN;
    assertDoesNotThrow(() -> new ContaBancaria(valor));
  }

  @Test
  void deveLancarIllegalArgumentExceptionQuandoValorPassadoNoSaqueForNulo() {
    ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.TEN);
    System.out.println(contaBancaria.saldo());
    BigDecimal valor = null;
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> contaBancaria.saque(valor));
    assertEquals("Valor não pode ser nulo", illegalArgumentException.getMessage());
  }

  @Test
  void deveLancarIllegalArgumentExceptionQuandoValorPassadoNoSaqueForZero() {
    ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
    System.out.println(contaBancaria.saldo());
    BigDecimal valor = contaBancaria.saldo();
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> contaBancaria.saque(valor));
    assertEquals("Valor não pode ser zero", illegalArgumentException.getMessage());
  }

  @Test
  void deveLancarIllegalArgumentExceptionQuandoValorPassadoNoSaqueForNegativo() {
    ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
    BigDecimal valor = BigDecimal.valueOf(-10);
    System.out.println(valor);
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> contaBancaria.saque(valor));
    assertEquals("Valor não pode ser negativo", illegalArgumentException.getMessage());
  }

  @Test
  void deveLancarRuntimeExceptionQuandoValorPassadoNoSaqueForSaldoInsuficiente() {
    ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.TEN);
    RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> contaBancaria.saque(BigDecimal.valueOf(11)));
    assertEquals("Saldo insuficiente", runtimeException.getMessage());
  }

  @Test
  void naoDeveLancarRuntimeExceptionQuandoValorPassadoNoSaquePossuirSaldoSuficiente() {
    ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.TEN);
    assertDoesNotThrow(() -> contaBancaria.saque(BigDecimal.valueOf(9)));
    assertDoesNotThrow(() -> contaBancaria.saque(BigDecimal.valueOf(1)));
  }


  @Test
  void deveLancarIllegalArgumentExceptionQuandoValorPassadoNoDepositoForNulo() {
    ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.TEN);
    BigDecimal valor = null;
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> contaBancaria.deposito(valor));
    assertEquals("Valor não pode ser nulo", illegalArgumentException.getMessage());
  }

  @Test
  void deveLancarIllegalArgumentExceptionQuandoValorPassadoNoDepositoForZero() {
    ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.TEN);
    BigDecimal valor = BigDecimal.ZERO;
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> contaBancaria.deposito(valor));
    assertEquals("Valor não pode ser zero", illegalArgumentException.getMessage());
  }

  @Test
  void deveLancarIllegalArgumentExceptionQuandoValorPassadoNoDepositoForNegativo() {
    ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.TEN);
    BigDecimal valor = BigDecimal.valueOf(-10);
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> contaBancaria.deposito(valor));
    assertEquals("Valor não pode ser negativo", illegalArgumentException.getMessage());
  }

  @Test
  void naoDeveLancarIllegalArgumentExceptionQuandoValorPassadoNoDepositoForMaiorQueZero() {
    ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.TEN);
    BigDecimal valor = BigDecimal.valueOf(1);
    assertDoesNotThrow(() -> contaBancaria.deposito(valor));
  }


}