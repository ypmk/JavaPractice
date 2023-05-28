package sinforge.practice22.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sinforge.practice22.Entities.Address;
import sinforge.practice22.Entities.Building;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class MySchedulerService {
    @Autowired
    private AddressService addressService;
    @Autowired
    private BuildingService buildingService;
    private final Path addressSrc = Path.of("C:\\Users\\Honor\\OneDrive\\Рабочий стол\\departure.txt");
    private final Path buildingSrc = Path.of("C:\\Users\\Honor\\OneDrive\\Рабочий стол\\postoffice.txt");

    @Scheduled(cron = "0 0/2 * * * ?")
    public void doScheduledTask() throws IOException {
        if(Files.exists(addressSrc)) {
            Files.delete(addressSrc);
        }
        if(Files.exists(buildingSrc)) {
            Files.delete(buildingSrc);
        }
        List<Address> departureList = addressService.getAll();
        List<Building> postOfficeList = buildingService.getAll();

        StringBuilder departuresData = new StringBuilder();
        StringBuilder postofficeData = new StringBuilder();
        for(Address d : departureList) {
            departuresData.append(d.getId()).append(" ").append(d.getAddressText()).append(" ").append(d.getZipCode()).append("\n");
        }
        System.out.println(departuresData);
        for(Building p : postOfficeList) {
            postofficeData.append(p.getId()).append(" ").append(p.getCreationDate()).append(" ").append(p.getType()).append("\n");
        }
        System.out.println(postofficeData);

        FileWriter fileWriter = new FileWriter("C:\\Users\\Honor\\OneDrive\\Рабочий стол\\java_22\\departure.txt");
        fileWriter.write(departuresData.toString());
        fileWriter.close();

        FileWriter fileWriter1 = new FileWriter("C:\\Users\\Honor\\OneDrive\\Рабочий стол\\java_22\\postoffice.txt");
        fileWriter1.write(postofficeData.toString());
        fileWriter1.close();

    }
}
