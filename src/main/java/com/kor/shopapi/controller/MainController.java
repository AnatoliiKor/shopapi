package com.kor.shopapi.controller;

import com.kor.shopapi.domain.Bike;
import com.kor.shopapi.domain.Cart;
import com.kor.shopapi.domain.Counter;
import com.kor.shopapi.domain.User;
import com.kor.shopapi.repository.CounterRepository;
import com.kor.shopapi.services.BikeService;
import com.kor.shopapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {
    int wrongNumber = 0;
    int correctNumber = 0;
    int timeStart = (int) System.currentTimeMillis() / 1000;
    int succes;
    int timePause;
    int time = 0;
    @Autowired
    private BikeService bikeService;

    @Autowired
    private UserService userService;

    @Autowired
    private CounterRepository counterRepository;

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String admin(@RequestParam(required = false) String filter, Model model) {
        List<Bike> bikes;
        if (filter != null && !filter.isEmpty()) {
            bikes = bikeService.findByName(filter);
        } else {
            bikes = bikeService.findAll();
        }
        model.addAttribute("bikes", bikes);
        model.addAttribute("bikes", bikes);
        model.addAttribute("filter", filter);
        return "admin";
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest httpServletRequest,
                          Model model) {
        User user = userService.findByUsername(httpServletRequest.getRemoteUser());
        List<Cart> carts = user.getCarts();
        model.addAttribute("user", user);
        model.addAttribute("carts", carts);
        return "profile";
    }

    @GetMapping("/counter")
    public String counter(@RequestParam(required = false) String correct,
                          @RequestParam(required = false) String wrong,
                          @RequestParam(required = false) String clear,
                          Model model) {

        if (wrong != null) {
            wrongNumber = Integer.valueOf(wrong) + 1;
        }
        if (correct != null) {
            correctNumber = Integer.valueOf(correct) + 1;
        }
        int timeNow = (int) System.currentTimeMillis() / 1000;

        if (clear != null && clear.equals("pause")) {
            timePause = timeNow - timeStart;
            model.addAttribute("finish", "PAUSE");
        }

        int min;
        int sec;
        time = timeNow - timeStart;
        if (timePause == 0) {
            min = time / 60;
            sec = time % 60;
        } else if (timePause == timeNow - timeStart) {
            min = time / 60;
            sec = time % 60;
        } else {
            timeStart = timeStart + time - timePause;
            timePause = 0;
            time = timeNow - timeStart;
            min = time / 60;
            sec = time % 60;
        }
        int question;
        if (clear != null && clear.equals("clear")) {
            correctNumber = 0;
            wrongNumber = 0;
            timeStart = (int) System.currentTimeMillis() / 1000;
            min = 0;
            sec = 0;
            timePause = 0;
        }
        if ((correctNumber + wrongNumber) != 0) {
            succes = (100 * correctNumber / (correctNumber + wrongNumber));
            question = time / (correctNumber + wrongNumber);
        } else {
            succes = 0;
            question = 0;
        }
        String formattedDouble = min + " min " + sec + " sec";
        model.addAttribute("question", question);
        model.addAttribute("succes", succes);
        model.addAttribute("wrong", wrongNumber);
        model.addAttribute("time", formattedDouble);
        model.addAttribute("correct", correctNumber);
        model.addAttribute("timeMin", min + "." + sec);
        if (wrongNumber == 5) {
            model.addAttribute("finish", "Yoi did 5 mistakes. " +
                    "Time is " + formattedDouble + ", succes is " + succes + "%. The result is saved");
            Counter counter = new Counter(correctNumber,time, succes);
            counterRepository.save(counter);

            wrongNumber = 0;
            model.addAttribute("wrong", wrongNumber);
        }
        String sort = "localDate";
        List<Counter> results = counterRepository.findAll(Sort.by(Sort.Order.desc(sort)));
        model.addAttribute("results", results);
        return "counter";
    }

    @PostMapping("/counter/add")
    public String addAndEdit(@ModelAttribute("counter") Counter counter) {
        counterRepository.save(counter);
        return "redirect:/counter?clear=pause";
    }


}