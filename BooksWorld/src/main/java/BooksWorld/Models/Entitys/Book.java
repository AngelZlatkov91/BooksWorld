package BooksWorld.Models.Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private boolean isOnLoad;

    @ManyToOne
    private User isOwner;
    @ManyToOne
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
