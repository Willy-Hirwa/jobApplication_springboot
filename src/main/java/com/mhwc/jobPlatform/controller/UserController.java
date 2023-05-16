package com.mhwc.jobPlatform.controller;

import com.mhwc.jobPlatform.dao.UserDao;
import com.mhwc.jobPlatform.model.User;
import com.mhwc.jobPlatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;



@Controller
@RequestMapping("/Manager")
public class UserController {

    //@Autowired
    private UserService userService;
    private UserDao userDao;
   // @Autowired
    //private ManagerService managerService;


    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public UserController(UserService userService, UserDao userDao) {
        this.userService = userService;
        this.userDao = userDao;
    }




    private Logger logger = Logger.getLogger(getClass().getName());

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/show")
    public String showMyLoginPage(Model theModel) {
        User user = new User();
        theModel.addAttribute("user", user);
        return "registration-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("user") User user,
            BindingResult theBindingResult,
            Model theModel) {

        if(theBindingResult.hasErrors()){
            return "registration-form";
        }
        String userName = user.getUsername();
        logger.info("Processing registration form for: " + userName
        + " With role = " + user.getFormRole());

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null){
           // theModel.addAttribute("manager",  new OperationsManager());
            theModel.addAttribute("registrationError", "User name already exists.");
            logger.warning("User name already exists.");
            return "registration-form";
        }
        //
        //We passed all of the validation checks!
        // let's get down to business!!!
        //

        // encrypt the password
        //String encodedPassword = passwordEncoder.encode(operationsManager.getPassword());

        // prepend the encoding algorithm id
       // encodedPassword = "{bcrypt}" + encodedPassword;

        // give user default role of "inspector"
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
        authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEER"));

        // if the user selected role other than employee,
        // then add that one too (multiple roles)
        String formRole = user.getFormRole();

        if (!formRole.equals("ROLE_EMPLOYEER")) {
            if (formRole.equals("ROLE_JOB_SEEKER")) {
                authorities.add(new SimpleGrantedAuthority(formRole));
            }else if(formRole.equals("ROLE_OPERATIONS_MANAGER")){
                authorities.add(new SimpleGrantedAuthority("ROLE_JOB_SEEKER"));
                authorities.add(new SimpleGrantedAuthority(formRole));
            }
        }
        logger.info("=========roles========");
        for(GrantedAuthority auth:authorities){
            logger.info(auth.toString() + "\n");
        }

        // create user account
        userService.save(user, authorities);

        logger.info("Successfully created user: " + userName);

        theModel.addAttribute("username", userName);

        return "registration-success";
    }
    @GetMapping("/loadForgotPassword")
    public String loadForgotPassword(){
      return "forgot-password";
    }

    @GetMapping("/loadResetPassword/{id}")
    public String loadResetPassword(@PathVariable Long id, Model m){

        m.addAttribute("id",id);
        return "reset-password";
    }
    @PostMapping("/forgotPassword")
    public String forgotPassword(@RequestParam String email, @RequestParam String phoneNumber, HttpSession session){
        User usr = userService.findByEmailAndPhoneNumber(email,phoneNumber);

        if (usr != null){
            return "redirect:/Manager/loadResetPassword/" + usr.getId();
//            return "redirect:/loadResetPassword";
        }else {
            session.setAttribute("msg", "Invalid email and Phone Number");
            return "forgot-password";
        }
   }
     @PostMapping("/changePassword")
    public String resetPassword(@RequestParam String psw, @RequestParam Long id, HttpSession session){

        User usr = userService.findById(id);
        String encryprPsw=passwordEncoder.encode(psw);
        usr.setPassword(encryprPsw);

        User updateUser =userService.save(usr);

        if(updateUser!=null){
            session.setAttribute("msg","Password changed successfully");
        }
        return  "redirect:/showMyLoginPage";
    }

}
