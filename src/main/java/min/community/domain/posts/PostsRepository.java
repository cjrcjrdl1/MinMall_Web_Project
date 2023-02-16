package min.community.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id desc")
    List<Posts> findAllDesc(); //최신순으로 나열하기 위함

    @Modifying
    @Query("update Posts p set p.view = p.view +1 where p.id = :id")
    int updateView(@Param("id") Long id);

}
