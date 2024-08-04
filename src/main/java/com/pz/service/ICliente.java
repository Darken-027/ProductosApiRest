package com.pz.service;

import com.pz.model.dto.ClienteDto;

public interface ICliente {

    ClienteDto save(ClienteDto cliente);

    ClienteDto findById(Integer id);

    void delete(ClienteDto cliente);
}
