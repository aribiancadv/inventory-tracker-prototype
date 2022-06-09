package com.javatpoint.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.javatpoint.model.InvItems;
import com.javatpoint.service.ItemsService;
//mark class as Controller
@RestController
public class ItemsController 
{
//autowire the ItemsService class
@Autowired
ItemsService itemsService;
//creating a get mapping that retrieves all the items detail from the database 
@GetMapping("/items")
private List<InvItems> getAllItems() 
{
return itemsService.getAllItems();
}
//creating a get mapping that retrieves the detail of a specific item
@GetMapping("/items/{itemid}")
private InvItems getItems(@PathVariable("itemid") int itemid) 
{
return itemsService.getItemsById(itemid);
}
//creating a delete mapping that deletes a specified item
@DeleteMapping("/items/{itemid}")
private void deleteItem(@PathVariable("itemid") int itemid) 
{
itemsService.delete(itemid);
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
}
