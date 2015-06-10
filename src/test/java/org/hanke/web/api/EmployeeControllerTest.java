package org.hanke.web.api;

import org.hanke.AbstractControllerTest;
import org.hanke.service.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class EmployeeControllerTest extends AbstractControllerTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testGetEmployees() throws Exception {
		String uri = "/api/employees";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		System.out.println("weuifhjoweifj: " + content);
		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP response body to have a value", content.trim().length() > 0);
	}
	
}