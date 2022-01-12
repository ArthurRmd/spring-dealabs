package com.example.dealabs.controllers;

import com.example.dealabs.dto.LoginRequestDTO;
import com.example.dealabs.dto.UserDTO;
import com.example.dealabs.security.DealabsSpringUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {


    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthenticationProvider authenticationManager;


    /**
     * methode de connexion d'un utilisateur
     *
     * @param request données necessaire a la connexion
     * @return
//     * @throws RestException
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST,value = "/public/login")
    public UserDTO login(@RequestBody final LoginRequestDTO request) {

        System.out.println("route => login");
        // Controle des params obligatoires
        if (StringUtils.isEmpty(request.getPseudo())) {
            throw new BadCredentialsException("User/pwd must not be emtpy");

        }
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getPseudo(), request.getPassword()));
        if (authentication == null) {
            throw new BadCredentialsException("User/pwd incorrect");
        }


        final DealabsSpringUser utilisateur = (DealabsSpringUser) authentication.getPrincipal();
        logger.debug("New user logged : " + utilisateur.getUsername());

        // TODO : Ajouter les informations n�cessaires au DTO pour retour au front.
        return new UserDTO(request.getPseudo(), request.getPassword());
    }

}
