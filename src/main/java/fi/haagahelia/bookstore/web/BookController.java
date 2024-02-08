package fi.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = { "*", "/booklist" })
    public String getBooks(Model model) {
        model.addAttribute("listOfBooks", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping(value = { "/addbook" })
    public String getAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping(value = { "/savebook" })
    public String postBook(@ModelAttribute Book book, Model model) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping(value = { "/deletebook/{id}" })
    public String deleteBook(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }
}
