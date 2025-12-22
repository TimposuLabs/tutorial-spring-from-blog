package com.timposulabs.mvc.crud.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.timposulabs.mvc.crud.dto.PersonDTO;
import com.timposulabs.mvc.crud.service.PersonService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public String listPerson(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<PersonDTO> persons = personService.getAllPersons(pageable);
        model.addAttribute("persons", persons);
        return "person/person-list";
    }

    @GetMapping("/form")
    public String formPerson(Model model) {
        model.addAttribute("person", new PersonDTO());
        return "person/person-form";
    }

    @PostMapping("/save")
	public String saveProduct(
            @Valid @ModelAttribute("person") PersonDTO personDTO,
			BindingResult bindingResult) {
          
    
        System.out.println("Data Person: " + personDTO.toString());
        
        // cek validasi anotasi standard
		if (bindingResult.hasErrors()) {
			return "person/person-form";
		}
        
        // cek validasi email unik
		if (!personService.isEmailUnique(personDTO.getEmail(), personDTO.getId())) {
            bindingResult.rejectValue("email", "error.person", "Email already exist!!!"); // custom validation error
        	return "person/person-form";
		}	

		personService.createPerson(personDTO);
		return "redirect:/person/list";
	}

    @GetMapping("/update")
    public String updatePerson(@RequestParam("id") Long id, Model model) {
        PersonDTO personDTO = personService.getPersonById(id);
        model.addAttribute("person", personDTO);
        return "person/person-form";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam("id") Long id) {
        personService.deletePerson(id);
        return "redirect:/person/list";
    }    
}
