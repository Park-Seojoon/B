package com.anything.s3.domain.auth.repository;

import com.anything.s3.domain.auth.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BlackListRepository extends CrudRepository<BlackList, String> {
}
