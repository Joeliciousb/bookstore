package fi.haagahelia.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = { "/categorylist" })
    public String getCategoryList(Model model) {
        model.addAttribute("listOfCategories", categoryRepository.findAll());
        return "categorylist";
    }

    @GetMapping(value = { "/addcategory" })
    public String getAddBook(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping(value = { "/savecategory" })
    public String postMethodName(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }

}
