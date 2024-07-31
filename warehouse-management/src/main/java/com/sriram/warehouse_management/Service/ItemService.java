package com.sriram.warehouse_management.Service;

//import com.sriram.warehouse_management.Model.Item;
//import com.sriram.warehouse_management.exception.ItemNotFoundException;
//import com.sriram.warehouse_management.repository.ItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class ItemService
//{
//    @Autowired
//    private ItemRepository itemRepository;
//
//    public Item addItem(Item item)
//    {
//        return itemRepository.save(item);
//    }
//
//    public Item updateItem(Long id, String type, int quantity)
//    {
//        Item item = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
//        item.setType(type);
//        item.setQuantity(quantity);
//        return itemRepository.save(item);
//    }
//
//    public void deleteItemById(Long id)
//    {
//        itemRepository.deleteById(id);
//    }
//
//    public void deleteItemByName(String name)
//    {
//        Item item = itemRepository.findByName(name).orElseThrow(() -> new ItemNotFoundException(name));
//        itemRepository.delete(item);
//    }
//}

import com.sriram.warehouse_management.Model.Item;
import com.sriram.warehouse_management.dao.ItemDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemDao itemDao;

    public ItemService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public Optional<Item> getItemById(Long id) {
        return itemDao.findById(id);
    }

    public List<Item> getAllItems() {
        return itemDao.findAll();
    }

    public void addItem(Item item) {
        itemDao.save(item);
    }

    public void updateItem(Item item) {
        itemDao.update(item);
    }

    public void deleteItem(Long id) {
        itemDao.delete(id);
    }
}
