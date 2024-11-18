package pockyProject.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pockyProject.server.entity.UserMenuEntity;

@Repository
public interface UserMenuRepository extends JpaRepository<UserMenuEntity,Long> {



}
