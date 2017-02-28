package edu.iu.uits.mscatalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.iu.uits.mscatalog.dto.MicroServiceEntityDTO;
import edu.iu.uits.mscatalog.exceptions.ServiceNotFoundException;
import edu.iu.uits.mscatalog.service.MicroServiceEntityService;

/**
 * Created by naveenjetty on 2/23/17.
 */

@RestController
@RequestMapping("/api/catalog")
public class MicroServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MicroServiceController.class);

    private final MicroServiceEntityService service;

    @Autowired
    MicroServiceController(MicroServiceEntityService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    MicroServiceEntityDTO create(@RequestBody @Valid MicroServiceEntityDTO MSEntry) {
        LOGGER.info("Creating a new microservice entry with information: {}", MSEntry);
        MicroServiceEntityDTO created = service.create(MSEntry);
        LOGGER.info("Created a new microservice entry with information: {}", created);
        return created;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    MicroServiceEntityDTO delete(@PathVariable("id") String id) {
        LOGGER.info("Deleting microservice entry with id: {}", id);

        MicroServiceEntityDTO deleted = service.delete(id);
        LOGGER.info("Deleted microservice entry with information: {}", deleted);

        return deleted;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<MicroServiceEntityDTO> findAll() {
        LOGGER.info("Finding all microservice entries");

        List<MicroServiceEntityDTO> msEntries = service.findAll();
        LOGGER.info("Found {} microservice entries", msEntries.size());

        return msEntries;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    MicroServiceEntityDTO findById(@PathVariable("id") String id) {
        LOGGER.info("Finding microservice entry with id: {}", id);

        MicroServiceEntityDTO msEntry = service.findById(id);
        LOGGER.info("Found microservice entry with information: {}", msEntry);

        return msEntry;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    MicroServiceEntityDTO update(@RequestBody @Valid MicroServiceEntityDTO msEntry) {
        LOGGER.info("Updating microservice entry with information: {}", msEntry);

        MicroServiceEntityDTO updated = service.update(msEntry);
        LOGGER.info("Updated microservice entry with information: {}", updated);

        return updated;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(ServiceNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
    }

}
