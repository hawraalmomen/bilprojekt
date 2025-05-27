package org.example.eksamensprojektbilabonnement.ServiceTest;

import org.example.eksamensprojektbilabonnement.Model.Bil;
import org.example.eksamensprojektbilabonnement.Service.LejeAftaleService;
import org.example.eksamensprojektbilabonnement.Repository.LejeAftaleRepo;
import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.example.eksamensprojektbilabonnement.Repository.KunderRepo;
import org.example.eksamensprojektbilabonnement.Model.LejeAftale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LejeAftaleServiceTest {
    private LejeAftaleRepo lejeAftaleRepo;
    private LejeAftaleService lejeAftaleService;
    private BilRepo bilRepo;
    private KunderRepo kunderRepo;

    @BeforeEach
    public void setUp() {
        lejeAftaleRepo = mock(LejeAftaleRepo.class);
        bilRepo = mock(BilRepo.class);
        kunderRepo = mock(KunderRepo.class);

        lejeAftaleService = new LejeAftaleService(lejeAftaleRepo, kunderRepo, bilRepo);

        ReflectionTestUtils.setField(lejeAftaleService, "lejeAftaleRepo", lejeAftaleRepo);
        ReflectionTestUtils.setField(lejeAftaleService, "bilRepo", bilRepo);
        ReflectionTestUtils.setField(lejeAftaleService, "kunderRepo", kunderRepo);
    }

    // Happy flow
    @Test
    public void testOpretLejeaftale_HappyFlow() {
        // Arrange
        LejeAftale lejeAftale = new LejeAftale();
        lejeAftale.setBilId(1L);
        lejeAftale.setKundeId(2L);
        lejeAftale.setStartDato(LocalDate.now());
        lejeAftale.setSlutDato(LocalDate.now().plusDays(5));

        Bil bil = new Bil();
        bil.setBilId(1L);
        bil.setBilStatus("Klar"); // Car is available

        when(bilRepo.hentBilMedId(1L)).thenReturn(Optional.of(bil));

        // Use spy to verify state change
        doNothing().when(lejeAftaleRepo).opretLejeaftale(any(LejeAftale.class));
        doNothing().when(bilRepo).opdaterBil(any(Bil.class));

        // Act
        lejeAftaleService.opretLejeaftale(lejeAftale);

        // Assert
        verify(lejeAftaleRepo, times(1)).opretLejeaftale(lejeAftale);
        assertEquals("Udlejet", bil.getBilStatus());
        verify(bilRepo, times(1)).opdaterBil(bil);
    }

    // Exception flow
    @Test
    public void testOpretLejeaftaleCarAlreadyRented() {
        // Arrange
        LejeAftale lejeAftale = new LejeAftale();
        lejeAftale.setBilId(1L);
        lejeAftale.setKundeId(2L);

        Bil bil = new Bil();
        bil.setBilId(1L);
        bil.setBilStatus("Udlejet"); // allerede udlejet

        when(bilRepo.hentBilMedId(1L)).thenReturn(Optional.of(bil));

        // Act og Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            lejeAftaleService.opretLejeaftale(lejeAftale);
        });

        assertEquals("Bilen er allerede Udlejet", exception.getMessage());
        verify(lejeAftaleRepo, never()).opdaterLejeaftale(any());
        verify(bilRepo, never()).opdaterBil(any());
    }

    // Exception flow
    @Test
    public void testOpretLejeaftale_CarNotFound() {
        // Arrange
        LejeAftale lejeAftale = new LejeAftale();
        lejeAftale.setBilId(99L); // Car doesn't exist

        when(bilRepo.hentBilMedId(99L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            lejeAftaleService.opretLejeaftale(lejeAftale);
        });

        assertEquals("Bilen blev ikke fundet", exception.getMessage());
        verify(lejeAftaleRepo, never()).opretLejeaftale(any());
        verify(bilRepo, never()).opdaterBil(any());
    }
}
