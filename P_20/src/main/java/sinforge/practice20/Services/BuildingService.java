package sinforge.practice20.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinforge.practice20.Entities.Building;
import sinforge.practice20.Repo.BuildingRepo;

import java.util.List;

@Service
@Slf4j
public class BuildingService {
    @Autowired
    private BuildingRepo buildingRepo;

    public BuildingService(){}
    public BuildingService(BuildingRepo building) {
        this.buildingRepo = building;
    }

    public void add(String creationDate, String type) {
        log.info("Added new building: " + creationDate + " " + type);
        buildingRepo.save(new Building(creationDate, type));

    }
    public void delete(Integer id) {
        log.info("Building with id:" + id + " was deleted");
        buildingRepo.deleteById(id);

    }

    public List<Building> getAll() {
        log.info("Method getAll is called");
        return buildingRepo.findAll();
    }

    public List<Building> sortByCreationDate() {
        log.info("Method sortByCreationDate is called");
        return buildingRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getCreationDate().compareTo(p2.getCreationDate())).toList();
    }
    public List<Building> sortByType() {
        log.info("Method sortByType is called");
        return buildingRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getType().compareTo(p2.getType())).toList();
    }
}
