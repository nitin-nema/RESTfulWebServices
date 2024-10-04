package com.example.RESTfulWebServices;

@RestController
@RequestMapping("/api/v1/books")
public class InventoryController {

    private Map<Integer, Book> bookInventory = new HashMap<>();

    @GetMapping
    public Collection<Book> getBooks() {
        return bookInventory.values();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        if(bookInventory.containsKey(book.getId())) {
            throw new RuntimeException("Book already exists");
        }
        bookInventory.put(book.getId(), book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        if (!bookInventory.containsKey(id)) {
            throw new RuntimeException("Book not found");
        }
        bookInventory.put(id, book);
        return book;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        if (!bookInventory.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Book with ID " + id + " not found");
        }
        bookInventory.remove(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}

