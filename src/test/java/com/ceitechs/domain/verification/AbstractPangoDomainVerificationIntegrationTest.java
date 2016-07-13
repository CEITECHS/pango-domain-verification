package com.ceitechs.domain.verification;

import com.ceitechs.domain.verification.config.MongoConfiguration;
import com.ceitechs.domain.verification.config.PangoDomainVerificationServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"db.host.name = localhost:27017",
        "db.password = pangoPreprodVerifyWriteUsrPass10" ,"db.user =pangoVerifyWriteUser",
        "db.name = pango-verification" })
@ContextConfiguration(classes = {PangoDomainVerificationServiceConfig.class})
public class AbstractPangoDomainVerificationIntegrationTest {

}
