package sinforge.practice18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sinforge.practice18.Services.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@RequestParam String addressText, @RequestParam String zipCode, @RequestParam int buildingId) {

        addressService.add(addressText, zipCode, buildingId);
        return "successful add";
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {

        addressService.delete(id);
        return "successful delete";

    }

    @GetMapping(value="/all")
    public String all(Model model) {

        model.addAttribute("DataType", "Addresses");
        model.addAttribute("Data", addressService.getAll());
        model.addAttribute("DataColumns", new String[]{"AddressText", "ZipCode"});
        return "dataAddress";

    }
    @GetMapping(value="/all/{sort_field}")
    public String sortedAll(Model model, @PathVariable String sort_field) {
        if(sort_field.equals("address_text")) {
            model.addAttribute("Data", addressService.sortByAddressText());
        }
        else if  (sort_field.equals("zip_code")) {
            model.addAttribute("Data", addressService.sortByZipCode());

        }
        else {
            model.addAttribute("Data", addressService.getAll());

        }
        return "dataAddress";




    }





}
