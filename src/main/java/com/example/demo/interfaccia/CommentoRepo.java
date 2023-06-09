package com.example.demo.interfaccia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Commento;

public interface CommentoRepo extends JpaRepository<Commento, Integer>{

}
