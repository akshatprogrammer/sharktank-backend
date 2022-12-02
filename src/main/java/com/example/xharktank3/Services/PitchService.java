package com.example.xharktank3.Services;

import com.example.xharktank3.Models.Pitch;
import com.example.xharktank3.Repositories.PitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PitchService {

    @Autowired
    private PitchRepository pitchRepo;


    public Pitch savePitch(Pitch pitch){


        return pitchRepo.save(pitch);
    }

    public Pitch getPitchById(String id) {

        return pitchRepo.findById(id).orElse(null);
    }

    public List<Pitch> getAllPitches(){
        List<Pitch> pitches=pitchRepo.findAll();
        Collections.reverse(pitches);
        return pitches;
    }



}
