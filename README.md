# inventory-tracker-prototype
## Introduction
A CRUD web app to track inventory items for a logistics company.

## Tech
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Replit

## Endpoints and JSON Structure
### Get All Items
`/items` GET

Returns all items not marked as 'deleted'.
___
### Get Items by ID
`/items/{itemid}` GET

Returns an item by `itemid`.
___
### Delete an Item
`/items/delete` POST

Deletes an item by `itemid` while adding a comment.

```JSON
{
    "itemid": "1",
    "delcomment": "String comment."
}
```
___
### Saves an Item to the Database
`/items` POST

Creates an item in the database.
```JSON
{  
    "itemid": "1",  
    "itemname": "Rider Belt",  
    "manufacturer": "Banpresto",  
    "price": "5500"  
}
```
___
### Update an Item in the Database
`/items` PUT

Updates an existing item in the database by `itemid`.
```JSON
{  
    "itemid": "1",  
    "itemname": "Rider Belt Deluxe",  
    "manufacturer": "Bandai",  
    "price": "6000"  
}
```
___
### Undelete an Item
`/items/undelete` POST

Undeletes an item marked as 'deleted' by `itemid`.
```JSON
{  
    "itemid": "1"
}
```

