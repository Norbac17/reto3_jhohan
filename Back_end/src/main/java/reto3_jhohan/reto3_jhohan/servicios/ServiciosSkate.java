
package reto3_jhohan.reto3_jhohan.servicios;

import java.util.List;
import java.util.Optional;
import reto3_jhohan.reto3_jhohan.modelo.Skate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3_jhohan.reto3_jhohan.repositorios.RepositorioSkate;


/**
 *
 * @author Jhohan
 */
@Service
public class ServiciosSkate {
    @Autowired
    private RepositorioSkate metodosCrud;
    
    
    public List<Skate> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Skate> getSkate(int idSkate){
        return metodosCrud.getSkate(idSkate);
    }
    public Skate save(Skate skate){
        if(skate.getId()==null){
            return metodosCrud.save(skate);
        }
        else{
            Optional<Skate> evt=metodosCrud.getSkate(skate.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(skate);
            }
            else{
                return skate;
            }
        }
    }
}
