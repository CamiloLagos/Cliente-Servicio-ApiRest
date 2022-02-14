package com.persona.client;

import com.persona.modelo.Imagen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "service-imagen", url = "http://localhost:3006")

//@RequestMapping(value = "/imagenes")
public interface ImagenClient {

    //@GetMapping(value = "/{id}")
    @RequestMapping(method = RequestMethod.GET, value = "/imagenes/{id}")
    ResponseEntity<Imagen> buscarImagen (@PathVariable("id")int id);

    @RequestMapping(method = RequestMethod.POST, value = "/imagenes/")
    ResponseEntity<Imagen> crearImagen (@RequestBody Imagen imagen);

}
