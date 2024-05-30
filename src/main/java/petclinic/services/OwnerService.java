package petclinic.services;

import petclinic.model.Owner;
import petclinic.services.CrudService;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameLike(String lastName);
}
