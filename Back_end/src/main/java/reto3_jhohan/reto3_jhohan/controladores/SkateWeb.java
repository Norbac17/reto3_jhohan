
package reto3_jhohan.reto3_jhohan.controladores;

import java.util.List;
import java.util.Optional;
import reto3_jhohan.reto3_jhohan.modelo.Skate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reto3_jhohan.reto3_jhohan.servicios.ServiciosSkate;


/**
 *
 * @author Mrcro
 */
@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SkateWeb {
    
    @Autowired
    private ServiciosSkate servicios;
    @GetMapping("/all")
    public List<Skate> getSkate(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Skate> getSkate(@PathVariable("id") int idSkate){
        return servicios.getSkate(idSkate);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate skate){
        return servicios.save(skate);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate update(@RequestBody Skate skate){
        return servicios.update(skate);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId){
        return servicios.deleteSkate(categoryId);
    }
}
