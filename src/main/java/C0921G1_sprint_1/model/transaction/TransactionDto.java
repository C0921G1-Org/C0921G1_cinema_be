package C0921G1_sprint_1.model.transaction;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.showtime.ShowTime;
import com.sun.istack.NotNull;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class TransactionDto {
    private Integer id;

    @NotBlank
    @Pattern(regexp = "(BV-)[0-9]{3}$")
    private String code;
    @NotBlank
    private String transactionalDate;
    @NotBlank
    private String ticketStatus;

    private MemberDTO memberDTO;
    private ShowTime showTime;

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

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }
}
