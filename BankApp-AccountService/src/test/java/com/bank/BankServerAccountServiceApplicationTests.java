package com.bank;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Map;

class BankServerAccountServiceApplicationTests {

	@Test
	void contextLoads() throws IOException {
		Object objectJson =convertXML("<account><accountNumber>123456</accountNumber><balance>1000.0</balance></account>").getBody();
		Assertions.assertNotNull(objectJson);
		Assertions.assertTrue(objectJson instanceof String);
		String jsonString = (String) objectJson;
		Assertions.assertEquals("{\n" +
				"  \"accountNumber\" : \"123456\",\n" +
				"  \"balance\" : \"1000.0\"\n" +
				"}", jsonString);
	}
	public ResponseEntity<Object> convertXML(String xml) throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		JsonNode jsonNode=xmlMapper.readTree(xml);
		ObjectMapper objectMapper = new ObjectMapper();
		String json= objectMapper
                .writerWithDefaultPrettyPrinter()
				.writeValueAsString(jsonNode);
		return ResponseEntity.status(HttpStatus.OK).body(json);
	}

}
