package BooksWorld.Models.Entitys;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseEntity{
    private String email;
    private String fullName;
    private List<Book> myBooks;

    private List<Book> onLoanBooks;


    public User (){
        this.myBooks = new ArrayList<>();
        this.onLoanBooks = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Book> getMyBooks() {
        return myBooks;
    }

    public List<Book> getOnLoanBooks() {
        return onLoanBooks;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
