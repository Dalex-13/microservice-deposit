package com.nttdata.controller;

import com.nttdata.domain.Deposit;
import com.nttdata.service.DepositService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/deposit")
@RequiredArgsConstructor
public class DepositController {

    @Autowired
    private DepositService depositService;

    @GetMapping
    public Flux<Deposit> getDeposit(){
        log.info("listado de todos los depositos");
        return depositService.getDeposit().cache();
    }

    @GetMapping("/{id}")
    public Mono<Deposit> getDepositById(@PathVariable String id){
        log.info("listado por ID");
        return depositService.getDepositById(id);
    }

    @PostMapping("/add")
    public Mono<Deposit> putDeposit( @RequestBody Deposit deposit){
        log.info("creación de deposito");
        return depositService.postDeposit(deposit);
    }

    @PutMapping("/{id}")
    public Mono<Deposit> updateDeposit(@RequestBody Deposit deposit){
        log.info("Actualizar por Id");
        return depositService.updateDeposit(deposit);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteDeposit(@PathVariable String id){
        return depositService.deleteDeposit(id);
    }

}
