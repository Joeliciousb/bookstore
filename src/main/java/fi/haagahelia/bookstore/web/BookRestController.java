package fi.haagahelia.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = { "/books" }, method = RequestMethod.GET)
    public @ResponseBody List<Book> getBooklist() {
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value = { "/books/{id}" }, method = RequestMethod.GET)
    public @ResponseBody Optional<Book> getBookById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id);
    }

}
