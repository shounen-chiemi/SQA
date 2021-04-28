package test.springweb.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.springweb.entity2.thanhvien;
import test.springweb.service.thanhvienService;

import java.net.URI;
import java.util.Objects;

@Controller
public class showController {


    @RequestMapping({"/","index"})
    public String home(){
        return "index";
    }

    @RequestMapping("/test")
    public String index(){
        return "test";
    }
    @RequestMapping("/home")
    public String home1(){
        return "home";
    }
    @RequestMapping("/search-calculator")
    public String search_calculator(){
        return "search-calculator";
    }
    @RequestMapping("/search-info")
    public String search_info(){
        return "search-info";
    }
    @RequestMapping("/new")
    public String news(){
        return "new";
    }
    @RequestMapping("/question")
    public String question(){
        return "question";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/organizations-taxpayer")
    public String organizationsTaxpayer(){
        return "admin/organizations-taxpayer";
    }
    @RequestMapping("/report")
    public String report(Model model,HttpServletRequest request)
    {
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        return "admin/report";
    }
    @RequestMapping("/configuration")
    public String configuration(Model model,HttpServletRequest request)
    {
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        return "admin/configuration";
    }
}
