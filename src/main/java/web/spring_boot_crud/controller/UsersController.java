package web.spring_boot_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.spring_boot_crud.model.User;
import web.spring_boot_crud.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @RequestMapping("/new")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("userForAdd", user);
        return "user-info";

    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("userForAdd") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/show")
    public String show(@RequestParam("id") int id, Model model){
        model.addAttribute("userForUpdate", userService.getUser(id));
        return "user-show";

    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("id") int id, @ModelAttribute("userForUpdate") User user) {
        userService.updateUser(user);
        return "redirect:/";

    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
