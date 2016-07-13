package com.ceitechs.domain.verification.repositories;

import com.ceitechs.domain.verification.domain.Coordinator;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

/**
 * @author iddymagohe
 * @since 0.1
 *
 */
public interface CoordinatorRepository  extends MongoRepository<Coordinator, BigInteger>{
}
