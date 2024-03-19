package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
import fi.haagahelia.bookstore.domain.User;
import fi.haagahelia.bookstore.domain.UserRepository;

@DataJpaTest
public class RepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addBookToDatabase() {
        Book book = new Book("title", "author", 2023, "ISBN", 10.00, null);
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void findBookById_ShouldReturnBook() {
        Optional<Book> book = bookRepository.findById(1);
        assertThat(book).isNotNull();
    }

    @Test
    public void findBookByTitle_ShouldReturnListOfBooks() {
        String title = "Echoes of Destiny";
        List<Book> books = bookRepository.findByTitle(title);
        assertThat(books).isNotNull();

        Book bookAtFirstIndex = books.get(0);
        assertThat(bookAtFirstIndex.getTitle()).isEqualTo(title);
    }

    @Test
    public void deleteBookFromDatabase() {
        Book book = new Book("title", "author", 2023, "ISBN", 10.00, null);
        bookRepository.save(book);
        Integer bookId = book.getId();
        bookRepository.deleteById(bookId);

        Optional<Book> deletedBook = bookRepository.findById(bookId);
        assertThat(deletedBook).isEmpty();
    }

    @Test
    public void addCategoryToDatabase() {
        Category category = new Category("category");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void findCategoryById_ShouldReturnCategory() {
        Optional<Category> category = categoryRepository.findById(1);
        assertThat(category).isNotEmpty();
    }

    @Test
    public void findCategoryByName_ShouldReturnCategory() {
        String categoryName = "Scifi";
        List<Category> categories = categoryRepository.findByName(categoryName);
        assertThat(categories).isNotNull();

        Category categoryAtFirstIndex = categories.get(0);
        assertThat(categoryAtFirstIndex.getName()).isEqualTo(categoryName);
    }

    @Test
    public void deleteCategoryFromDatabase() {
        Category category = new Category("category");
        categoryRepository.save(category);
        Integer categoryId = category.getCategoryId();
        categoryRepository.deleteById(categoryId);

        Optional<Category> deletedCategory = categoryRepository.findById(categoryId);
        assertThat(deletedCategory).isEmpty();
    }

    @Test
    public void addUserToDatabase() {
        User user = new User("testUser", "hash", "user");
        userRepository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void findUserByUserId_ShouldReturnUser() {
        Optional<User> user = userRepository.findById((long) 1);
        assertThat(user).isNotEmpty();
    }

    @Test
    public void findUserByUsername_ShouldReturnUser() {
        String username = "user";
        User user = userRepository.findByUsername(username);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(username);
    }

    @Test
    public void deleteUserFromDatabase() {
        User user = new User("testUser", "hash", "user");
        userRepository.save(user);
        Long userId = user.getId();
        userRepository.deleteById(userId);

        Optional<User> deletedUser = userRepository.findById(userId);
        assertThat(deletedUser).isEmpty();
    }
}
