package com.nttdata.service;

import com.nttdata.domain.Deposit;
import com.nttdata.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DepositService {

    @Autowired
    private DepositRepository repository;


    public Flux<Deposit> getDeposit(){
        return repository.findAll();
    }

    //@Cacheable("deposit")
    public Mono<Deposit> getDepositById(String id){
        return repository.findById(id);
    }

    public Mono<Deposit> postDeposit(Deposit deposit){
        return repository.save(deposit);
    }

    public Mono<Deposit> updateDeposit(Deposit deposit){
        return repository.save(deposit);
    }

    public Mono<Void> deleteDeposit(String id){
        return repository.deleteById(id);
    }


}
