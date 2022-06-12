package com.inventorytracker.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.inventorytracker.model.InvItems;
import com.inventorytracker.service.DeleteRequestDTO;
import com.inventorytracker.service.ItemsService;
import com.inventorytracker.service.UndeleteRequestDTO;

//mark class as Controller
@RestController
public class ItemsController 
{
    //autowire the ItemsService class
    @Autowired
    ItemsService itemsService;
    //creating a get mapping that retrieves all the items detail from the database 
    @GetMapping("/items")
    private Iterable<InvItems> getAllItems() 
    {
        return itemsService.getAllItems(false);
    }

    //creating a get mapping that retrieves the detail of a specific item
    @GetMapping("/items/{itemid}")
    private InvItems getItems(@PathVariable("itemid") int itemid) 
    {
        return itemsService.getItemsById(itemid);
    }

    //creating a delete mapping that deletes a specified item
    @PostMapping("/items/delete")
    private void deleteItem(@RequestBody DeleteRequestDTO delreq) 
    {
        InvItems itemToDelete = itemsService.getItemsById(delreq.getItemid());
        
        itemToDelete.setDeletionComment(delreq.getDeletionComment());
        itemsService.saveOrUpdate(itemToDelete);
        itemsService.delete(delreq.getItemid());
    }

    //creating post mapping that post the item detail in the database
    @PostMapping("/items")
    private int saveItem(@RequestBody InvItems items) 
    {
        itemsService.saveOrUpdate(items);

        return items.getItemid();
    }

    //creating put mapping that updates the item detail 
    @PutMapping("/items")
    private InvItems update(@RequestBody InvItems items) 
    {
        itemsService.saveOrUpdate(items);

        return items;
    }

    @PutMapping("/items/undelete")
    private InvItems undelete(@RequestBody UndeleteRequestDTO undelreq) 
    {
        InvItems itemToUndelete = itemsService.getItemsById(undelreq.getItemid());

        itemsService.saveOrUpdate(itemToUndelete);
        itemToUndelete.setDeleted(false);
        itemToUndelete.setDeletionComment("");

        return itemToUndelete;
    }
}
