package project.books.controller.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.books.bookProperties.Book;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BooksControllerTests {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testAddBook() throws Exception {
		Book newBook = new Book("Title", "Author", "Story", "read", 5, 5);
		String requestBody = this.mapper.writeValueAsString(newBook);
		RequestBuilder request = post("/addbook").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isCreated();

		Book savedBook = new Book("Title", "Author", "Story", "read", 5, 5);
		savedBook.setId(1L); // id = 2 because 1 value is inserted using data.sql

		String resultBody = this.mapper.writeValueAsString(savedBook);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

		MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();

		// In case you need to access the actual result as an object:
		String reqBody = result.getResponse().getContentAsString();

		Book bookResult = this.mapper.readValue(reqBody, Book.class);
	}

	@Test
	void testDelete() throws Exception {

		Book newBook = new Book("Title", "Author", "Story", "read", 5, 5);
		String requestBody = this.mapper.writeValueAsString(newBook);
		RequestBuilder request = post("/createduck").contentType(MediaType.APPLICATION_JSON).content(requestBody);
		request = delete("/remove/1").contentType(MediaType.APPLICATION_JSON).content(requestBody);
		ResultMatcher checkStatus = status().isOk();
		MvcResult result = this.mockMVC.perform(request).andExpect(checkStatus).andReturn();
		String reqBody = result.getResponse().getContentAsString();

	}
}
