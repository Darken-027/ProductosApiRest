package com.pz.controller;


    import com.pz.model.dto.ClienteDto;
    import com.pz.service.ICliente;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.dao.DataAccessException;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.HashMap;
    import java.util.Map;

@RestController
    @RequestMapping("/api/v1")
    public class ClienteController {

        @Autowired
        private ICliente clienteService;

        @PostMapping("cliente")
        @ResponseStatus(HttpStatus.CREATED)
        public ClienteDto create(@RequestBody ClienteDto cliente){
            return clienteService.save(cliente);
        }

        @PutMapping("cliente")
        @ResponseStatus(HttpStatus.CREATED)
        public ClienteDto update(@RequestBody ClienteDto cliente){
            return clienteService.save(cliente);
        }

        @DeleteMapping("cliente/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id){
            Map<String, Object> response = new HashMap<>();
             try {
                 ClienteDto clienteDelete = clienteService.findById(id);
                 clienteService.delete(clienteDelete);
                 return  new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
             }catch (DataAccessException exDt){
                 response.put("mensaje", exDt.getMessage());
                 response.put("cliente", null);
                 return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
             }
        }

        @GetMapping("cliente/{id}")
        @ResponseStatus(HttpStatus.OK)
        public ClienteDto showById(@PathVariable Integer id){
            return clienteService.findById(id);
        }
    }



























