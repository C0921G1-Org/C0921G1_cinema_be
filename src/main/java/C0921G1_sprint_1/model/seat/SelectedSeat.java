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
<<<<<<< HEAD
    private Integer position;
=======
    private String bookingDate;
    private Integer seatPosition;
>>>>>>> 63f908bd3561a51482101c4a356e59d35354aa6b
    private Integer status;
    private String orderedDate;

    @ManyToOne(targetEntity = SeatType.class)
    private SeatType seatType;

    @ManyToOne(targetEntity = ShowTime.class)
    private ShowTime showTime;

<<<<<<< HEAD

=======
>>>>>>> 63f908bd3561a51482101c4a356e59d35354aa6b
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

<<<<<<< HEAD

=======
    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getSeatPosition() {
        return seatPosition;
    }

    public void setSeatPosition(Integer seatPosition) {
        this.seatPosition = seatPosition;
    }
>>>>>>> 63f908bd3561a51482101c4a356e59d35354aa6b
}
