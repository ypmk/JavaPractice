package sinforge.practice21.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sinforge.practice21.Entities.Building;

@Repository
public interface BuildingRepo extends JpaRepository<Building, Integer> {
    Building findByCreationDateAndType(String CreationDate, String Type);

}
