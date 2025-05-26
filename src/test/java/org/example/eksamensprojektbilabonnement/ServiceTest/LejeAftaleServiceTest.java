/*
package org.example.eksamensprojektbilabonnement.ServiceTest;

import org.example.eksamensprojektbilabonnement.Service.LejeAftaleService;
import org.example.eksamensprojektbilabonnement.Repository.LejeAftaleRepo;
import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.example.eksamensprojektbilabonnement.Repository.KunderRepo;
import org.example.eksamensprojektbilabonnement.Model.LejeAftale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        lejeAftaleService = new LejeAftaleService();
    }

    @Test
    public void TestLejeAftaleSuccess() {
        lejeAftaleService.opretLejeaftale(1L, 2L, LocalDate.now(), LocalDate.now().plusDays(7));
        verify(lejeAftaleRepo, times(1).opretLejeAftale(any(LejeAftale.class)))
    }
}
*/