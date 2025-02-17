package BooksWorld.Models.DTO;

public class BookDetailsDTO {

    private Long id;

    private String bookName;
    private String author;
    private String imageUrl;

    private String genre;

    private boolean isOnLoad;

    public BookDetailsDTO(){}

    public BookDetailsDTO(Long id, String bookName, String author, String imageUrl, String genre, boolean isOnLoad) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.imageUrl = imageUrl;
        this.genre = genre;
        this.isOnLoad = isOnLoad;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isOnLoad() {
        return isOnLoad;
    }
}
