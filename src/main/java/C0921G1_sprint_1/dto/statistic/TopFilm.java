package C0921G1_sprint_1.dto.statistic;

public class TopFilm {
    Integer id;
    Integer totalTicket;
    Double totalMoney;

    public TopFilm() {
    }

    public TopFilm(Integer id, Integer totalTicket, Double totalMoney) {
        this.id = id;
        this.totalTicket = totalTicket;
        this.totalMoney = totalMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(Integer totalTicket) {
        this.totalTicket = totalTicket;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
