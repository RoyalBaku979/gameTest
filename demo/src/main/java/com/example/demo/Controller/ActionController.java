package com.example.demo.Controller;

import com.example.demo.Form.ActionForm;
import com.example.demo.Service.Inter.ActionServiceInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@Slf4j
@RequestMapping("/")
public class ActionController {
    private final ActionServiceInter actionServiceInter;

    @Autowired
    public ActionController(ActionServiceInter actionServiceInter){
        this.actionServiceInter = actionServiceInter;
    }


    @PostMapping("action")
    public ResponseEntity<String> action(@Valid @RequestBody ActionForm actionForm,
                                 BindingResult result)  {
        if (result.hasErrors()) {

            return ResponseEntity.badRequest().body(result.getFieldError().toString());
        }

        try {
            actionServiceInter.saveActionToDb(actionForm);
            return ResponseEntity.ok("Successfully Add ActionForm to Database");
        }catch (DataAccessException ex){
            return ResponseEntity.badRequest().body("DataBaseException");
        }
    }

}
