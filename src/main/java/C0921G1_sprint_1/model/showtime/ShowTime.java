package C0921G1_sprint_1.model.showtime;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.model.seat.Seat;
import C0921G1_sprint_1.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "showTime")
    @JsonBackReference(value = "showtime_screens")
    private Set<Screen> screens;

    @ManyToOne(targetEntity = Film.class)
    private Film film;

    @OneToMany(mappedBy = "showTime")
    @JsonBackReference(value = "showtime_transaction")
    private List<Transaction> transactions;

    public ShowTime() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Screen> getScreens() {
        return screens;
    }

    public void setScreens(Set<Screen> screens) {
        this.screens = screens;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
