package com.david.muroMensajes.datos.roles;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDAO extends CrudRepository<Roles, String> {

}
