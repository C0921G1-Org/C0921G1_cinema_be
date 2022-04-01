package C0921G1_sprint_1.model.showtime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "screen")
    @JsonBackReference(value = "showtime_screens")
    private List<ShowTime> showTime;

    public List<ShowTime> getShowTime() {
        return showTime;
    }

    public void setShowTime(List<ShowTime> showTime) {
        this.showTime = showTime;
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
}
