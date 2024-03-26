package br.ueg.progweb1.lbbookstore.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BookCreateDTO(String title,
                            String author,
                            String publisher,
                            String edition,
                            Integer releaseYear,
                            BigDecimal price,
                            Integer quantity,
                            Boolean active)
{}