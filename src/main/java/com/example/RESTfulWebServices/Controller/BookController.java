package com.example.RESTfulWebServices.Controller;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> bookList = new ArrayList<>();

    // GET method to retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookList;
    }

    // POST method to add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        bookList.add(book);
        return book;
    }

    // GET method to retrieve a book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }
}
