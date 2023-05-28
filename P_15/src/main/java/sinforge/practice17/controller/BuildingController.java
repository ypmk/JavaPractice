package sinforge.practice17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sinforge.practice17.Services.BuildingService;

@Controller
@RequestMapping("/building")
public class BuildingController {

    private BuildingService buildingService;
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@RequestParam String creationDate, @RequestParam String type) {
        buildingService.add(creationDate, type);
        return "successful added"  ;
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam String creationDate, @RequestParam String type) {
        buildingService.delete(creationDate, type);
        return "successful deleted";


    }

    @GetMapping(value="/all")
    public String all(Model model) {
        model.addAttribute("DataType", "Buildings");
        model.addAttribute("Data", buildingService.getAll());
        model.addAttribute("DataColumns", new String[]{"creationDate", "type"});
        return "dataBuildings";

    }

    @GetMapping(value="/all/{sort_field}/{value}")
    public String sortedAll(Model model, @PathVariable String sort_field, @PathVariable String value) {
        model.addAttribute("DataType", "Buildings");
        model.addAttribute("DataColumns", new String[]{"Name", "City"});
        if(sort_field.equals("creation_date")) {
            model.addAttribute("Data", buildingService.filterByCreationDate(value));
        }
        else if  (sort_field.equals("type")) {
            model.addAttribute("Data", buildingService.filterByType(value));

        }
        else {
            model.addAttribute("Data", buildingService.getAll());

        }
        return "dataBuildings";




    }
}
