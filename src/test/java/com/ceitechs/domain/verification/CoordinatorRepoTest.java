package com.ceitechs.domain.verification;


import com.ceitechs.domain.verification.domain.Coordinator;
import com.ceitechs.domain.verification.repositories.CoordinatorRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.*;

public class CoordinatorRepoTest extends AbstractPangoDomainVerificationIntegrationTest {

    @Autowired
    CoordinatorRepository coordinatorRepository;

   @Test
   public void saveTest(){
       Coordinator coordinator = new Coordinator();
       coordinator.setFirstName("Changua");
       coordinator.setLastName("Pango");
       Coordinator savedC = coordinatorRepository.save(coordinator);

       assertNotNull(savedC.getCoordinatorId());


   }

}
