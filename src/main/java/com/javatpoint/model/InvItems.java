package com.javatpoint.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table (name = "table_invitems")
@SQLDelete(sql = "UPDATE table_invitems SET deleted = true WHERE itemid=?")
@FilterDef(name = "deletedItemFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedItemFilter", condition = "deleted = :isDeleted")
public class InvItems
{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemid;
    @Column
    private String itemname;
    @Column
    private String manufacturer;
    @Column
    private int price;

    private boolean deleted = Boolean.FALSE;

    public int getItemid() 
    {
        return itemid;
    }

    public void setItemid(int itemid) 
    {
        this.itemid = itemid;
    }

    public String getItemname()
    {
        return itemname;
    }
    
    public void setItemname(String itemname) 
    {
        this.itemname = itemname;
    }
    
    public String getManufacturer() 
    {
        return manufacturer;
    }
    
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public int getPrice() 
    {
        return price;
    }
    
    public void setPrice(int price) 
    {
        this.price = price;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }

    public boolean getDeleted()
    {
        return deleted;
    }
}