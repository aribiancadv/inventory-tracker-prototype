package com.javatpoint.repository;
import org.springframework.data.repository.CrudRepository;
//repository that extends CrudRepository
import com.javatpoint.model.InvItems;
public interface ItemsRepository extends CrudRepository<InvItems, Integer>
{
}
