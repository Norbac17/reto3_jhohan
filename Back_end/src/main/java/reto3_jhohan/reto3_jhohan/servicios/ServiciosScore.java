/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3_jhohan.reto3_jhohan.servicios;

import reto3_jhohan.reto3_jhohan.modelo.Score;
import reto3_jhohan.reto3_jhohan.repositorios.RepositorioScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mrcro
 */
@Service
public class ServiciosScore {
        @Autowired
    private RepositorioScore metodosCrud;
    
    
    public List<Score> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Score> getScore(int idSkate){
        return metodosCrud.getScore(idSkate);
    }
    public Score save(Score score){
        if(score.getId()==null){
            return metodosCrud.save(score);
        }
        else{
            Optional<Score> evt=metodosCrud.getScore(score.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(score);
            }
            else{
                return score;
            }
        }
    }
    public Score update(Score score){
        if (score.getId()!=null) {
            Optional<Score> e=metodosCrud.getScore(score.getId());
            if (!e.isEmpty()) {
                if(score.getScore()!=null) {
                    e.get().setScore(score.getScore());
                }
                return e.get();
            }
            else{
                return score;
            }
            
        }
        return score;
    }
    public boolean deleteScore(int scoreId){
        Boolean d = getScore(scoreId).map(score ->{
            metodosCrud.delete(score);
            return true;
        }).orElse(false);
        return d;
    }
}
