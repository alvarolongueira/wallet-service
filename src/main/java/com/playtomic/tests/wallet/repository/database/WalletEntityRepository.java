package com.playtomic.tests.wallet.repository.database;

import org.springframework.data.repository.CrudRepository;

import com.playtomic.tests.wallet.repository.entity.WalletEntity;

public interface WalletEntityRepository extends CrudRepository<WalletEntity, Long> {

}
