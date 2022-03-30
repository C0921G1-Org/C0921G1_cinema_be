package C0921G1_sprint_1.member_management;

import C0921G1_sprint_1.controller.member_management.MemberController;
import C0921G1_sprint_1.model.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class Controller_listMember {

    @Autowired
    private MemberController memberController;

    //test case with page param = null - KhanhLDQ
    @Test
    public void getListMember_1() {
        ResponseEntity<Page<Member>> responseEntity =
                this.memberController.getAllMembersWithPagination(null);

        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    //test case with page param = 10 (not existed) - KhanhLDQ
    @Test
    public void getListMember_3() {
        ResponseEntity<Page<Member>> responseEntity =
                this.memberController.getAllMembersWithPagination(10);

        Assertions.assertEquals(204,responseEntity.getStatusCodeValue());
    }

    //test case with page param = 1 (existed) - KhanhLDQ
    @Test
    public void getListMember_4() {
        ResponseEntity<Page<Member>> responseEntity =
                this.memberController.getAllMembersWithPagination(1);

        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
    }

    //test case with size = 0 - KhanhLDQ
    @Test
    public void getListMember_5() {
        ResponseEntity<Page<Member>> responseEntity
                = this.memberController.getAllMembersWithPagination(0);

        Assertions.assertEquals(204,responseEntity.getStatusCodeValue());
    }

    //test case with size > 0 - KhanhLDQ
    @Test
    public void getListMember_6() {
        ResponseEntity<Page<Member>> responseEntity
                = this.memberController.getAllMembersWithPagination(0);

        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(5,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(23,responseEntity.getBody().getTotalElements());

        Assertions.assertEquals("Mem-005",
                responseEntity.getBody().getContent().get(4).getId());

        Assertions.assertEquals("Phu Quoc",
                responseEntity.getBody().getContent().get(4).getAddress());

        Assertions.assertEquals("1995-09-02",
                responseEntity.getBody().getContent().get(4).getDateOfBirth());

        Assertions.assertEquals("nguyenE@gmail.com",
                responseEntity.getBody().getContent().get(4).getEmail());

        Assertions.assertEquals(1,
                responseEntity.getBody().getContent().get(4).getGender());

        Assertions.assertEquals("123765678",
                responseEntity.getBody().getContent().get(4).getIdentityNumber());

        Assertions.assertEquals("",
                responseEntity.getBody().getContent().get(4).getImage());

        Assertions.assertEquals("Nguyen E",
                responseEntity.getBody().getContent().get(4).getName());

        Assertions.assertEquals("908796786",
                responseEntity.getBody().getContent().get(4).getPhone());

        Assertions.assertEquals(1800,
                responseEntity.getBody().getContent().get(4).getPoint());

        Assertions.assertEquals(6,
                responseEntity.getBody().getContent().get(4).getCity().getId());
    }
}
