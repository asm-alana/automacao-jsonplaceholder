package com.typicode.jsonplaceholder.steps;

import com.typicode.jsonplaceholder.api.ApiUtils;
import com.typicode.jsonplaceholder.utils.ScenarioUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.HashMap;

public class Hooks extends ApiUtils {

    @Before
    public void before(Scenario scenario){
        ScenarioUtils.add(scenario);
        headers = new HashMap<>();
    }

    @After
    public void after(){
        ScenarioUtils.remove();
    }
}
