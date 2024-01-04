package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
        return "books/add";
    }
    @PostMapping("/add")
    public String addForm(@Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "books/add";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        if(bookService.findBook(id).isPresent()){
            model.addAttribute("book", bookService.findBook(id));
            return "books/edit";
        }
        return "redirect:/admin/books/all";
    }
    @PostMapping("/edit/{id}")
    public String editForm(@Valid Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "books/edit";
        }
        bookService.update(book);
        return "redirect:/admin/books/all";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if(bookService.findBook(id).isPresent()){
            bookService.delete(id);
        }
        return "redirect:/admin/books/all";
    }
    @RequestMapping("/show/{id}")
    public String show(@PathVariable Long id, Model model) {
        if(bookService.findBook(id).isPresent()){
            model.addAttribute("book", bookService.findBook(id).get());
            return "books/show";
        }
        return "redirect:/admin/books/all";
    }
}
