package com.lushuang.cloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lushuang.cloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
