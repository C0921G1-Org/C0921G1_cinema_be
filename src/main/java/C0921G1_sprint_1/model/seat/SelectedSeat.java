package C0921G1_sprint_1.model.seat;

import C0921G1_sprint_1.model.showtime.Screen;
import C0921G1_sprint_1.model.showtime.ShowTime;
import C0921G1_sprint_1.model.transaction.Transaction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class SelectedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer position;
    private Integer status;
    private String orderedDate;

    @ManyToOne(targetEntity = SeatType.class)
    private SeatType seatType;

    @ManyToOne(targetEntity = ShowTime.class)
    private ShowTime showTime;


    public SelectedSeat() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
