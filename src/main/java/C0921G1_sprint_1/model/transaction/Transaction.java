package C0921G1_sprint_1.model.transaction;

import C0921G1_sprint_1.custom_id.StringPrefixedSequenceIdGenerator;
import C0921G1_sprint_1.model.attached_service.AttachedService;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.seat.SelectedSeat;
import C0921G1_sprint_1.model.showtime.ShowTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    @GenericGenerator(
            name = "transaction_seq",
            strategy = "C0921G1_sprint_1.custom_id.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TSC-"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
    @NotBlank(message = "Ko dc trong")
    private String code;

    private String transactionalDate;
    private String ticketStatus;

    @OneToMany(mappedBy = "transaction")
    @JsonBackReference(value = "transaction_attachedService")
    private List<AttachedService> attachedServices;

    @ManyToOne(targetEntity = ShowTime.class)
    private ShowTime showTime;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTransactionalDate() {
        return transactionalDate;
    }

    public void setTransactionalDate(String transactionalDate) {
        this.transactionalDate = transactionalDate;
    }

    public List<AttachedService> getAttachedServices() {
        return attachedServices;
    }

    public void setAttachedServices(List<AttachedService> attachedServices) {
        this.attachedServices = attachedServices;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public Transaction() {
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", transactionalDate='" + transactionalDate + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", attachedServices=" + attachedServices +
                ", showTime=" + showTime +
                ", member=" + member +
                '}';
    }
}
