package ezenweb.model.repository;

import ezenweb.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity, Integer> {

    // 추상메소드 이용한 엔티티 검색
    // 기본 제공하는 함수 find delete save
    // 1. 해당하는 제목의 엔티티 찾기
    BoardEntity findByBtitle( String btitle );
    //Optional<BoardEntity> findByBtitle( String btitle );
    boolean existsByBtitle( String btitle );
    //List<BoardEntity> findByAllBtitle( String btitle, Pageable pageable  );

    // +페이징 처리
    Page< BoardEntity > findByBtitle( String btitle, Pageable pageable );
    // + mysql 실제 SQL 작성하기 @Query
        // @Query( value = "SQL작성", nativeQuery = true )
    @Query( value = "select * from board where btitle like %:keyword%",

            nativeQuery = true )
    Page< BoardEntity > findBySearch( String key, String keyword, Pageable pageable );


}
