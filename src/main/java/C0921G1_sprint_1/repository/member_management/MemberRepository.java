package C0921G1_sprint_1.repository.member_management;

import C0921G1_sprint_1.model.member.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {

    @Query(value = "select * from member", nativeQuery = true)
    Iterable<Member> findAllMembers();

    @Query(value = "select * from member order by id",
            countQuery = "select count(*) from member", nativeQuery = true)
    Page<Member> findAllMembersWithPagination(Pageable pageable);

    @Query(value = "select * from member m where m.id = :id", nativeQuery = true)
    Optional<Member> findMemberById(
            @Param("id") String id
    );

    @Transactional
    @Modifying
//    return type = void / int - Integer
    @Query(value = "update member m set m.name = :name, m.gender = :gender, m.phone = :phone, m.email = :email," +
            " m.address = :address, m.image = :image, m.date_of_birth = :dateOfBirth, m.identity_number = :identityNumber," +
            " m.city_id = :city_id where m.id = :id", nativeQuery = true)
    void updateMember(
            @Param("name") String name,
            @Param("gender") Integer gender,
            @Param("phone") String phone,
            @Param("email") String email,
            @Param("address") String address,
            @Param("image") String image,
            @Param("dateOfBirth") String dateOfBirth,
            @Param("identityNumber") String identityNumber,
            @Param("city_id") Integer city_id,
            @Param("id") String id
    );

}
