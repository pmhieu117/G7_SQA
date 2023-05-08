//package com.hieupm.code_bhyt;
//
//import ch.qos.logback.core.net.ObjectWriter;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.hieupm.code_bhyt.controllers.AuthController;
//import com.hieupm.code_bhyt.payload.request.LoginRequest;
//import com.hieupm.code_bhyt.repository.RoleRepository;
//import com.hieupm.code_bhyt.repository.UserRepository;
//import com.hieupm.code_bhyt.security.jwt.JwtUtils;
//import org.apache.catalina.core.ApplicationFilterConfig;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(AuthController.class)
//public class testAuthController {
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private AuthenticationManager authenticationManager;
//
//    @Mock
//    UserRepository userRepository;
//
//    @Mock
//    RoleRepository roleRepository;
//
//    @Mock
//    PasswordEncoder encoder;
//
//    @Mock
//    JwtUtils jwtUtils;
//
////    @Mock
////    AuthController authController;
//
//    ObjectWriter objectWriter;
//
//
//    @InjectMocks
//    private AuthController authController;
//
//    @BeforeEach
//    public void setup() throws Exception {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
//    }
//
//    @Test
//    public void testLoginSuccess() throws Exception {
//        LoginRequest loginRequest=new LoginRequest();
//        loginRequest.setUsername("1234567890");
//        loginRequest.setPassword("12345");
//        String contentLogin = objectWriter.write(loginRequest);
//        MvcResult mvcResult = this.mockMvc.perform(post("/api/auth/signin").content("{'username':'1234567890','password':'12345'}"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.status").value("success"))
//                .andReturn();
//        assert "application/json;charset=UTF-8" == mvcResult.getResponse().getContentType();
//
//    }
//
//}
