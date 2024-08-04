package com.pz.service.impl;

import com.pz.model.dao.ClienteDao;
import com.pz.model.dto.ClienteDto;
import com.pz.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteImpl implements ICliente {

    @Autowired
    private ClienteDao clienteDao;

    @Transactional(readOnly = true)
    @Override
    public ClienteDto save(ClienteDto cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public ClienteDto findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(ClienteDto cliente) {
        clienteDao.delete(cliente);
    }
}
