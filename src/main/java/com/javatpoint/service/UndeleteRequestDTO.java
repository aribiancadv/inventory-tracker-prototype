package com.javatpoint.service;

public class UndeleteRequestDTO {

    private int itemid;    
    
    public UndeleteRequestDTO(int itemid)
    {
        this.itemid = itemid;
    }

    public UndeleteRequestDTO()
    {
        
    }

    public int getItemid() 
    {
        return itemid;
    }

    public void setItemid(int itemid) 
    {
        this.itemid = itemid;
    }
    
}
