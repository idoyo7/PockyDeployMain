package pockyProject.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pockyProject.server.entity.LikeMenuEntity;
@Repository
public interface LikeMenuRepository extends JpaRepository<LikeMenuEntity,Long> {



}
