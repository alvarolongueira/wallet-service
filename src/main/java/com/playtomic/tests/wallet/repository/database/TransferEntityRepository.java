package com.playtomic.tests.wallet.repository.database;

import org.springframework.data.repository.CrudRepository;

import com.playtomic.tests.wallet.repository.entity.TransferEntity;

interface TransferEntityRepository extends CrudRepository<TransferEntity, Long> {


}
