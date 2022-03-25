package C0921G1_sprint_1.model.seat;

import C0921G1_sprint_1.model.showtime.ShowTime;
import C0921G1_sprint_1.model.transaction.Transaction;

import javax.persistence.*;

@Entity
@Table
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer status;

    @ManyToOne(targetEntity = SeatType.class)
    private SeatType seatType;

    @ManyToOne(targetEntity = Transaction.class)
    private Transaction transaction;

    public Seat() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
