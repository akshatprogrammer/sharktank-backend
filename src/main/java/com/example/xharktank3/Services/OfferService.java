package com.example.xharktank3.Services;

import com.example.xharktank3.Models.Offer;
import com.example.xharktank3.Repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepo;


    public Offer saveOffer(Offer offer) {
        return offerRepo.save(offer);
    }

}
