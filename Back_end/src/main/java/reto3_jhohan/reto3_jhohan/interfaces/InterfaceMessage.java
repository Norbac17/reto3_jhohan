/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reto3_jhohan.reto3_jhohan.interfaces;

import reto3_jhohan.reto3_jhohan.modelo.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mrcro
 */
public interface InterfaceMessage extends CrudRepository<Message, Integer>{
    
}
