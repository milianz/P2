package org.milianz.p2.Domain.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBookDTO {
    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String author;

    @NotBlank
    @NotNull
    private String isbn;

    @NotBlank
    @NotNull
    private Integer publicationYear;

    @NotBlank
    @NotNull
    private String language;

    @NotBlank
    @NotNull
    private Integer pages;

    @NotBlank
    @NotNull
    private String genre;
}
