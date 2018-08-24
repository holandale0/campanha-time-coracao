package br.com.campanha.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {
	
	private List<String> serviceList = new ArrayList<String>();
	
	@GetMapping
	@ResponseBody
	public ResponseEntity get() {
		
		serviceList.add("http://localhost:8080/campanhas");
		serviceList.add("http://localhost:8080/usuarios");
	
		return ResponseEntity.ok().body(serviceList);
		
	}

}
