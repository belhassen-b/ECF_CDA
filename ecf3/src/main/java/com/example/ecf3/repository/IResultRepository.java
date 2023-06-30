package com.example.ecf3.repository;


import com.example.ecf3.entity.Game;
import com.example.ecf3.entity.Result;
import com.example.ecf3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResultRepository extends JpaRepository<Result, Long> {

}
