package spring.controller;

/**
 * Java Prof. Homework #35
 *
 * @author Dzmitry Kryvialeu
 * @version 16.03 - 20.03
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.domain.Person;
import spring.service.PersonService;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("person") Person person) {
        personService.add(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable final Integer id) {
        personService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("person") Person person) {
        personService.update(person);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        Person person = personService.getPersonById(id);
        model.addAttribute("person", person);
        return "update";
    }
}
