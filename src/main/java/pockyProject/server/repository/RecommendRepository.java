package pockyProject.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pockyProject.server.entity.RecommendEntity;

@Repository
public interface RecommendRepository extends JpaRepository<RecommendEntity,Long>{
}
