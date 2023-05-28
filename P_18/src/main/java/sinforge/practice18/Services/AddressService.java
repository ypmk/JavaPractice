package sinforge.practice18.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinforge.practice18.Entities.Address;
import sinforge.practice18.Repo.AddressRepo;
import sinforge.practice18.Repo.BuildingRepo;


import java.util.List;

@Service
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
        addressRepo.save(address);

    }
    public void delete(Integer id) {
        addressRepo.deleteById(id);
    }

    public List<Address> getAll() {
        return addressRepo.findAll();
    }
    public List<Address> sortByAddressText() {
        return addressRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getAddressText().compareTo(d2.getAddressText())).toList();
    }
    public List<Address> sortByZipCode() {
        return addressRepo.findAll().stream()
                .sorted((d1,d2)-> d1.getZipCode().compareTo(d2.getZipCode())).toList();
    }



}
