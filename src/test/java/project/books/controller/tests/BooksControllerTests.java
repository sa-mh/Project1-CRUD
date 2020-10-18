package project.books.controller.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
	void contextLoads() {
	}

	@Test
	void testAddBook() throws Exception {
		Book newBook = new Book("Title", "Author", "Story", "read", 5, 5, 55555);
		String requestBody = this.mapper.writeValueAsString(newBook);
		RequestBuilder request = post("/addbook").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isCreated();

		Book savedBook = new Book("Title", "Author", "Story", "read", 5, 5, 55555);
		savedBook.setId(4L); // id = 2 because 1 value is inserted using data.sql

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

	@Test
	void testUpdate() throws Exception {
		Book newBook = new Book("Test book", "Test author", "Test genre", "To Read", 50, 10, 55555);
		String requestBody = this.mapper.writeValueAsString(newBook);
		RequestBuilder request = put("/updatebook?id=2").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isAccepted();

		Book savedBook = new Book("Test book", "Test author", "Test genre", "To Read", 50, 10, 55555);
		savedBook.setId(2L); // id = 1 because we're updating the value inserted using data.sql

		String resultBody = this.mapper.writeValueAsString(savedBook);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testGetBook() throws Exception {
		Book book = new Book("The Dave Smith Autobiography", "Dave Smith", "Drama", "Currently Reading", 100, 46,
				101010);
		book.setId(1L); // wood object to match the one in wood-data.sql
		String responseBody = this.mapper.writeValueAsString(book);

		this.mockMVC.perform(get("/getbook/1")).andExpect(status().isOk()).andExpect(content().json(responseBody));

	}
}
