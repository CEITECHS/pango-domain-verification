package com.ceitechs.domain.verification.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * @author iddymagohe
 * @since 0.1
 *
 */
@Getter
@Setter
@Document(collection = "coordinators")
@TypeAlias("coordinators")
public class Coordinator {
    @Id
    private long coordinatorId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Indexed
    private String emailAddress;
    private String addressLine1;
    private String addressLine2;
    private String City;
    private String State;
    private String zip;
    private String country;
    private LocalDate joinedDate;
    private String password;
    private  boolean active;
    @GeoSpatialIndexed(type= GeoSpatialIndexType.GEO_2DSPHERE)
    private double[] nearbyLocation;
}
