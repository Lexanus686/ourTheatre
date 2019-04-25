package UI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimetableController {

    @GetMapping("/timetable")
    public String showForm() {
        return "timetable";
    }

}
