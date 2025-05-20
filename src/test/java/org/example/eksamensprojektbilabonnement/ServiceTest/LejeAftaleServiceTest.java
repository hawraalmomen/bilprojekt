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

}
