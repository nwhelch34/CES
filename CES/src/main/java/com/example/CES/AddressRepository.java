package com.example.CES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    //List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);
}
