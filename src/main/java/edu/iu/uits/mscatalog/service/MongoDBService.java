package edu.iu.uits.mscatalog.service;


import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import edu.iu.uits.mscatalog.dto.MicroServiceEntityDTO;
import edu.iu.uits.mscatalog.exceptions.ServiceNotFoundException;
import edu.iu.uits.mscatalog.model.MicroServiceEntity;
import edu.iu.uits.mscatalog.repository.MicroServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This service class saves {@link MicroServiceEntity} objects to
 * MongoDB database.
 *
 * @author Naveen Jetty
 */

@Service
final class MongoDBService implements MicroServiceEntityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBService.class);

    private final MicroServiceRepository repository;

    @Autowired
    MongoDBService(MicroServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public MicroServiceEntityDTO create(MicroServiceEntityDTO ms) {
        LOGGER.info("Creating a new microservice entry with information: {}", ms);
        MicroServiceEntity persisted = MicroServiceEntity.builder().title(ms.getTitle()).description(ms.getDescription()).url(ms.getUrl()).build();
        persisted = repository.save(persisted);
        LOGGER.info("Created a new microservice entry with information: {}", persisted);
        return convertToDTO(persisted);
    }

    @Override
    public MicroServiceEntityDTO delete(String id) {
        LOGGER.info("Deleting a microservice entry with id: {}", id);

        MicroServiceEntity deleted = findMSById(id);
        repository.delete(deleted);

        LOGGER.info("Deleted microservice entry with informtation: {}", deleted);

        return convertToDTO(deleted);
    }

    @Override
    public List<MicroServiceEntityDTO> findAll() {
        LOGGER.info("Finding all microservice entries.");

        List<MicroServiceEntity> msEntries = repository.findAll();

        LOGGER.info("Found {} microservice entries", msEntries.size());

        return convertToDTOs(msEntries);
    }

    private List<MicroServiceEntityDTO> convertToDTOs(List<MicroServiceEntity> models) {
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    @Override
    public MicroServiceEntityDTO findById(String id) {
        LOGGER.info("Finding microservice entry with id: {}", id);

        MicroServiceEntity found = findMSById(id);

        LOGGER.info("Found microservice entry: {}", found);

        return convertToDTO(found);
    }

    @Override
    public MicroServiceEntityDTO update(MicroServiceEntityDTO ms) {
        LOGGER.info("Updating microservice entry with information: {}", ms);

        MicroServiceEntity updated = findMSById(ms.getId());
        updated.update(ms.getTitle(), ms.getDescription(), ms.getUrl(), ms.getEmail());
        updated = repository.save(updated);

        LOGGER.info("Updated microservice entry with information: {}", updated);

        return convertToDTO(updated);
    }

    private MicroServiceEntity findMSById(String id) {
        Optional<MicroServiceEntity> result = repository.findOne(id);
        return result.orElseThrow(() -> new ServiceNotFoundException(id));

    }

    private MicroServiceEntityDTO convertToDTO(MicroServiceEntity model) {
        MicroServiceEntityDTO dto = new MicroServiceEntityDTO();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setDescription(model.getDescription());
        dto.setUrl(model.getUrl());
        dto.setEmail(model.getEmail());

        return dto;
    }
}