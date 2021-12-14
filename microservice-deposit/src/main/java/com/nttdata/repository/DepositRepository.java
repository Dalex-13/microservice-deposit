package com.nttdata.repository;

import com.nttdata.domain.Deposit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepositRepository extends ReactiveCrudRepository<Deposit, String> {



}
