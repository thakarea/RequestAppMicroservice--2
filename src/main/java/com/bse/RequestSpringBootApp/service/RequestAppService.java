package com.bse.RequestSpringBootApp.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bse.RequestSpringBootApp.dto.EmployeeDto;

@Service
public class RequestAppService {

	@Autowired
	private RestTemplate restTemplate;

	public EmployeeDto getDetails(String paygroup, String companyId) {
		ResponseEntity<EmployeeDto> empDto = null;
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.set("company-id", companyId);
		HttpEntity<String> entity = new HttpEntity<String>(header);
		empDto = restTemplate.exchange("http://localhost:8080/emplDetail/bse?payGroup=" + paygroup, HttpMethod.GET,entity, EmployeeDto.class);
		return empDto.getBody();
	}

}
