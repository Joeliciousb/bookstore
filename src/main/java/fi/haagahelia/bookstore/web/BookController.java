package fi.haagahelia.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.bookstore.domain.Book;

@Controller
public class BookController {

    @GetMapping(value = { "*", "/index" })
    public String getBooks(Model model) {
        List<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("The Three Musketeers", "Alexander Dumas", 1992, "9781853260407", 8.30));
        model.addAttribute("listOfBooks", listOfBooks);
        return "booklist";
    }

}
