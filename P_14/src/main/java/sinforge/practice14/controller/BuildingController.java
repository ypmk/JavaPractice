package sinforge.practice14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sinforge.practice14.Entities.Building;

import java.util.ArrayList;

@Controller
@RequestMapping("/building")
public class BuildingController {
    private ArrayList<Building> buildings = new ArrayList<>();


    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@RequestParam String creationDate, @RequestParam String type) {
        buildings.add(new Building(creationDate, type));
        return "successful added"  ;
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam String creationDate, @RequestParam String type) {


        return buildings.removeIf((d) -> d.getCreationDate().equals(creationDate) && d.getType().equals(type))
                ?"successful delete"
                : "record not found";

    }

    @GetMapping(value="/all")
    public String all(Model model) {
        model.addAttribute("DataType", "Buildings");
        model.addAttribute("Data", buildings);
        model.addAttribute("DataColums", new String[]{"creationDate", "type"});
        return "data";

    }
}
