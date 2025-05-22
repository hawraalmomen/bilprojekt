/*
package org.example.eksamensprojektbilabonnement.ServiceTest;

import org.example.eksamensprojektbilabonnement.Repository.LoginRepo;
import org.example.eksamensprojektbilabonnement.Service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class LoginServiceTest {

    private LoginService loginService;

    @Mock
    private LoginRepo loginRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        loginService = new LoginService(loginRepo);
    }

    // Happy flow
    @Test
    void TestLoginSuccess() {
        when(loginRepo.isValidUser("main", "main123")).thenReturn(true);
        String result = loginService.login("main", "main123");
        assertEquals("Login Successful", result);
    }

    // Exception flow: forkert credentials
    @Test
    void TestLoginInvalidCredentials() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            loginService.login("invalid", "invalid123");
        });
        assert exception.getMessage().equals("Invalid credentials");
    }

    // Exception flow: ingen input
    @Test
    void TestLoginIngenInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            loginService.login(null, "main123");
        });
        assert exception.getMessage().equals("input is required");
    }
}
*/