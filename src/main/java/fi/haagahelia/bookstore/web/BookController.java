package fi.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.CategoryRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = { "*", "/booklist" })
    public String getBooks(Model model) {
        model.addAttribute("listOfBooks", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping(value = { "/addbook" })
    public String getAddBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping(value = { "/savebook" })
    public String postBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping(value = { "/deletebook/{id}" })
    public String deleteBook(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping(value = { "/editbook/{id}" })
    public String editBook(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookRepository.findById(id));
        return "editbook";
    }

    @PostMapping(value = { "/savechanges" })
    public String postSaveChanges(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }
}
