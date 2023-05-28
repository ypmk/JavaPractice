package sinforge.practice14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sinforge.practice14.Entities.Address;

import java.util.ArrayList;

@Controller
@RequestMapping("/address")
public class AddressController {
    private ArrayList<Address> addresses = new ArrayList<>();

    @GetMapping(value = "/add")
    @ResponseBody
    public String add(@RequestParam String addressText, @RequestParam String zipCode) {
        addresses.add(new Address(addressText, zipCode));
        return "successful added";
    }

    @GetMapping(value = "/delete")
    @ResponseBody
    public String delete(@RequestParam String addressText, @RequestParam String zipCode) {


        return addresses.removeIf((d) -> d.getZipCode().equals(zipCode) && d.getAddressText().equals(addressText))
                ?"successful delete"
                : "record not found";

    }

    @GetMapping(value="/all")
    public String all(Model model) {
        model.addAttribute("DataType", "Addresses");
        model.addAttribute("Data", addresses);
        model.addAttribute("DataColums", new String[]{"addressText", "zipCode"});
        return "data";

    }





}
