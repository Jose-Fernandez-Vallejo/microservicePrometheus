package com.example.microservicioPrometheus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class TestController {
	
	Counter counter;
	
	public TestController(MeterRegistry registry)
	{
		this.counter = Counter.builder("invocaciones.hello").description("Total Invocaciones").register(registry);
	}
	
	@GetMapping(path = "/helloworld")
	public String helloWorld()
	{
		counter.increment();
		return "hello darkness my old friend";
	}

}
