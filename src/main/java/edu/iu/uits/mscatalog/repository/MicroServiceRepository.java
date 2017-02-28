package edu.iu.uits.mscatalog.repository;

import edu.iu.uits.mscatalog.model.MicroServiceEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Naveen Jetty
 */

public interface MicroServiceRepository extends Repository<MicroServiceEntity, String> {
    /**
     * Deletes a Microservice entry from the database.
     * @param deleted   The deleted MS entry.
     */
    void delete(MicroServiceEntity deleted);

    /**
     * Finds all Microservice entries from the database.
     * @return  The information of all Microservice entries that are found from the database.
     */
    List<MicroServiceEntity> findAll();

    /**
     * Finds the information of a single Microservice entry.
     * @param id    The id of the requested Microservice entry.
     * @return      The information of the found Microservice entry. If no Microservice entry
     *              is found, this method returns an empty {@link java.util.Optional} object.
     */
    Optional<MicroServiceEntity> findOne(String id);

    /**
     * Saves a new Microservice entry to the database.
     * @param saved The information of the saved Microservice entry.
     * @return      The information of the saved Microservice entry.
     */
    MicroServiceEntity save(MicroServiceEntity saved);
}
