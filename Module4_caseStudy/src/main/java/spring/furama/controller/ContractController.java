package spring.furama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.furama.model.contract.AttachService;
import spring.furama.model.contract.Contract;
import spring.furama.model.contract.ContractDetail;
import spring.furama.model.customer.Customer;
import spring.furama.model.employee.Employee;
import spring.furama.model.service.ResortService;
import spring.furama.service.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

    private final ContractService contractService;
    private final AttachServiceService attachServiceService;
    private final ContractDetailService contractDetailService;
    private final ResortServiceService resortServiceService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;

    @Autowired
    public ContractController(ContractService contractService, AttachServiceService attachServiceService, ContractDetailService contractDetailService, ResortServiceService resortServiceService, CustomerService customerService, EmployeeService employeeService) {
        this.contractService = contractService;
        this.attachServiceService = attachServiceService;
        this.contractDetailService = contractDetailService;
        this.resortServiceService = resortServiceService;
        this.customerService = customerService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String contractIndex(Model model,
                                @RequestParam(value = "page", defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("contractList", contractService.findAll(pageable));
        return "contract/index";
    }

    @GetMapping("/create")
    public String createNewContract(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping("/create")
    public String createNewContract(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contract/create";
        }
        contract.calculateTotalMoney();
        contractService.save(contract);
        return "redirect:/contract";
    }

    @GetMapping("/create_attach_service")
    public String createNewAttachService(Model model) {
        model.addAttribute("attachService", new AttachService());
        return "contract/attach_service/create";
    }

    @PostMapping("/create_attach_service")
    public String createNewAttachService(@ModelAttribute("attachService") AttachService attachService) {
        attachServiceService.save(attachService);
        return "redirect:/contract";
    }

    @GetMapping("/create_contract_detail")
    public String createNewContractDetail(Model model) {
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contractList", contractService.findAll());
        model.addAttribute("attachServiceList", attachServiceService.findAll());
        return "contract/contract_detail/create";
    }

    @PostMapping("/create_contract_detail")
    public String createNewContractDetail(@ModelAttribute("contract_detail") ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return "redirect:/contract";
    }

    @GetMapping("/edit/{id}")
    public String modifyContract(@PathVariable("id") int contractId, Model model) {
        model.addAttribute("contract", contractService.findById(contractId));
        return "contract/edit";
    }

    @PostMapping("/edit")
    public String modifyContract(@Valid @ModelAttribute("contract") Contract contract, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contract/edit";
        }
        contract.calculateTotalMoney();
        contractService.update(contract);
        return "redirect:/contract/";
    }

    @PostMapping("/delete")
    public String deleteContract(@RequestParam("id") int contractId) {
        contractService.deleteById(contractId);
        return "redirect:/contract";
    }

    @ModelAttribute("employeeList")
    public Iterable<Employee> employeeList() {
        return employeeService.findAll();
    }

    @ModelAttribute("customerList")
    public Iterable<Customer> customerList() {
        return customerService.findAll();
    }

    @ModelAttribute("serviceList")
    public Iterable<ResortService> serviceList() {
        return resortServiceService.findAll();
    }

}
