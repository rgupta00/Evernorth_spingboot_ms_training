package com.productapp.service.schedulers;

import com.productapp.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CacheInvalidatorSchedular {

    private ProductService productService;

    @Autowired
    public CacheInvalidatorSchedular(ProductService productService) {
        this.productService = productService;
    }

    @Scheduled(cron = "0,10 * * * * *")
    public void foo(){
        log.info("-----------------Cache invalidator is called------------------------");
        productService.removeCache();
    }
}
