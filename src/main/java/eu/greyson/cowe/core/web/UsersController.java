package eu.greyson.cowe.core.web;

import eu.greyson.cowe.core.model.User;
import eu.greyson.cowe.core.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Controller used to manage users.
 */
@Controller
public class UsersController
{
    private static final String USER_FORM = "users/userForm";

    @Autowired
    private CoreService coreService;

    /** Show list of users. */
    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    public String userList(final Map<String, Object> model)
    {
        List<User> results = coreService.findAllUsers();
        model.put("users", results);
        return "users/usersList";
    }

    /** Show user detail. */
    @RequestMapping(value = "/users/{loginName}", method = RequestMethod.GET)
    public String userDetail(@PathVariable("loginName") String loginName, final Map<String, Object> model)
    {
        User user = coreService.findUserByLoginName(loginName);
        model.put("user", user);
        return "users/userDetails";
    }

    /** Check data. */
    @InitBinder
    public void initUserBinder(final WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");
        dataBinder.setValidator(new UserValidator());
    }

    /** Create new user. */
    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String initCreationForm(final ModelMap model)
    {
        User user = new User();
        model.put("user", user);
        return USER_FORM;
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.POST)
    public String processCreationForm(@Valid User user, BindingResult result, ModelMap model)
    {
        if (!user.isNew())
        {
            result.rejectValue("name", "duplicate", "already exists");
        }

        if (result.hasErrors())
        {
            model.put("user", user);
            return USER_FORM;
        }
        else
        {
            coreService.saveUser(user);
            return "redirect:/users/" + user.getLoginName();
        }
    }

    /** Update existing user. */
    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
    public String initUpdateForm(@PathVariable("userId") Long userId, Model model)
    {
        Optional<User> user = coreService.findUserById(userId);

        if(user.isPresent())
        {
            model.addAttribute(user.get());
        }
        return USER_FORM;
    }

    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.POST)
    public String processUpdateForm(@Valid User user, BindingResult result, @PathVariable("userId") Long userId)
    {
        if (result.hasErrors())
        {
            return USER_FORM;
        }
        else
        {
            user.setId(userId);
            coreService.saveUser(user);
            return "redirect:/users/" + user.getLoginName();
        }
    }
}
