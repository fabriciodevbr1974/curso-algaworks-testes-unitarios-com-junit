package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PessoaTest {

  @Test
  void assercaoAgrupada() {
    Pessoa pessoa = new Pessoa("Alex", "Silva");

//    Assertions.assertEquals("Alex", pessoa.getNome());
//    Assertions.assertEquals("Silva", pessoa.getSobrenome());

    Assertions.assertAll("Asserções de pessoa",
            () -> Assertions.assertEquals("Alex", pessoa.getNome()),
            () -> Assertions.assertEquals("Silva", pessoa.getSobrenome()));

  }


}