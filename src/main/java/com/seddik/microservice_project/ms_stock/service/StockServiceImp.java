package com.seddik.microservice_project.ms_stock.service;

import com.seddik.microservice_project.ms_stock.entities.Stock;
import com.seddik.microservice_project.ms_stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StockServiceImp implements IStockService{
    private final StockRepository stockRepository;
    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Map<Object, Object> fields, long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        Assert.isTrue(stock.isPresent(),"Stock not found");
        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Stock.class,(String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,stock.get(),value);
        });
        return stockRepository.save(stock.get());
    }

    @Override
    public Stock retriveStockById(long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        Assert.isTrue(stock.isPresent(),"Stock not found");
        return stock.get();
    }

    @Override
    public List<Stock> retriveAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public void removeStock(long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        Assert.isTrue(stock.isPresent(),"Stock not found");
         stockRepository.delete(stock.get());

    }
}
