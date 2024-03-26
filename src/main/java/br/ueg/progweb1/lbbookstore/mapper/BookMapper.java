package br.ueg.progweb1.lbbookstore.mapper;

import br.ueg.progweb1.lbbookstore.model.Book;
import br.ueg.progweb1.lbbookstore.model.dto.BookReadDTO;
import br.ueg.progweb1.lbbookstore.model.dto.BookCreateDTO;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toModel(BookCreateDTO bookCreateDTO){
        Book book = new Book();
        book.setAuthor(bookCreateDTO.author());
        book.setTitle(bookCreateDTO.title());
        book.setPublisher(bookCreateDTO.publisher());
        book.setEdition(bookCreateDTO.edition());
        book.setReleaseYear(bookCreateDTO.releaseYear());
        book.setPrice(bookCreateDTO.price());
        book.setQuantity(bookCreateDTO.quantity());
        book.setActive(bookCreateDTO.active());
        return book;
    }
    public BookReadDTO toDTO(Book book){
        BookReadDTO bookReadDTO = new BookReadDTO(
                book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getPublisher(),
                book.getEdition(),
                book.getReleaseYear(),
                book.getPrice(),
                book.getQuantity(),
                book.getLastUpdate(),
                book.getActive());
        return bookReadDTO;
    }

}
