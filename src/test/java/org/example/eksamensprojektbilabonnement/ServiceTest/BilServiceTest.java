*/
package org.example.eksamensprojektbilabonnement.ServiceTest;

import org.example.eksamensprojektbilabonnement.Repository.BilRepo;
import org.example.eksamensprojektbilabonnement.Service.BilService;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class BilServiceTest {
    private BilService bilService;
    private BilRepo bilRepo;

    @BeforeEach
    public void setUp() {
        bilRepo = mock(bilRepo.class);
        bilService = new BilService(bilRepo);
    }
}
/*