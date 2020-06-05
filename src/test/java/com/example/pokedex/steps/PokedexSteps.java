package com.example.pokedex.steps;

import com.example.pokedex.ScenarioState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PokedexSteps extends CucumberStepDefs {

    @Autowired ScenarioState scenarioState;
    private Map<String, String> endpoints = Map.of("home", "/");


    @When("^a request is received to the (.+) endpoint$")
    public void aRequestIsMadeTo(String endpointName) throws IOException, InterruptedException {
        String endpoint = endpoints.get(endpointName);

        scenarioState.execute(endpoint);
    }

    @Then("^a (\\d+) response is returned$")
    public void aResponseIsReturned(int statusCode) {
        assertThat(scenarioState.getResponse().statusCode()).isEqualTo(statusCode);
    }

    @And("^it contains (.+)$")
    public void itContains(String responseText) {
        assertThat(scenarioState.getResponse().body()).isEqualTo(responseText);
    }
}
