package com.example.pokedex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PokedexControllerTest {
    @Autowired PokedexController controller;

    @Test public void
    returns_greeting() {
        assertThat(controller.pokedex()).isEqualTo("Hello World");
    }
}
