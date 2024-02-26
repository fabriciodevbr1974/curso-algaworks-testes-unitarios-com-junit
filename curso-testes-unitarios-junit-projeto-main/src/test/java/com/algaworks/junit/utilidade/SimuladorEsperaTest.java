package com.algaworks.junit.utilidade;

import com.sun.jdi.request.DuplicateRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

  @Test
//  @Disabled("Não é mais aplicavel")
  @EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
  void deveEsperarENaoDarTimeout() {
//    Assumptions.assumeTrue("PROD".equals(System.getenv("ENV")), () -> "Abortando teste: Não deve ser executado em PROD");
    Assertions.assertTimeout(Duration.ofSeconds(1), () -> SimuladorEspera.esperar(Duration.ofSeconds(10)));
  }

//  @Test
//  void deveEsperarENaoDarTimeout2() {
//    Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> SimuladorEspera.esperar(Duration.ofSeconds(10)));
//  }

  @Test
  void deveEsperarENaoDarTimeout3() {
    Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> SimuladorEspera.esperar(Duration.ofMillis(10)));
  }

}