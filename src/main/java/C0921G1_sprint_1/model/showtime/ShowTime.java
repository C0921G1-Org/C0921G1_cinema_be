package C0921G1_sprint_1.model.showtime;

import C0921G1_sprint_1.model.film.Film;
import C0921G1_sprint_1.model.seat.Seat;
import C0921G1_sprint_1.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "showTime")
    @JsonBackReference
    private Set<Screen> screens;

    @OneToMany(mappedBy = "showTime")
    @JsonBackReference
    private Set<Seat> seats;

    @ManyToOne(targetEntity = Film.class)
    private Film film;

    @OneToOne(mappedBy = "showTime")
    private Transaction transaction;

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

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
