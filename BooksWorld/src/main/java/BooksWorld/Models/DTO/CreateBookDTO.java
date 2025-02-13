package BooksWorld.Models.DTO;

import jakarta.validation.constraints.NotBlank;

public class CreateBookDTO {

    @NotBlank
    private String bookName;
    @NotBlank
    private String author;
    @NotBlank
    private String imageUrl;
    @NotBlank
    private String genre;

    public CreateBookDTO(){}



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
