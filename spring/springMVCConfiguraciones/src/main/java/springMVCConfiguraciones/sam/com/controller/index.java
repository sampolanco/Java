package springMVCConfiguraciones.sam.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class index {

	@RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "Hola Spring web";
    }
}
