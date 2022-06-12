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


@RestController
public class ItemsController 
{
    @Autowired
    ItemsService itemsService;

    
    /** 
     * Retrieve all items. NOTE: Does not return items marked as 'deleted'.
     *  @return Iterable<InvItems>
     */
    @GetMapping("/items")
    private Iterable<InvItems> getAllItems() 
    {
        return itemsService.getAllItems(false);
    }

    
    /** 
     * Get individual item by item id.
     * @param itemid
     * @return InvItems
     */
    @GetMapping("/items/{itemid}")
    private InvItems getItems(@PathVariable("itemid") int itemid) 
    {
        return itemsService.getItemsById(itemid);
    }

    
    /** 
     * Deletes items (marks them as 'deleted' and adds a comment).
     * @param delreq
     */
    @PostMapping("/items/delete")
    private void deleteItem(@RequestBody DeleteRequestDTO delreq) 
    {
        InvItems itemToDelete = itemsService.getItemsById(delreq.getItemid());
        
        itemToDelete.setDeletionComment(delreq.getDeletionComment());
        itemsService.saveOrUpdate(itemToDelete);
        itemsService.delete(delreq.getItemid());
    }

    
    /** 
     * Saves an item to the database.
     * @param items
     * @return int
     */
    @PostMapping("/items")
    private int saveItem(@RequestBody InvItems items) 
    {
        itemsService.saveOrUpdate(items);

        return items.getItemid();
    }

    
    /** 
     * Updates an existing item.
     * @param items
     * @return InvItems
     */
    @PutMapping("/items")
    private InvItems update(@RequestBody InvItems items) 
    {
        itemsService.saveOrUpdate(items);

        return items;
    }

    
    /** 
     * Undeletes an item marked as 'deleted'.
     * @param undelreq
     * @return InvItems
     */
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
