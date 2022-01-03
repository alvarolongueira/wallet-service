package com.playtomic.tests.wallet.respository.database;

import org.springframework.data.repository.CrudRepository;

import com.playtomic.tests.wallet.respository.entity.WalletEntity;

public interface WalletRepository extends CrudRepository<WalletEntity, Long> {

}
