package io.github.matheusbraynner.ms_customer.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 4740441653068200433L;

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
