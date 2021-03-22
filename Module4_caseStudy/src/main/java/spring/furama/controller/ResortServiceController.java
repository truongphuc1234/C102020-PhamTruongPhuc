package spring.furama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.furama.model.service.RentType;
import spring.furama.model.service.ResortService;
import spring.furama.model.service.ServiceType;
import spring.furama.service.RentTypeService;
import spring.furama.service.ResortServiceService;
import spring.furama.service.ServiceTypeService;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ResortServiceController {

    private final ResortServiceService service;
    private final ServiceTypeService serviceTypeService;
    private final RentTypeService rentTypeService;

    @Autowired
    public ResortServiceController(ResortServiceService service, ServiceTypeService serviceTypeService, RentTypeService rentTypeService) {
        this.service = service;
        this.serviceTypeService = serviceTypeService;
        this.rentTypeService = rentTypeService;
    }

    @GetMapping
    public String serviceIndex(Model model, @RequestParam(value = "page", defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("serviceList", service.findAll(pageable));
        return "service/index";
    }

    @GetMapping("/create_service_type")
    public String createServiceType(Model model){
        model.addAttribute("serviceType", new ServiceType());
        return "service/service_type/create";
    }

    @PostMapping("/create_service_type")
    public String createServiceType(@ModelAttribute("serviceType") ServiceType serviceType){
        serviceTypeService.save(serviceType);
        return "redirect:/service";
    }

    @PostMapping("/create_rent_type")
    public String createRentType(@ModelAttribute("rentType") RentType rentType){
        rentTypeService.save(rentType);
        return "redirect:/service";
    }

    @GetMapping("/create_rent_type")
    public String createRentType(Model model){
        model.addAttribute("rentType", new RentType());
        return "service/rent_type/create";
    }

    @GetMapping("/create")
    public String createService(Model model){
        model.addAttribute("resortService", new ResortService());
        return "service/create";
    }

    @PostMapping("/create")
    public String createService(@Valid @ModelAttribute("resortService") ResortService resortService, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "service/create";
        }
        service.save(resortService);
        return "redirect:/service";
    }

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes(){
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes(){
        return rentTypeService.findAll();
    }

    @GetMapping("/edit/{id}")
    public String modifyCustomer( @PathVariable("id") String serviceId, Model model){
        model.addAttribute("resortService", service.findById(serviceId));
        return "service/edit";
    }

    @PostMapping("/edit")
    public String modifyCustomer(@Valid @ModelAttribute("resortService") ResortService resortService){
        service.save(resortService);
        return "redirect:/service/";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("id") String serviceId){
        service.delete(serviceId);
        return "redirect:/service";
    }
}
