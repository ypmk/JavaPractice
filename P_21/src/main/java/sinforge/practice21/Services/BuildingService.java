package sinforge.practice21.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinforge.practice21.Entities.Building;
import sinforge.practice21.Repo.BuildingRepo;

import java.util.List;

@Service
@Slf4j
public class BuildingService {
    @Autowired
    private BuildingRepo buildingRepo;
    @Autowired
    private MyEmailService emailService;

    public BuildingService(){}
    public BuildingService(BuildingRepo building) {
        this.buildingRepo = building;
    }

    @Transactional
    public void add(String creationDate, String type) {
        emailService.send("kopylovakseniakipylova@yandex.ru", "Creating Building object", "Building: " +
                creationDate + " " + type + " was created");
        log.info("Added new building: " + creationDate + " " + type);
        buildingRepo.save(new Building(creationDate, type));

    }

    @Transactional
    public void delete(Integer id) {
        log.info("Building with id:" + id + " was deleted");
        buildingRepo.deleteById(id);

    }

    @Transactional(readOnly = true)
    public List<Building> getAll() {
        log.info("Method getAll is called");
        return buildingRepo.findAll();
    }

    @Transactional(readOnly = true)
    public List<Building> sortByCreationDate() {
        log.info("Method sortByCreationDate is called");
        return buildingRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getCreationDate().compareTo(p2.getCreationDate())).toList();
    }

    @Transactional(readOnly = true)
    public List<Building> sortByType() {
        log.info("Method sortByType is called");
        return buildingRepo.findAll().stream()
                .sorted((p1,p2)-> p1.getType().compareTo(p2.getType())).toList();
    }
}
