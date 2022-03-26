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
    @JsonBackReference
    private List<SelectedSeat> selectedSeats;

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

    public List<SelectedSeat> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<SelectedSeat> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }
}
