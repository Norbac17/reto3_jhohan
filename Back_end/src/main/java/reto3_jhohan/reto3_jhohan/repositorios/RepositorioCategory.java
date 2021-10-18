
package reto3_jhohan.reto3_jhohan.repositorios;

import reto3_jhohan.reto3_jhohan.interfaces.InterfaceCategory;
import reto3_jhohan.reto3_jhohan.modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mrcro
 */

@Repository
public class RepositorioCategory {
    @Autowired
    private InterfaceCategory crud;
    
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    public Optional<Category> getCategory(int id){
        return crud.findById(id);
    }
    public Category save(Category category){
        return crud.save(category);
    }
}
