package nsu.rodionov.dynamica.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libruary")
public class LibruaryController {

    
    @GetMapping("/books/all")
    public String getAllbooks(Model model){

    }
}
