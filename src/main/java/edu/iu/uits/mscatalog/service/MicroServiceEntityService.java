package edu.iu.uits.mscatalog.service;



import edu.iu.uits.mscatalog.dto.MicroServiceEntityDTO;
import edu.iu.uits.mscatalog.model.MicroServiceEntity;

import java.util.List;

/**
 * This interface declares the methods that provides CRUD operations for
 * {@link MicroServiceEntity} objects.
 */
public interface MicroServiceEntityService {

    /**
     * Creates a new microservice entry.
     * @param ms  The information of the created microservice entry.
     * @return      The information of the created microservice entry.
     */
    MicroServiceEntityDTO create(MicroServiceEntityDTO ms);

    /**
     * Deletes a ms entry.
     * @param id    The id of the deleted microservice entry.
     * @return      THe information of the deleted microservice entry.
     * @throws edu.iu.uits.mscatalog.exceptions.ServiceNotFoundException if no Microservice entry is found.
     */
    MicroServiceEntityDTO delete(String id);

    /**
     * Finds all microservice entries.
     * @return      The information of all microservice entries.
     */
    List<MicroServiceEntityDTO> findAll();

    /**
     * Finds a single microservice entry.
     * @param id    The id of the requested microservice entry.
     * @return      The information of the requested microservice entry.
     * @throws edu.iu.uits.mscatalog.exceptions.ServiceNotFoundException if no microservice entry is found.
     */
    MicroServiceEntityDTO findById(String id);

    /**
     * Updates the information of a microservice entry.
     * @param ms  The information of the updated microservice entry.
     * @return      The information of the updated microservice entry.
     * @throws edu.iu.uits.mscatalog.exceptions.ServiceNotFoundException if no microservice entry is found.
     */
    MicroServiceEntityDTO update(MicroServiceEntityDTO ms);
}