package com.encore.pms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encore.pms.dto.Phone;
import com.encore.pms.service.IPhoneService;

@RestController
public class PhoneRestController {
	
	@Autowired
	private IPhoneService service;
	
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		try {
			Phone phone=new Phone();
			phone.setNum(num);
			Phone selected=service.select(phone);
			return new ResponseEntity(selected,HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/phone") // select restful에서는 이름을 동일하게 가져간다.
//	@PostMapping("/phone")// insert역할
	public ResponseEntity select() {
		try {
			List<Phone> list=new ArrayList<Phone>();
			list=service.select();
			return new ResponseEntity( list,HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	// 리스트 내에 객체가 묶인 상태로 나타난다.
	// 전부 받아오기때문에 입력값이 필요없어서 PathVariable이 필요없다.
	
	@PostMapping("/phone")
	public ResponseEntity insert(@RequestBody Phone phone) { // front에서 넘어오는 객체를 넣어야하기 때문에 requestBody로 받아서 넣는다.
		try {
			int result=service.insert(phone);
			return new ResponseEntity(HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		try {
			int result =service.delete(Arrays.asList(num));
			return new ResponseEntity(HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	/*
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		try {
			int result = service.update(phone);
			if(result>0) return new ResponseEntity(HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	*/
}
