package ru.job4j.VacancyAndCandidate_list.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.VacancyAndCandidate_list.model.Post;
import ru.job4j.VacancyAndCandidate_list.model.User;
import ru.job4j.VacancyAndCandidate_list.service.CityService;
import ru.job4j.VacancyAndCandidate_list.service.PostService;

import javax.annotation.concurrent.ThreadSafe;
import javax.servlet.http.HttpSession;

@ThreadSafe
@Controller
public class PostController {

    private final PostService postService;
    private final CityService cityService;

    public PostController(PostService service, CityService cityService) {
        this.postService = service;
        this.cityService = cityService;
    }

    @GetMapping("/posts")
    public String posts(Model model, HttpSession session) {
    User user = (User) session.getAttribute("user");
        if (user == null) {
        user = new User();
        user.setName("Гость");
    }
        model.addAttribute("user", user);
        model.addAttribute("posts", postService.findAll());
        return "posts";
}

    @GetMapping("/formUpdatePost/{postId}")
    public String formUpdatePost(Model model, @PathVariable("postId") int id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName("Гость");
        }
        model.addAttribute("user", user);
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("cities", cityService.getAllCities());
        return "updatePost";
    }

    @GetMapping("/formAddPost")
    public String formAddPost(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName("Гость");
        }
        model.addAttribute("user", user);
        model.addAttribute("cities", cityService.getAllCities());
        return "addPost";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute Post post, @RequestParam("city.id") int id) {
        post.setCity(cityService.findById(id));
        postService.add(post);
        return "redirect:/posts";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Post post, @RequestParam("city.id") int id) {
        post.setCity(cityService.findById(id));
        postService.update(post);
        return "redirect:/posts";
    }
}
