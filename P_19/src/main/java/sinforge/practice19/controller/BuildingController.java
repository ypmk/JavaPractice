package sinforge.practice19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sinforge.practice19.Services.BuildingService;

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
    public String delete(@RequestParam Integer id) {
        buildingService.delete(id);
        return "successful deleted";


    }

    @GetMapping(value="/all")
    public String all(Model model) {
        model.addAttribute("DataType", "Buildings");
        model.addAttribute("Data", buildingService.getAll());
        model.addAttribute("DataColumns", new String[]{"CreationDate", "Type"});
        return "dataBuilding";

    }

    @GetMapping(value="/all/{sort_field}")
    public String sortedAll(Model model, @PathVariable String sort_field) {
        model.addAttribute("DataType", "Buildings");
        model.addAttribute("DataColumns", new String[]{"CreationDate", "Type"});
        if(sort_field.equals("creation_date")) {
            model.addAttribute("Data", buildingService.sortByCreationDate());
        }
        else if  (sort_field.equals("type")) {
            model.addAttribute("Data", buildingService.sortByType());

        }
        else {
            model.addAttribute("Data", buildingService.getAll());

        }
        return "dataBuilding";




    }
}
