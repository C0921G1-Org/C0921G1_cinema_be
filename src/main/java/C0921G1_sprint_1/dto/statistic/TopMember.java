package C0921G1_sprint_1.dto.statistic;

public class TopMember {
    String id;
    String name;
    Integer totalTicket;
    Double totalMoney;
    Double point;

    public TopMember() {
    }

    public TopMember(String id, String name, Integer totalTicket, Double totalMoney, Double point) {
        this.id = id;
        this.name = name;
        this.totalTicket = totalTicket;
        this.totalMoney = totalMoney;
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
}
