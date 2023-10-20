package ezenweb.model.repository;


import ezenweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberEntityRepository extends JpaRepository< MemberEntity, Integer > {

    Optional<MemberEntity> findByMemailAndMpassword(String memail, String mpassword);
    Optional<MemberEntity> findByMnameAndMphone(String mname, String mphone);
    Optional<MemberEntity> findByMemailAndMphone(String memail, String mphone);

}
