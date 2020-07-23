package com.project.board.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Profile("!dev")
@RestController
public class DisableSwaggerUiController {
    @RequestMapping(value = "swagger-ui.html", method = RequestMethod.GET)
    public ResponseEntity<Object> getSwagger(WebRequest request){
        return new ResponseEntity<Object>("",new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
