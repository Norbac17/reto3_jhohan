/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3_jhohan.reto3_jhohan.servicios;

import reto3_jhohan.reto3_jhohan.modelo.Client;
import reto3_jhohan.reto3_jhohan.repositorios.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mrcro
 */
@Service
public class ServiciosClient {
    @Autowired
    private RepositorioClient metodosCrud;
    
    
    public List<Client> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Client> getClient(int idClient){
        return metodosCrud.getClient(idClient);
    }
    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }
        else{
            Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(client);
            }
            else{
                return client;
            }
        }
    }
    public Client update(Client client){
        if (client.getIdClient()!=null) {
            Optional<Client> e=metodosCrud.getClient(client.getIdClient());
            if (!e.isEmpty()) {
                if(client.getEmail()!=null) {
                    e.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null) {
                    e.get().setPassword(client.getPassword());
                }
                if(client.getName()!=null) {
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null) {
                    e.get().setAge(client.getAge());
                }
                metodosCrud.save(e.get());
                return e.get();
            }
            else{
                return client;
            }
            
        }
        return client;
    }
    public boolean deleteClient(int clientId){
        Boolean d = getClient(clientId).map(client ->{
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
}
