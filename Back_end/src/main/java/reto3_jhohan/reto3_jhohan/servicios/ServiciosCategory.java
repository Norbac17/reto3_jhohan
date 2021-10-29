
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
    public Category update(Category category){
        if (category.getId()!=null) {
            Optional<Category> e=metodosCrud.getCategory(category.getId());
            if (!e.isEmpty()) {
                if(category.getName()!=null) {
                    e.get().setName(category.getName());
                }
                if(category.getDescription()!=null) {
                    e.get().setDescription(category.getDescription());
                }
                return metodosCrud.save(e.get());
            }
            else{
                return category;
            }
        }
        return category;
    }
    public boolean deleteCategory(int categoryId){
        Boolean d = getCategory(categoryId).map(category ->{
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
