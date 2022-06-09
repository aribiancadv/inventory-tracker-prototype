package com.javatpoint.service;


public class DeleteRequestDTO {

    private int itemid;
    private String delcomment;


    public DeleteRequestDTO(int itemid, String delcomment)
    {
        this.itemid = itemid;
        this.delcomment = delcomment;
    }

    public int getItemid() 
    {
        return itemid;
    }

    public void setItemid(int itemid) 
    {
        this.itemid = itemid;
    }

    public void setDeletionComment(String delcomment)
    {
        this.delcomment = delcomment;
    }

    public String getDeletionComment()
    {
        return delcomment;
    }
    
}
