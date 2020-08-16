package com.in28Minutes.springbootin28Minutesrestdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28Minutes.springbootin28Minutesrestdemo.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
