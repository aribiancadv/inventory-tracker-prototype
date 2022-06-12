package com.inventorytracker.repository;
import org.springframework.data.repository.CrudRepository;
//repository that extends CrudRepository
import com.inventorytracker.model.InvItems;
public interface ItemsRepository extends CrudRepository<InvItems, Integer>
{
}
