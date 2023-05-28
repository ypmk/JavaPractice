package sinforge.practice18.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinforge.practice18.Entities.Building;
import sinforge.practice18.Repo.BuildingRepo;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepo buildingRepo;

    public BuildingService(){}
    public BuildingService(BuildingRepo building) {
        this.buildingRepo = building;
    }

    public void add(String creationDate, String type) {
        buildingRepo.save(new Building(creationDate, type));

    }
    public void delete(Integer id) {
        buildingRepo.deleteById(id);

    }

    public List<Building> getAll() {
        return buildingRepo.findAll();
    }

    public List<Building> sortByCreationDate() {
        return buildingRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getCreationDate().compareTo(p2.getCreationDate())).toList();
    }
    public List<Building> sortByType() {
        return buildingRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getType().compareTo(p2.getType())).toList();
    }
}
