package com.seddik.microservice_project.ms_stock.controller;

import com.seddik.microservice_project.ms_stock.entities.Stock;
import com.seddik.microservice_project.ms_stock.service.StockServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {
    private final StockServiceImp stockServiceImp;

    @PatchMapping("/{id}")
    public Stock updateStock(@RequestBody Map<Object, Object> fields, @PathVariable long id){
        return stockServiceImp.updateStock(fields,id);
    }
    @PostMapping("/ajouterStock")
public Stock ajouterStock(@RequestBody Stock stock){
        return stockServiceImp.createStock(stock);
    }

    @GetMapping("/getstck/{id}")
    public Stock retriveStockById(@PathVariable long id){

        return stockServiceImp.retriveStockById(id);
    }

}
