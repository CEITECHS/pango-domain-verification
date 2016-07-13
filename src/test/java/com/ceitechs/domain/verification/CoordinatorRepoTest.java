package com.ceitechs.domain.verification;


import com.ceitechs.domain.verification.domain.Coordinator;
import com.ceitechs.domain.verification.repositories.CoordinatorRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Test
    public void readTest(){
        List<Coordinator> ls = coordinatorRepository.findAll();
        assertNotNull(ls);
        assertTrue(!ls.isEmpty());
        ls.forEach(a -> System.out.println(a.getCoordinatorId() + " - " +a.getFirstName() + " - " + a.getLastName()));
    }

}
