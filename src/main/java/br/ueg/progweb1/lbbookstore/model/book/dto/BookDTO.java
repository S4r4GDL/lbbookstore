package br.ueg.progweb1.lbbookstore.model.book.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public record BookDTO(
        Long id,
        String title,
        String author,
        String publisher,
        String edition,
        Integer releaseYear,
        BigDecimal price,
        Integer quantity,
        LocalDate lastUpdate,
        Boolean active
)
{}