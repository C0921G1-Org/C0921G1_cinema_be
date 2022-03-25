package C0921G1_sprint_1.model.seat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class SeatType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @OneToMany(mappedBy = "seatType")
<<<<<<< HEAD
    @JsonBackReference
    private List<Seat> seats;
=======
    @JsonBackReference(value = "seatType_seats")
<<<<<<< HEAD
    private Set<Seat> seats;
>>>>>>> 53319c79bc56c3c500040c5afbf03576751f49ce
=======
    private List<Seat> seats;
>>>>>>> e8c561bfe9ce73e36cd09a0f6e94a89a43cbfbac

    public SeatType() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
