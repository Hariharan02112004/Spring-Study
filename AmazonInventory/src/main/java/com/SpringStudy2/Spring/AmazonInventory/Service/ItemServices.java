package com.SpringStudy2.Spring.AmazonInventory.Service;

import com.SpringStudy2.Spring.AmazonInventory.Model.Items;
import com.SpringStudy2.Spring.AmazonInventory.Repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServices {

    private ItemRepo repoItem;

    public ItemRepo getRepoItem() {
        return repoItem;
    }
    @Autowired
    public void setRepoItem(ItemRepo repoItem) {
        this.repoItem = repoItem;
    }
    public void InsertItem(Items item){
        repoItem.save(item);
    }
    public List<Items> getAll(){
        return repoItem.findAll();
    }
}
