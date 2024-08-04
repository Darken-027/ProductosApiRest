package com.pz.model.dao;

import com.pz.model.dto.ClienteDto;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<ClienteDto, Integer> {
}
