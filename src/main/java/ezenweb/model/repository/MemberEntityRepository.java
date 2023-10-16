package ezenweb.model.repository;


import ezenweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberEntityRepository extends JpaRepository< MemberEntity, Integer > {

    Optional<MemberEntity> findByMemail(String memail);
    Optional<MemberEntity> findByMpassword(String mpassword);
    Optional<MemberEntity> findByMname(String mname);
    Optional<MemberEntity> findByMphone(String mphone);
    Optional<MemberEntity> findByMnameAndMphone(String mname, String mphone);
    Optional<MemberEntity> findByMemailAndMphone(String memail, String mphone);

}
