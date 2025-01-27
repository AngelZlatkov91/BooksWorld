package BooksWorld.Models.Entitys;

public class Book extends BaseEntity {
    private String author;

    private String bookName;

    private String genre;
    private boolean isOnLoad;

    private User isOwner;

    private User onLoadUser;

    public Book (){
        this.isOnLoad = false;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isOnLoad() {
        return isOnLoad;
    }

    public void setOnLoad(boolean onLoad) {
        isOnLoad = onLoad;
    }

    public User getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(User isOwner) {
        this.isOwner = isOwner;
    }

    public User getOnLoadUser() {
        return onLoadUser;
    }

    public void setOnLoadUser(User onLoadUser) {
        this.onLoadUser = onLoadUser;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
