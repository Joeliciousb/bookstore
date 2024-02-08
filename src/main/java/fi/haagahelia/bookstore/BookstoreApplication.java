package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			Book book1 = new Book("The Hidden Secrets", "Jane Doe", 2023, "978-1-234567-89-0", 12.99);
			Book book2 = new Book("Echoes of Destiny", "John Smith", 2021, "978-0-987654-32-1", 15.49);
			bookRepository.save(book1);
			bookRepository.save(book2);
		};

	}

}
