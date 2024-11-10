import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    private final BookOperations bookOperations;

    public LibraryController(BookOperations bookOperations) {
        this.bookOperations = bookOperations;
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) {
        bookOperations.addBook(book.getTitle(), book.getAuthor(), book.getGenre());
        return "Book added successfully!";
    }

    @GetMapping("/getBooks")
    public List<String> getBooks() {
        return bookOperations.getBooks();
    }
}
