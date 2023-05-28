package sinforge.practice17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sinforge.practice17.Services.AddressService;

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
    public String delete(@RequestParam String addressText, @RequestParam String zipCode) {

        addressService.delete(addressText, zipCode);
        return "successful delete";

    }

    @GetMapping(value="/all")
    public String all(Model model) {

        model.addAttribute("DataType", "Addresses");
        model.addAttribute("Data", addressService.getAll());
        model.addAttribute("DataColumns", new String[]{"AddressText", "ZipCode"});
        return "dataAddresses";

    }
    @GetMapping(value="/all/{sort_field}/{value}")
    public String sortedAll(Model model, @PathVariable String sort_field, @PathVariable String value) {
        if(sort_field.equals("address_text")) {
            model.addAttribute("Data", addressService.filterByAddressText(value));
        }
        else if  (sort_field.equals("zip_code")) {
            model.addAttribute("Data", addressService.filterByZipCode(value));

        }
        else {
            model.addAttribute("Data", addressService.getAll());

        }
        return "dataAddresses";




    }





}
