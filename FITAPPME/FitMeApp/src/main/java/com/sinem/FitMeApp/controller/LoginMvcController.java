package com.sinem.FitMeApp.controller;

import com.sinem.FitMeApp.dto.request.MusteriLoginRequestDto;
import com.sinem.FitMeApp.exception.ErrorType;
import com.sinem.FitMeApp.exception.FitMeAppManagerException;
import com.sinem.FitMeApp.repository.entity.EGender;
import com.sinem.FitMeApp.repository.entity.Musteri;
import com.sinem.FitMeApp.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginMvcController {

    //localhost:8090/login/registerpage
    private final MusteriService musteriService;

    @GetMapping("/loginpage")
    public ModelAndView loginPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
    return modelAndView;
    }

    @PostMapping("/dologin")
    public ModelAndView doLogin(MusteriLoginRequestDto dto){
        ModelAndView modelAndView=new ModelAndView();
        Optional<Musteri> musteri=musteriService.login(dto.getEmail(),dto.getPassword());

        if (musteri.isPresent()){
            modelAndView.addObject("musteri",musteriService.findById(musteri.get().getId()).get());

            if (musteri.get().getGender().equals(EGender.WOMAN)){
                modelAndView.setViewName("homewoman");
                 }else {
               modelAndView.setViewName("homeman");
                 }

            }else {
               modelAndView.setViewName("redirect:loginpage");
            }
        return  modelAndView;
    }

        @GetMapping("/registerpage")
        public ModelAndView register(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("genders",EGender.values());
        return modelAndView;
        }

    @PostMapping("/doregister")
    public ModelAndView savedto(String namesurname,String email,String password,String gender){
     musteriService.saveDto(Musteri.builder().namesurname(namesurname).email(email)
             .password(password).gender(EGender.valueOf(gender)).build());

        return new ModelAndView("redirect:loginpage");
    }
}
