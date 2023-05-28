package sinforge.practice19.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice19.Entities.Building;

@Repository
public interface BuildingRepo extends JpaRepository<Building, Integer> {
    Building findByCreationDateAndType(String CreationDate, String Type);

}
