package C0921G1_sprint_1.service.member_account;

import C0921G1_sprint_1.dto.member.MemberDTO;
import C0921G1_sprint_1.dto.member.MemberHistoryDTO;
import C0921G1_sprint_1.model.member.City;
import C0921G1_sprint_1.model.member.District;
import C0921G1_sprint_1.model.member.Member;
import C0921G1_sprint_1.model.member.Ward;
import C0921G1_sprint_1.model.security.Account;
import C0921G1_sprint_1.repository.member_account.MemberAccountRepository;
import C0921G1_sprint_1.repository.member_management.CityRepository;
import C0921G1_sprint_1.repository.member_management.DistrictRepository;
import C0921G1_sprint_1.repository.member_management.WardRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberAccountServiceImpl implements MemberAccountService{

    @Autowired
    private MemberAccountRepository memberAccountRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //    NhanNT get Trading history
    @Override
    public Page<MemberHistoryDTO> findTradingHistory(String id,String name, Pageable pageable) {
        return memberAccountRepository.findTradingHistory(id,name,pageable);
    }
    //    NhanNT create Member
    @Override
    public void createMember(MemberDTO memberObj) {
        Member member = new Member();
//        BeanUtils.copyProperties(memberObj, member, "wardId");
        BeanUtils.copyProperties(memberObj, member,"city");
//        Ward ward = wardRepository.findById(memberObj.getWardId()).orElse(null);
//        member.setWard(ward);//
        City city = cityRepository.findById(memberObj.getCityId()).orElse(null);
        member.setCity(city);
        Account account = new Account();
        String encodedPassword = bCryptPasswordEncoder.encode(memberObj.getPassword());
        account.setEmail(member.getEmail());
        account.setEncryptPw(encodedPassword);
        account.setIsEnabled(1);
        account.setUsername(member.getEmail());
        member.setAccount(account);
        member.setPoint(0.0);
        memberAccountRepository.save(member);
        memberAccountRepository.createAccount(account.getId());
    }


    //    NhanNT get City
    @Override
    public Iterable<City> getListCity() {
        return cityRepository.findAll();
    }
    //    NhanNT get District
    @Override
    public Iterable<District> getListDistrict(int id) {
        return districtRepository.findDistinctByCity_Id(id);
    }
    //    NhanNT get Ward
    @Override
    public Iterable<Ward> getListWard(int id) {
        return wardRepository.findWardByDistrict_Id(id);
    }


}
