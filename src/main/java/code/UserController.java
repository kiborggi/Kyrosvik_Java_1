package code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

  //  @Autowired
  //  private UserSevice userSevice;


    @RequestMapping("/")
    public String userInfo(Model model) {
      //  List<User> listUser = userSevice.listAll();
         User user = new User();
        List<User> listUser = new ArrayList<>();
        listUser.add(user);
        model.addAttribute("listUser",listUser);
        return "index";
    }

   @RequestMapping("/new")
   public String newUserForm(Map<String, Object> model) {
        model.put("user", new User());
       return "new_user";
   }
    @RequestMapping(value = "/save_user" , method = RequestMethod.POST)
    public String newCustomerForm(@ModelAttribute("user") User user) {

        System.out.println(user.getId());
      // userSevice.save(user);

        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
      //  userSevice.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_user");
     //   User user = userSevice.get(id);
       // mav.addObject("user", user);
        return mav;
    }




}