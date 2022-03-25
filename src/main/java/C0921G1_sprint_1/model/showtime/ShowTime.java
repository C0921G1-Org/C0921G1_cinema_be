package C0921G1_sprint_1.model.showtime;

import C0921G1_sprint_1.model.film.Film;
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
    @ManyToOne(targetEntity = Screen.class)
    private Screen screen;

    @ManyToOne(targetEntity = Film.class)
    private Film film;




    @OneToMany(mappedBy = "showTime")
    @JsonBackReference(value = "showtime_transaction")
<<<<<<< HEAD
    private List<Transaction> transaction;
=======
    private List<Transaction> transactions;
>>>>>>> e8c561bfe9ce73e36cd09a0f6e94a89a43cbfbac

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

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

<<<<<<< HEAD
    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
=======
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
>>>>>>> e8c561bfe9ce73e36cd09a0f6e94a89a43cbfbac
    }
}
