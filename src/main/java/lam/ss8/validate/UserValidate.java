package lam.ss8.validate;

import lam.ss8.model.User;
import org.springframework.validation.Errors;

public class UserValidate {
    public void checkValidate(User user, Errors error){
       if (user.getName().trim().equals("")){
           error.rejectValue("name","name.empty");
       }else if (user.getName().length()<5||user.getName().length()>20){
           error.rejectValue("name","name.length");
       }else if (user.getPhone().trim().equals("")){
           error.rejectValue("phone","phone.empty");
       } else if (!user.getPhone().matches("^(03|09)\\d{8}$")) {
           error.rejectValue("phone","phone.matches");
       } else if (user.getEmail().trim().equals("")) {
           error.rejectValue("email","email.empty");
       } else if (!user.getEmail().matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$")) {
           error.rejectValue("email","email.matches");
       }
    }
}
