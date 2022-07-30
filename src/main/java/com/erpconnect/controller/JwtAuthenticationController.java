package com.erpconnect.controller;

import com.erpconnect.config.JwtTokenUtils;
import com.erpconnect.model.CustomerEntity;
import com.erpconnect.model.CustomerLoginResponseModel;
import com.erpconnect.model.JwtRequest;
import com.erpconnect.model.JwtResponse;
import com.erpconnect.repository.CustomerRepository;
import com.erpconnect.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/authentication/v1")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtils jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtInMemoryUserDetailsService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> generateAuthenticationToken(@RequestBody JwtRequest jwtRequest)
            throws Exception {

        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }

//    @PostMapping("/login")
//    public CustomerLoginResponseModel Login (@RequestBody JwtRequest jwtRequest) throws Exception {
//        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
//
//        Optional<CustomerEntity> customer = customerRepository.findById(jwtRequest.getUsername());
//
//        CustomerEntity customerEntity = customer.get();
//
//        CustomerLoginResponseModel customerLoginResponseModel = new CustomerLoginResponseModel();
//
//        customerLoginResponseModel.setCustomer_id(customerEntity.getCustomer_id());
//        customerLoginResponseModel.setCustomer_name(customerEntity.getCustomer_name());
//        customerLoginResponseModel.setCustomer_address(customerEntity.getCustomer_address());
//        customerLoginResponseModel.setCustomer_phone(customerEntity.getCustomer_phone());
//        customerLoginResponseModel.setErpconnect_public_key(customerEntity.getErpconnect_public_key());
//        customerLoginResponseModel.setCustomer_public_key(customerEntity.getCustomer_public_key());
//
//        return customerLoginResponseModel;
//    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            System.out.println("USER_DISABLED");
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            System.out.println("INVALID_CREDENTIALS");
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
