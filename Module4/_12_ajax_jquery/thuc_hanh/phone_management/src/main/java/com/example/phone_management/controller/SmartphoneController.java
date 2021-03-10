package com.example.phone_management.controller;

import com.example.phone_management.model.Smartphone;
import com.example.phone_management.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/smartphones")
public class SmartphoneController {

    private SmartphoneService smartphoneService;

    @Autowired
    public SmartphoneController(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("phones/create");
        modelAndView.addObject("smartphone", new Smartphone());
        return modelAndView;
    }

    @RequestMapping(value = "/createNew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.save(smartphone);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Smartphone> allPhones() {
        return smartphoneService.findAll();
    }

    @RequestMapping("")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("/phones/all-phones");
        modelAndView.addObject("allphones",allPhones());
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone deleteSmartphone(@PathVariable Integer id){
        return smartphoneService.remove(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editSmartphonePage(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("phones/edit-phone");
        Smartphone smartphone = smartphoneService.findById(id);
        mav.addObject("sPhone", smartphone);
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone editSmartphone(@PathVariable int id, @RequestBody Smartphone smartphone) {
        smartphone.setId(id);
        return smartphoneService.save(smartphone);
    }
}
