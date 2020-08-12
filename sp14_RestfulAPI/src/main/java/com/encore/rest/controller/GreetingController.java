package com.encore.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.domain.Greeting;

@RestController
public class GreetingController {
	//필드 추가
	private static final String TEMPALTE = "Hi~~~, %s";
	// autoincrement 효과
	private final AtomicLong count = new AtomicLong(); 
	
	//http://127.0.0.1:8888/rest/greet
	@GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L, "Restful API");
	}
	
	//http://127.0.0.1:8888/rest/greet/33
	@GetMapping("greet/{id}")
	public String showSample(@PathVariable int id) {
		return "Hello RestfulAPI case number..."+id;
	}
	
	//http://127.0.0.1:8888/rest/greet2?name=엔코아
	@GetMapping("greet2")
	public Greeting sayGreet2(@RequestParam(value="name", required=false, defaultValue="world") String name) {
		return new Greeting(count.incrementAndGet(), String.format(TEMPALTE, name));
	}
}
