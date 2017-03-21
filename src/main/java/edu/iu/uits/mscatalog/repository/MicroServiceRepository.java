package edu.iu.uits.mscatalog.repository;

import edu.iu.uits.mscatalog.model.MicroServiceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Naveen Jetty
 */

@RepositoryRestResource(collectionResourceRel = "catalog", path="catalog")
public interface MicroServiceRepository extends PagingAndSortingRepository<MicroServiceEntity, String> {


}
