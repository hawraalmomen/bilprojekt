package org.example.eksamensprojektbilabonnement.ServiceTest;

import org.example.eksamensprojektbilabonnement.Model.Login;
import org.example.eksamensprojektbilabonnement.Repository.LoginRepo;
import org.example.eksamensprojektbilabonnement.Service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoginServiceTest {

    private LoginService loginService;
    private LoginRepo loginRepo;

    @BeforeEach
    public void setUp() {
        loginRepo = mock(LoginRepo.class); // mock the repo
        loginService = new LoginService(loginRepo); // inject the mock
    }

    // Happy flow
    @Test
    public void testLoginSuccess() {
        // Arrange
        String username = "main";
        String kodeord = "main123";
        Login mockLogin = new Login();
        mockLogin.setBrugernavn(username);
        mockLogin.setKodeord(kodeord);

        when(loginRepo.findByBrugernavn(username)).thenReturn(Optional.of(mockLogin));

        // Act
        boolean result = loginService.login(username, kodeord);

        // Assert
        assertTrue(result);
        verify(loginRepo).findByBrugernavn(username);
    }

    // Exception flow
    @Test
    public void testLoginWrongPassword() {
        // Arrange
        String username = "main";
        String inputKodeord = "wrong";
        Login mockLogin = new Login();
        mockLogin.setBrugernavn(username);
        mockLogin.setKodeord("main123");

        when(loginRepo.findByBrugernavn(username)).thenReturn(Optional.of(mockLogin));

        // act
        boolean result = loginService.login(username, inputKodeord);

        // Assert
        assertFalse(result);
        verify(loginRepo).findByBrugernavn(username);
    }

    @Test
    public void testLoginUserNotFound() {
        // Arrange
        String username = "notfound";
        String password = "notfound123";

        when(loginRepo.findByBrugernavn(username)).thenReturn(Optional.empty());

        // Act
        boolean result = loginService.login(username, password);

        // Assert
        assertFalse(result);
        verify(loginRepo).findByBrugernavn(username);
    }
}
