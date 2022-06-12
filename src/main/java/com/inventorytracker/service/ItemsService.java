package com.inventorytracker.service;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventorytracker.model.InvItems;
import com.inventorytracker.repository.ItemsRepository;
import org.hibernate.Filter;
import org.hibernate.Session;

@Service
public class ItemsService 
{
    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private EntityManager entityManager;

    
    /** 
     * Get items from item repository by id.
     * @param id
     * @return InvItems
     */
    public InvItems getItemsById(int id) 
    {
        return itemsRepository.findById(id).get();
    }

    
    /** 
     * Saves or updates to item repository.
     * @param items
     */
    public void saveOrUpdate(InvItems items) 
    {
        itemsRepository.save(items);
    }

    
    /** 
     * Deletes an item by id.
     * @param id
     */
    public void delete(int id)
    {        
        itemsRepository.deleteById(id);
    }

    
    /** 
     * Updates an existing item.
     * @param items
     * @param itemid
     */
    public void update(InvItems items, int itemid) 
    {
        itemsRepository.save(items);
    }

    
    /** 
     * Creates an InvItems object.
     * @param invitem
     * @return InvItems
     */
    public InvItems create(InvItems invitem)
    {
        return itemsRepository.save(invitem);
    }

    
    /** 
     * Gets a list of all items by deletion status.
     * @param isDeleted
     * @return Iterable<InvItems>
     */
    public Iterable<InvItems> getAllItems(boolean isDeleted)
    {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedItemFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<InvItems> invitems = itemsRepository.findAll();
        session.disableFilter("deletedItemFilter");

        return invitems;
    }
}