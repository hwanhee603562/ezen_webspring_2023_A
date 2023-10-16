package 과제.과제01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosEntityRepository extends JpaRepository< TodosEntity, Integer > {

}
