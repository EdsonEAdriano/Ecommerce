package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.DTOs.ItemDTO;
import com.ecommerce.ecommerce.DTOs.ProductDTO;
import com.ecommerce.ecommerce.Models.Buy;
import com.ecommerce.ecommerce.Models.Category;
import com.ecommerce.ecommerce.Models.Item;
import com.ecommerce.ecommerce.Models.Product;
import com.ecommerce.ecommerce.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private IItemRepository _itemRepository;
    @Autowired
    private IProductRepository _productRepository;
    @Autowired
    private IBuyRepository _buyRepository;

    @PostMapping
    public Item post(@RequestBody ItemDTO itemDTO){
        Product product = _productRepository.findById(itemDTO.getProductID()).orElse(null);
        Buy buy = _buyRepository.findById(itemDTO.getBuyID()).orElse(null);

        Item item = new Item();
        item.setProduct(product);
        item.setBuy(buy);
        item.setQuantity(itemDTO.getQuantity());


        return _itemRepository.save(item);
    }

    @GetMapping
    public Iterable<Item> get(){
        return _itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable int id){
        return _itemRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Item put(@PathVariable Integer id, @RequestBody ItemDTO itemDTO){
        Product product = _productRepository.findById(itemDTO.getProductID()).orElse(null);
        Buy buy = _buyRepository.findById(itemDTO.getBuyID()).orElse(null);

        Item item = new Item();
        item.setId(id);
        item.setProduct(product);
        item.setBuy(buy);
        item.setQuantity(itemDTO.getQuantity());


        return _itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        _itemRepository.deleteById(id);
    }
}
