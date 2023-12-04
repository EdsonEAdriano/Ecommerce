package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.DTOs.BuyDTO;
import com.ecommerce.ecommerce.Models.Buy;
import com.ecommerce.ecommerce.Models.Product;
import com.ecommerce.ecommerce.Repositories.IBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    private IBuyRepository _buyRepository;

    @PostMapping
    public Buy post(@RequestBody BuyDTO buyDTO){
        Buy buy = new Buy();
        buy.setBuyer(buyDTO.getBuyer());
        buy.setTotalPrice(buyDTO.getTotalPrice());


        return _buyRepository.save(buy);
    }

    @GetMapping
    public Iterable<Buy> get(){
        return _buyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Buy get(@PathVariable int id){
        return _buyRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Buy put(@PathVariable Integer id, @RequestBody BuyDTO buyDTO){
        Buy buy = new Buy();
        buy.setId(id);
        buy.setBuyer(buyDTO.getBuyer());
        buy.setTotalPrice(buyDTO.getTotalPrice());


        return _buyRepository.save(buy);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        _buyRepository.deleteById(id);
    }
}
