package com.encore.emp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.emp.domain.EmployeeDto;
import com.encore.emp.service.EmpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
@CrossOrigin(origins= {"*"}, maxAge=6000)
@Api(tags= {"Encore HRM"})
public class EmpolyeeController {
	
	@Autowired
	private EmpService service;
	
	@ApiOperation(value="모든 사원의 정보를 반환한다.", response=List.class)
	@GetMapping("/findAllEmployees")
	public ResponseEntity<List<EmployeeDto>> findAllEmployees() throws Exception{
		List<EmployeeDto> emps = service.findAllEmployees();
		if(emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emps, HttpStatus.OK);
	}
	
	@ApiOperation(value="모든 사원의 총 인원수를 반환한다.", response=Integer.class)
	@GetMapping("/getEmployeesTotal") // 사원의 총 인원수 리턴
	public ResponseEntity getEmployeesTotal() throws Exception{
		int totalEmployees = service.getEmployeesTotal();
		if(totalEmployees==0) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(totalEmployees, HttpStatus.OK);
	}
	
	@ApiOperation(value="사원Id로 사원의 정보를 찾는다.", response=EmployeeDto.class)
	@GetMapping("/findEmployeeById/{id}") // 아이디로 직원 찾기
	public ResponseEntity findEmployeeById(@PathVariable int id) throws Exception{
		EmployeeDto emp = service.findEmployeeById(id);
		if(emp==null) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emp, HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 이름이 들어간 사원의 정보를 찾는다.", response=List.class)
	@GetMapping("/findLikeEmployees/{name}") // 이름으로 직원 찾기
	public ResponseEntity findEmployeeById(@PathVariable String name) throws Exception{
		List<EmployeeDto> emps = service.findLikeEmployees(name);
		if(emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emps, HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 상사에 소속된 사원의 정보를 찾는다.", response=List.class)
	@GetMapping("/findEmployeesByManagerId/{manager_id}") // 이름으로 직원 찾기
	public ResponseEntity findEmployeesByManagerId(@PathVariable int manager_id) throws Exception{
		List<EmployeeDto> emps = service.findEmployeesByManagerId(manager_id);
		if(emps.isEmpty()) return new ResponseEntity(HttpStatus.NO_CONTENT);
		else return new ResponseEntity(emps, HttpStatus.OK);
	}
	
	@ApiOperation(value="사원을 추가한다", response=EmployeeDto.class)
	@PostMapping("/addEmployee")
	public ResponseEntity addEmployee(@RequestBody EmployeeDto dto) throws Exception{
		service.addEmployee(dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@ApiOperation(value="사원의 정보를 수정한다.", response=Boolean.class)
	@PutMapping("/updateEmployee")
	public ResponseEntity updateEmployee(@RequestBody EmployeeDto dto) throws Exception{
		boolean flag = service.updateEmployee(dto);
		if(flag==false) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(flag, HttpStatus.OK);
	}
	
	@ApiOperation(value="Id에 해당하는 사원의 정보를 삭제한다", response=Boolean.class)
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity deleteEmployee(@PathVariable int id) throws Exception{
		boolean result = service.deleteEmployee(id);
		if(result==false) return new ResponseEntity(HttpStatus.NO_CONTENT);
		return new ResponseEntity(result, HttpStatus.OK);
	}
}
