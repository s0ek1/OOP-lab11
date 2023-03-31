package com.example.testweb.controllers;

import com.example.testweb.calculator.TabulCalc;
import com.example.testweb.data.Point;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/tabul")
    public String tabulCalc(@RequestParam double start, @RequestParam double finish, @RequestParam double step, Model model) {
        TabulCalc tabulCalc = new TabulCalc(start,finish,step);
        List<Point> points = tabulCalc.tabulating(start,finish,step);
        model.addAttribute("tabul", tabulCalc);
        model.addAttribute("points", points);
        return "tabul";
    }
}
