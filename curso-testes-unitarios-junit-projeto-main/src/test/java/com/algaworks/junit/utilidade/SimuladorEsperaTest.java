package com.algaworks.junit.utilidade;

import com.sun.jdi.request.DuplicateRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorEsperaTest {

  @Test
  void deveEsperarENaoDarTimeout() {
    Assertions.assertTimeout(Duration.ofSeconds(1), () -> SimuladorEspera.esperar(Duration.ofSeconds(10)));
  }

  @Test
  void deveEsperarENaoDarTimeout2() {
    Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> SimuladorEspera.esperar(Duration.ofSeconds(10)));
  }

  @Test
  void deveEsperarENaoDarTimeout3() {
    Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> SimuladorEspera.esperar(Duration.ofMillis(10)));
  }

}