package ezenweb.model.repository;


import ezenweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberEntityRepository extends JpaRepository< MemberEntity, Integer > {

    Optional<MemberEntity> findByMnameAndMphone(String mname, String mphone);
    Optional<MemberEntity> findByMemailAndMphone(String memail, String mphone);
    MemberEntity findByMemail( String memail );

    // 동일한 이메일이 있을 때 true, 없을 때 false
    boolean existsByMemail( String memail );

    // 조건에 and/or 있을 때 이메일과 이름이 같을 때
    MemberEntity findByMnameAndMemail( String mname, String memail );


}
