package spring.furama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.furama.model.employee.*;
import spring.furama.service.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DivisionService divisionService;
    private final PositionService positionService;
    private final AppUserService appUserService;
    private final EducationDegreeService educationDegreeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, DivisionService divisionService, PositionService positionService, AppUserService appUserService, EducationDegreeService educationDegreeService) {
        this.employeeService = employeeService;
        this.divisionService = divisionService;
        this.positionService = positionService;
        this.appUserService = appUserService;
        this.educationDegreeService = educationDegreeService;
    }

    @ModelAttribute("divisionList")
    public Iterable<Division> divisionList() {
        return divisionService.findAll();
    }

    @ModelAttribute("positionList")
    public Iterable<Position> positionList() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public Iterable<EducationDegree> educationDegreeList() {
        return educationDegreeService.findAll();
    }

    @GetMapping
    public String employeeIndex(Model model,
                                @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("employeeList", employeeService.findAll(pageable));
        return "/employee/index";
    }

    @GetMapping("/create")
    public String createNewEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String createNewEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/create";
        }
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/create_division")
    public String createNewDivision(Model model) {
        model.addAttribute("division", new Division());
        return "/employee/division/create";
    }

    @PostMapping("/create_division")
    public String createNewDivision(@ModelAttribute("division") Division division) {
        divisionService.save(division);
        return "redirect:/employee";
    }

    @GetMapping("/create_position")
    public String createNewPosition(Model model) {
        model.addAttribute("position", new Position());
        return "/employee/position/create";
    }

    @PostMapping("/create_position")
    public String createNewPosition(@ModelAttribute("position") Position position) {
        positionService.save(position);
        return "redirect:/employee";
    }

    @GetMapping("/create_role")
    public String createNewRole(Model model) {
        model.addAttribute("role", new AppRole());
        return "/employee/create_role";
    }

    @PostMapping("/create_role")
    public String createNewRole(@ModelAttribute("role") AppRole appRole) {
        appUserService.save(appRole);
        return "redirect:/employee";
    }

    @GetMapping("/create_education_degree")
    public String createNewEducationDegree(Model model) {
        model.addAttribute("education_degree", new EducationDegree());
        return "/employee/education_degree/create";
    }

    @PostMapping("/create_education_degree")
    public String createNewEducationDegree(@ModelAttribute("education_degree") EducationDegree educationDegree) {
        educationDegreeService.save(educationDegree);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String modifyEmployee(@PathVariable("id") int employeeId, Model model) {
        model.addAttribute("employee", employeeService.findById(employeeId));
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String modifyCustomer(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/edit";
        }
        employeeService.update(employee);
        return "redirect:/employee/";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employee";
    }

    @GetMapping("/create_user")
    public String createNewUser(Model model) {
        model.addAttribute("user", new AppUser());
        model.addAttribute("roleList", appUserService.findAllRole());
        model.addAttribute("employeeList", employeeService.findAll());
        return "/employee/user";
    }

    @PostMapping("/create_user")
    public String createNewUser(@Valid @ModelAttribute("user") AppUser appUser, BindingResult bindingResult, @RequestParam("roles") int[] roleIds, @RequestParam("employeeId") int employeeId) {
        if (bindingResult.hasErrors()) {
            return "employee/user";
        }
        appUserService.save(appUser);
        Employee employee = employeeService.findById(employeeId);
        employee.setAppUser(appUser);
        employeeService.save(employee);
        for (int roleId : roleIds) {
            AppRole appRole = appUserService.findRoleById(roleId);
            appUserService.saveUserRole(appUser, appRole);
        }
        return "redirect:/employee";
    }

}
