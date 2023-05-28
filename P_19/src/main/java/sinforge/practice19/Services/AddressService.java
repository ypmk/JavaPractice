package sinforge.practice19.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinforge.practice19.Entities.Address;
import sinforge.practice19.Repo.AddressRepo;
import sinforge.practice19.Repo.BuildingRepo;


import java.util.List;

@Service
@Slf4j
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private BuildingRepo buildingRepo;

    public AddressService(){}

    public AddressService(AddressRepo repo, BuildingRepo buildingRepo) {
        this.addressRepo = repo;
        this.buildingRepo = buildingRepo;
    }

    public void add(String addressText, String zipCode, int buildingId) {
        Address address = new Address();
        address.setBuilding(buildingRepo.findById(buildingId).get());
        address.setZipCode(zipCode);
        address.setAddressText(addressText);
        log.info("Added new address: " + addressText + " " + zipCode);
        addressRepo.save(address);

    }
    public void delete(Integer id) {
        log.info("Address with id:" + id + " was deleted");
        addressRepo.deleteById(id);
    }

    public List<Address> getAll() {
        log.info("Method getAll is called");
        return addressRepo.findAll();
    }
    public List<Address> sortByAddressText() {
        log.info("Method sortByAddressText is called");
        return addressRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getAddressText().compareTo(d2.getAddressText())).toList();
    }
    public List<Address> sortByZipCode() {
        log.info("Method sortByZipCode is called");
        return addressRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getZipCode().compareTo(d2.getZipCode())).toList();
    }



}
