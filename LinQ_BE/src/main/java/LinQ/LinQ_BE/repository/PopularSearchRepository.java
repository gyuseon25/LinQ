package LinQ.LinQ_BE.repository;

import LinQ.LinQ_BE.entity.PopularSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularSearchRepository extends JpaRepository<PopularSearchEntity,String> {
}
