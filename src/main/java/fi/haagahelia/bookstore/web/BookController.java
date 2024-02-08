package fi.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.bookstore.domain.BookRepository;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping(value = { "*", "/booklist" })
    public String getBooks(Model model) {
        model.addAttribute("listOfBooks", bookRepository.findAll());
        return "booklist";
    }

}
