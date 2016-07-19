package library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MyController {
    static final int DEFAULT_GROUP_ID = -1;

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("genre", bookService.listGenre());
        model.addAttribute("books", bookService.listBooks(null));
        return "index";
    }

    @RequestMapping("/book_add_page")
    public String bookAddPage(Model model) {
        model.addAttribute("genre", bookService.listGenre());
        return "book_add_page";
    }

    @RequestMapping("/genre_add_page")
    public String genreAddPage() {
        return "genre_add_page";
    }

    @RequestMapping("/genre/{id}")
    public String listGenre(@PathVariable(value = "id") long genreId, Model model) {
        Genre genre = (genreId != DEFAULT_GROUP_ID) ? bookService.findGenre(genreId) : null;

        model.addAttribute("genre", bookService.listGenre());
        model.addAttribute("currentGenre", genre);
        model.addAttribute("books", bookService.listBooks(genre));
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam String pattern, Model model) {
        model.addAttribute("genre", bookService.listGenre());
        model.addAttribute("books", bookService.searchBooks(pattern));
        return "index";
    }

    @RequestMapping(value = "/book/delete", method = RequestMethod.POST)
    public String search(@RequestParam(value = "toDelete[]", required = false) long[] toDelete, Model model) {
        if (toDelete != null)
            bookService.deleteBook(toDelete);

        model.addAttribute("genre", bookService.listGenre());
        model.addAttribute("books", bookService.listBooks(null));
        return "index";
    }

    @RequestMapping(value="/book/add", method = RequestMethod.POST)
    public String bookAdd(@RequestParam(value = "genre") long genreId,
                             @RequestParam String name,
                             @RequestParam String writer,
                             @RequestParam String description,
                             Model model)
    {
        Genre genre = (genreId != DEFAULT_GROUP_ID) ? bookService.findGenre(genreId) : null;

        Book book = new Book(genre, name, writer, description);
        bookService.addBook(book);

        model.addAttribute("genre", bookService.listGenre());
        model.addAttribute("books", bookService.listBooks(null));
        return "index";
    }

    @RequestMapping(value="/genre/add", method = RequestMethod.POST)
    public String genreAdd(@RequestParam String name, Model model)
    {
        bookService.addGenre(new Genre(name));

        model.addAttribute("genre", bookService.listGenre());
        model.addAttribute("books", bookService.listBooks(null));
        return "index";
    }
}
