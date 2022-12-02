package com.example.xharktank3.Repositories;

import com.example.xharktank3.Models.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitchRepository extends JpaRepository<Pitch,String> {

}
