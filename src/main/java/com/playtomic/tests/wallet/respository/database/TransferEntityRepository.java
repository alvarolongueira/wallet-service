package com.playtomic.tests.wallet.respository.database;

import org.springframework.data.repository.CrudRepository;

import com.playtomic.tests.wallet.respository.entity.TransferEntity;

interface TransferEntityRepository extends CrudRepository<TransferEntity, Long> {


}