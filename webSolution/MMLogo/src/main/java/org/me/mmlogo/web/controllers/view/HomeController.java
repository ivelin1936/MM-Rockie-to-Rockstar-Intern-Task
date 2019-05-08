package org.me.mmlogo.web.controllers.view;

import org.me.mmlogo.service.LogoCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private static final String LOGO = "logo";
    private static final String ERROR = "error";

    private final LogoCreatorService logoService;

    @Autowired
    public HomeController(LogoCreatorService logoService) {
        this.logoService = logoService;
    }

    @GetMapping("/")
    public ModelAndView renderIndexPage(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("/draw")
    public ModelAndView processDraw(@RequestParam("fontWeight") Integer fontWeight,
                                    ModelAndView modelAndView) {
        try {
            String result = this.logoService.create(fontWeight);
            modelAndView.addObject(LOGO, result);
            modelAndView.setViewName("logo");
        } catch (Exception ex) {
            modelAndView.addObject(ERROR, ex.getMessage());
            modelAndView.setViewName("index");
            return modelAndView;
        }

        return modelAndView;
    }
}
