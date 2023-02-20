package com.todoapplication.myfirstwebapp.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

//    private Logger logger = LoggerFactory.getLogger(getClass());
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String LoginController() {
        return "loginPage";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String gotToWelcomPage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name", name );
        model.put("password", password);

        if(authenticationService.authentication(name,password)){
            model.put("name", name );
            model.put("password", password);
            return "welcomePage";
        }
        //authentication
//        name = Alvin
//        password = test
        model.put("errorMsg", "Invalid Credentials");
        return "loginPage";
    }
}
