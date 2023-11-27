package com.interview.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.interview.app.Dtos.CustomerDto;
import com.interview.app.interfaces.ICustomer;
import com.interview.app.models.Customer;
import com.interview.app.services.CustomerService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        CustomerDto customer = new CustomerDto();
        model.addAttribute("customer", customer);

        return "register"; // This corresponds to the registration.html file in templates folder
    }

    @PostMapping("/registration/save")
    public String registration(@Valid @ModelAttribute("customer") CustomerDto customerDto,
            BindingResult result,
            Model model) {
        Customer existingCustomer = customerService.findByEmailAddress(customerDto.getEmailAddress());

        if (existingCustomer != null && existingCustomer.getEmailAddress() != null
                && !existingCustomer.getEmailAddress().isEmpty()) {
            result.rejectValue("emailAddress", null,
                    "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("customer", customerDto);
            return "/register";
        }

        customerService.saveCustomer(customerDto);
        return "redirect:/registration?success";
    }
}
