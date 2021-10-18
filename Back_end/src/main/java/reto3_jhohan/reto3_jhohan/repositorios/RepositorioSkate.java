
package reto3_jhohan.reto3_jhohan.repositorios;


import reto3_jhohan.reto3_jhohan.interfaces.InterfaceSkate;
import java.util.List;
import java.util.Optional;
import reto3_jhohan.reto3_jhohan.modelo.Skate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jhohan
 */

@Repository
public class RepositorioSkate {
    @Autowired
    private InterfaceSkate crud;
    
    public List<Skate> getAll(){
        return (List<Skate>) crud.findAll();
    }
    public Optional<Skate> getSkate(int id){
        return crud.findById(id);
    }
    public Skate save(Skate skate){
        return crud.save(skate);
    }
}
