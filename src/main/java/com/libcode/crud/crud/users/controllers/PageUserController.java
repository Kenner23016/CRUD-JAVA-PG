package com.libcode.crud.crud.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libcode.crud.crud.users.entities.User;
import com.libcode.crud.crud.users.repository.UserRepository;


@Controller
@RequestMapping("/")
public class PageUserController {

    
    @Autowired
    private UserRepository userrepository;


    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("users", userrepository.findAll());
        return "list-users";
    }

    @GetMapping("/nuevo")
    public String formularioNuevoUser(Model model)
    {
        model.addAttribute("usuario", new User());

        return "form-user";
    }

    @PostMapping("/nuevo")
    public String guardarUser(@ModelAttribute User user)
    {
        userrepository.save(user);

        return "redirect:/users";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarUser(Model model, @PathVariable Long id)
    {
        User usuario = userrepository.findById(id).get();
        model.addAttribute("usuario", usuario);

        return "form-user";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUser(@PathVariable Long id)
    {
        userrepository.delete(new User(id));

        return "redirect:/users";
    }
    
}
