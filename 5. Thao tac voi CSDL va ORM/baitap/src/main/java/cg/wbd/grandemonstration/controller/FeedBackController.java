package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.model.FeedBack;
import cg.wbd.grandemonstration.service.impl.HibernateFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/feedbacks")
public class FeedBackController {
    @Autowired
    private HibernateFeedBackService feedBackService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/index");
        List<FeedBack> feedBacks = feedBackService.findAll();
        modelAndView.addObject("feedBacks", feedBacks);
        modelAndView.addObject("feedBack", new FeedBack());
        return modelAndView;
    }

//    @GetMapping("{id}")
//    public ModelAndView showInformation(@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("customers/info");
//        Customer customer = feedBackService.findOne(id);
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
    @PostMapping
    public String saveFeedBack(@ModelAttribute FeedBack feedBack) {
        feedBackService.save(feedBack);
        return "redirect:/feedbacks";
    }

    @GetMapping("/increaseLike")
    public String increaseLike() {
        ModelAndView modelAndView = new ModelAndView("customers/index");
        List<FeedBack> feedBacks = feedBackService.findAll();
        modelAndView.addObject("feedBacks", feedBacks);
        modelAndView.addObject("feedBack", new FeedBack());
        return modelAndView;
    }
}
