package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.bookstore.web.BookController;
import fi.haagahelia.bookstore.web.BookRestController;
import fi.haagahelia.bookstore.web.CategoryController;
import fi.haagahelia.bookstore.web.UserController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private BookRestController bookRestController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private UserController userController;

	@Test
	public void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(bookRestController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(userController).isNotNull();
	}

}
