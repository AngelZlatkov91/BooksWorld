package BooksWorld.Models.DTO;

import java.util.List;

public class MyBooks {
    private List<BookDetailsDTO> myBooks;
    private List<BookDetailsDTO> barrowBooks;

    public MyBooks() {
    }

    public void setMyBooks(List<BookDetailsDTO> myBooks) {
        this.myBooks = myBooks;
    }

    public void setBarrowBooks(List<BookDetailsDTO> barrowBooks) {
        this.barrowBooks = barrowBooks;
    }

    public List<BookDetailsDTO> getMyBooks() {
        return myBooks;
    }

    public List<BookDetailsDTO> getBarrowBooks() {
        return barrowBooks;
    }
}
