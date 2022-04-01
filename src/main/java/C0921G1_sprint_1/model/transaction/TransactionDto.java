package C0921G1_sprint_1.model.transaction;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.dto.showtime.ShowTimeDTO;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.showtime.ShowTime;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

public class TransactionDto {
    private Integer id;

    @NotBlank
    @Pattern(regexp = "(BV-)[0-9]{3}$")
    private String code;
    @NotBlank
    private String transactionalDate;
    @NotBlank
    private String ticketStatus;

    @NotNull
    private MemberDTO memberDTO;

    @NotNull
    private ShowTimeDTO showTimeDTO;

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

    public ShowTimeDTO getShowTimeDTO() {
        return showTimeDTO;
    }

    public void setShowTimeDTO(ShowTimeDTO showTimeDTO) {
        this.showTimeDTO = showTimeDTO;
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
