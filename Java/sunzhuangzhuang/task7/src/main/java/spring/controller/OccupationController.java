package spring.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.model.Occupation;
import spring.service.impl.OccupationService;
import spring.service.impl.StudentService;

import java.util.List;

@Controller
@RequestMapping("u")
public class OccupationController {
    @Autowired
    private OccupationService occupationService;
    @Autowired
    private StudentService studentService;

    Logger logger = Logger.getLogger(OccupationController.class);
    @RequestMapping(value = "occupation",method = RequestMethod.GET)
    public ModelAndView testView(){
        ModelAndView mav = new ModelAndView("occupation");
        List<Occupation> list = occupationService.query();
        int a = studentService.getJava();
        int b = studentService.getWeb();
        int c = studentService.getPm();
        mav.addObject("a",a);
        mav.addObject("b",b);
        mav.addObject("c",c);
        mav.addObject("list",list);
        logger.error("访问职业页面");
        return mav;
    }
}
