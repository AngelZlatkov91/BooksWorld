package BooksWorld.Models.Entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    @Size(min = 3,max = 20)
    private String fullName;

    @Column(nullable = false)
    private String password;

    @OneToMany
    private List<Book> myBooks;
    @OneToMany
    private List<Book> onLoanBooks;

    public User() {
        this.myBooks = new ArrayList<>();
        this.onLoanBooks = new ArrayList<>();
    }

    public User (String email, String fullName, String password){
        this.email = email;
        this.fullName = fullName;
        this.password = password;

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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
