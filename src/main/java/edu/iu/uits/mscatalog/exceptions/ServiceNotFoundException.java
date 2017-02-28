package edu.iu.uits.mscatalog.exceptions;

/**
 * Created by naveenjetty on 2/25/17.
 */
public class ServiceNotFoundException extends RuntimeException{

    public ServiceNotFoundException(String id) {
        super(String.format("No todo entry found with id: <%s>", id));
    }

}
