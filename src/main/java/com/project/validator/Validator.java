//package com.project.validator;
//
//import com.project.dto.request.user.UserRequestDTO;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
//public class Validator {
//    public static void validateLogin(UserRequestDTO userRequestDTO) {
//        if (userRequestDTO == null || userRequestDTO.getEmail() == null || userRequestDTO.getPassword() == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
//        }
//        validatePassword(userRequestDTO.getPassword());
//    }
//
//    public static void validateRegister(UserRequestDTO userRequestDTO) {
//        validateLogin(userRequestDTO);
//        if (userRequestDTO.getUsername() == null || userRequestDTO.getTelephone() == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "INVALID_REQUEST");
//        }
//    }
//
//    public static void validatePassword(String password) {
//        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
//        if(!matchRegex(regex,password)) throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"INVALID_PASSWORD");
//    }
//
//    public static void validateEmail(String email){
//        String emailRequex= "^(.+)@(\\\\S+)$";
//        if(!matchRegex(emailRequex,email)) throw  new ResponseStatusException(HttpStatus.BA)
//    }
//
//    private static boolean matchRegex(String regex,String toValidate){
//        return Pattern.compile(regex).matcher(toValidate).matches();
//    }
//}
