package com.example.ECF_4.controller;

import com.example.ECF_4.entities.Interview;
import com.example.ECF_4.entities.JobOffer;
import com.example.ECF_4.entities.User;
import com.example.ECF_4.services.ApplicationService;
import com.example.ECF_4.services.AuthService;
import com.example.ECF_4.services.InterviewService;
import com.example.ECF_4.services.JobService;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class JobOfferController {
    private final JobService jobService;
    private final InterviewService interviewService;
    private final ApplicationService applicationService;
    private final AuthService authService;

    public JobOfferController(JobService jobService, InterviewService interviewService, ApplicationService applicationService, AuthService authService) {
        this.jobService = jobService;
        this.interviewService = interviewService;
        this.applicationService = applicationService;
        this.authService = authService;
    }

    @GetMapping("/")

    public String home(Model model  , HttpSession session){
        if (authService.isLogged()){
            model.addAttribute("login", authService.isLogged());
            model.addAttribute("jobs", jobService.getAll());
            model.addAttribute("user", (User) session.getAttribute("user"));
            model.addAttribute("comment", new Interview());
            return "home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("jobForm")
    public String jobForm(Model model){
        if (authService.isLogged()) {
            model.addAttribute("login", authService.isLogged());
            model.addAttribute("jobs", new JobOffer());
            return "jobForm";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/job/add")
    public String addJob(@ModelAttribute("job") JobOffer jobOffer, HttpSession session){
        if (authService.isLogged()) {
            jobOffer.setAuthor((User) session.getAttribute("user"));
            jobOffer.setStartDate(LocalDate.now());
            jobService.add(jobOffer);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }

    }

    @GetMapping("/job/edit/{id}")
    public String editJob(@PathVariable int id, Model model) {
        if (authService.isLogged()) {
            model.addAttribute("jobOffer", jobService.getById(id));
            return "jobForm";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/job/delete/{id}")
    public String deletePost(@PathVariable int id) {
        if (authService.isLogged()) {
            jobService.delete(id);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }




}
