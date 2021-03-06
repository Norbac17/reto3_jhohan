/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3_jhohan.reto3_jhohan.servicios;

import reto3_jhohan.reto3_jhohan.modelo.Reservation;
import reto3_jhohan.reto3_jhohan.repositorios.RepositorioReservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mrcro
 */
@Service
public class ServiciosReservation {
    @Autowired
    private RepositorioReservation metodosCrud;
    
    
    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Reservation> getReservation(int idReservation){
        return metodosCrud.getReservation(idReservation);
    }
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }
        else{
            Optional<Reservation> evt=metodosCrud.getReservation(reservation.getIdReservation());
            if(evt.isEmpty()){
                return metodosCrud.save(reservation);
            }
            else{
                return reservation;
            }
        }
    }
    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation()!=null) {
            Optional<Reservation> e=metodosCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if(reservation.getStartDate()!=null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null) {
                    e.get().setStatus(reservation.getStatus());
                }
                if(reservation.getSkate()!=null) {
                    e.get().setSkate(reservation.getSkate());
                }
                if(reservation.getClient()!=null) {
                    e.get().setClient(reservation.getClient());
                }
                if(reservation.getScore()!=null) {
                    e.get().setScore(reservation.getScore());
                }
                metodosCrud.save(e.get());
                return e.get();
            }
            else{
                return reservation;
            }
            
        }
        return reservation;
    }
    public boolean deleteReservation(int reservationId){
        Boolean d = getReservation(reservationId).map(reservation ->{
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}
