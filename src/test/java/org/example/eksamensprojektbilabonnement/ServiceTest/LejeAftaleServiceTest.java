package org.example.eksamensprojektbilabonnement.ServiceTest;

import org.example.eksamensprojektbilabonnement.Model.Bil;
import org.example.eksamensprojektbilabonnement.Model.Kunder;
import org.example.eksamensprojektbilabonnement.Model.LejeAftale;
import org.example.eksamensprojektbilabonnement.Repository.LejeAftaleRepo;
import org.example.eksamensprojektbilabonnement.Service.LejeAftaleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LejeAftaleServiceTest {
    @Mock
    private LejeAftaleRepo lejeAftaleRepo;

    @InjectMocks
    private LejeAftaleService lejeAftaleService;

    private Kunder testKunde;
    private Bil testBil;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testKunde = new Kunder();
        testBil = new Bil();
    }

    @Test
    public void testCreateLejeAftale() {
        LocalDate start = LocalDate.of(2025, 1, 1);
        LocalDate end = LocalDate.of(2025, 1, 10);

        LejeAftale expectedLejeAftale = new LejeAftale();
        expectedLejeAftale.setBil(testBil);
        expectedLejeAftale.setStartDato(start);
        expectedLejeAftale.setSlutDato(end);

        when(lejeAftaleRepo.save(any(LejeAftale.class))).thenReturn(expectedLejeAftale);

        LejeAftale result = lejeAftaleService.createLejeAftale(testKunde, testBil, start, end);

        assertEquals(testBil, result.getBil());
        assertEquals(start, result.getStartDato());
        assertEquals(end, result.getSlutDato());
        verify(lejeAftaleRepo, times(1)).save(any(LejeAftale.class));
    }

    @Test
    public void testGetAntalLejeAftale() {
        when(lejeAftaleRepo.count()).thenReturn(5L);
        long count = lejeAftaleService.getAntalLejetBiler();
        assertEquals(5L, count);
        verify(lejeAftaleRepo, times(1)).count();
    }

}
