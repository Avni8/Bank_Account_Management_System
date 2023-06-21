/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.repository;
import com.ams.model.IModelId;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author avni
 */
public abstract class CrudRepository <T extends IModelId> {
    
    private List<T> items;
    
    public CrudRepository(){
        
        this.items = new ArrayList<>();    
    }
    
    public void create(T object){
        items.add(object);
    }
    
    public T read(String id){
        for (T item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
        
    }
    public void update(T object){
        
        for(int i=0; i < items.size(); i++){
            T item = items.get(i);
            if(item.getId().equals(object.getId())){
                
                items.set(i,  object);
                break;
            }
        }
        
        
    }
   
    public void delete(String id){
        
    }
   
   
      
}
    
    

