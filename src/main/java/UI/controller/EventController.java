package UI.controller;

import BL.EventManager;
import BL.EventManagerInterface;
import BL.UserManager;
import BL.UserManagerInterface;
import BL.entities.Event;
import BL.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class EventController {

    private UserManagerInterface userManager;
    private EventManagerInterface eventManager;
    private String page = "";
    private Integer id = 0;

    private static Integer[] parseString(String[] str) {
        Integer[] tmp = new Integer[str.length];

        for (int i = 0; i < str.length; i++) {
            tmp[i] = Integer.parseInt(str[i]);
        }

        return tmp;
    }

    private static String[] getString(ArrayList<Event> events) {
        String[] tmp = new String[events.size()];
        int i = 0;
        for (Event event : events) {
            tmp[i] = event.getRow() + " " + event.getPlace() + " " + event.getPrice();
            i++;
        }
        return tmp;
    }

    //Работает в связке с eventPage(model)
    @RequestMapping(value = "/getPageTitle", method = RequestMethod.GET)
    public @ResponseBody
    String getPageTitle(@RequestParam(value = "myString") String myString) {
        this.page = myString;
        this.id = Integer.parseInt(myString.substring(myString.indexOf("vent") + 4));

        return myString;
    }

    @GetMapping("/eventPage")
    public String eventPage(Model model) {
        model.addAttribute("event1", new User());

        userManager = new UserManager();
        eventManager = new EventManager();

        while (page.equals("")) {

        }
        return "event/" + page;
    }

    //Переход на страницу оплаты заказа.
    //Работает в связке с makePayment(myArray)
    @PostMapping("/eventPage")
    public String getForm(@ModelAttribute User user, Model model) {
        model.addAttribute("event1", user);

        userManager.setCurrentUser(user);
        return "paymentapprove";
    }

    @GetMapping("/makePayment")
    public @ResponseBody
    Integer makePayment(@RequestParam(value = "myArray[]") String[] myArray) {
        Integer[] intArray = parseString(myArray);

        while (userManager.getCurrentUser() == null) {
        }
        eventManager.setCurrentEvent(new Event(intArray[0], userManager.getCurrentUser().getHashID(), intArray[1], intArray[2], intArray[3]));
        return 0;
    }

    //Работает при загрузке event/eventx страницы.
    @GetMapping("/updatePlaces")
    public @ResponseBody
    String[] updatePlaces() {
        ArrayList<Event> eventInfo = eventManager.getInfo(new Event(id, null, null, null, null));

        return getString(eventInfo);
    }

    //Ответ от страницы с оплатой
    @GetMapping("/verificationAnswer")
    public @ResponseBody
    String verificationAnswer(@RequestParam(value = "myAnswer") String myAnswer) {

        if (Integer.parseInt(myAnswer) == 0) {
            userManager.fullyAddUser();
            eventManager.fullyUpdateEvent();

            return "Success";
        } else {

            return "Failure";
        }
    }
}