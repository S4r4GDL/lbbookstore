package br.ueg.progweb1.lbbookstore.controller;


import br.ueg.progweb1.lbbookstore.mapper.BookMapper;
import br.ueg.progweb1.lbbookstore.model.dto.BookCreateDTO;
import br.ueg.progweb1.lbbookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${api.version}/book")
public class BookController {
    @Autowired
    BookService service;

    @Autowired
    BookMapper mapper;

    @PostMapping
    @Operation(description = "End point to create a new book")
    public ResponseEntity<Object> createBook(@RequestBody BookCreateDTO bookDTO)
    {
        var response = service.create(mapper.toModel(bookDTO));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @Operation(description = "End point to delete a book")
    public ResponseEntity<Object> deleteBook(@RequestBody BookCreateDTO bookDTO)
    {
        var response = service.delete(mapper.toModel(bookDTO));
        return ResponseEntity.ok(response);
    }


    @GetMapping
    @Operation(description = "End point to list all the books")
    public ResponseEntity<Object> getAllBooks()
    {
        var response = service.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "End point to get a book by id")
    public ResponseEntity<Object> getBookById(@PathVariable Long id)
    {
        var response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/")
    @Operation(description = "End point to get all active books")
    public ResponseEntity<Object> getActiveBooks()
    {
        var response = service.getActiveBooks();
        return ResponseEntity.ok(response);
    }
}
