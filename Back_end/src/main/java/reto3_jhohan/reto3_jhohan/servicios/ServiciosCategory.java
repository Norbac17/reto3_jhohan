
package reto3_jhohan.reto3_jhohan.servicios;

import reto3_jhohan.reto3_jhohan.modelo.Category;
import reto3_jhohan.reto3_jhohan.repositorios.RepositorioCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mrcro
 */

@Service
public class ServiciosCategory {
    @Autowired
    private RepositorioCategory metodosCrud;
    
    
    public List<Category> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Category> getCategory(int idCategory){
        return metodosCrud.getCategory(idCategory);
    }
    public Category save(Category category){
        if(category.getId()==null){
            return metodosCrud.save(category);
        }
        else{
            Optional<Category> evt=metodosCrud.getCategory(category.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(category);
            }
            else{
                return category;
            }
        }
    }
}
