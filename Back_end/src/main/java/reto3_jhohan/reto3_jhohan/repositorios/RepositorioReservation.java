
package reto3_jhohan.reto3_jhohan.repositorios;

import reto3_jhohan.reto3_jhohan.interfaces.InterfaceReservation;
import reto3_jhohan.reto3_jhohan.modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mrcro
 */
@Repository
public class RepositorioReservation {
    @Autowired
    private InterfaceReservation crud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crud.findById(id);
    }
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }
}
