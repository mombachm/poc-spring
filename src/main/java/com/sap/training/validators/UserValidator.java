package com.sap.training.validators;

    import com.sap.training.models.User;
    import com.sap.training.services.UserService;
    import org.springframework.validation.Errors;
    import org.springframework.validation.Validator;

    import javax.annotation.Resource;

public class UserValidator implements Validator {
    @Resource
    private UserService userService;

    @Override
    public boolean supports(Class<?> targetClass) {
        return User.class.equals(targetClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;

        //
        if(user.getEmail() != null && userService.userEmailExists(user.getEmail())){
            errors.rejectValue("email", "", "This email is already registered");
        }

        if(!(user.getPassword().equals(user.getPasswordConfirm()))){
            errors.rejectValue("passwordConfirm", "","Passwords don't match");
        }

        if(user.getPassword().length() < 6){
            errors.rejectValue("password", "","At least 6 characters needed");
        }

        if(!user.getPassword().matches("^(?=.*\\d)(?=.*[a-z]).{6,255}$")){
            errors.rejectValue("password", "","Must contain letters - and - numbers");
        }
    }
}