package com.example.xharktank3.Controllers;

import com.example.xharktank3.Models.Offer;
import com.example.xharktank3.Models.Pitch;
import com.example.xharktank3.Services.OfferService;
import com.example.xharktank3.Services.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private PitchService pitchService;

    @RequestMapping(method = RequestMethod.POST, value = "/pitches/{pitchId}/makeOffer")
    public Map<String, String> saveOffer(@PathVariable("pitchId") String pitchId,
                                         @RequestBody Map<String, Object> offer, HttpServletResponse response) {
        HashMap<String, String> map = new HashMap<>();

        Pitch p = pitchService.getPitchById(pitchId);
        if (p == null) {

            response.setStatus(404);
            return null;
        }
        try {
            if (offer.containsKey("investor") && offer.containsKey("amount") && offer.containsKey("equity")
                    && offer.containsKey("comment") && offer.get("investor") != null && offer.get("amount") != null
                    && offer.get("equity") != null && offer.get("comment") != null
                    && Float.parseFloat(offer.get("amount").toString()) >= 0
                    && Float.parseFloat(offer.get("equity").toString()) >= 0
                    && Float.parseFloat(offer.get("equity").toString()) <= 100) {

                Offer o = new Offer();
                o.setAmount(Float.parseFloat(offer.get("amount").toString()));
                o.setComment(offer.get("comment").toString());
                o.setEquity(Float.parseFloat(offer.get("equity").toString()));
                o.setInvestor(offer.get("investor").toString());
                o.setPitchId(p);
                Offer off = offerService.saveOffer(o);

                response.setStatus(201);
                map.put("id", o.getId());

                return map;

            } else {

                response.setStatus(400);
                return null;
            }

        } catch (Exception e) {

            response.setStatus(400);
            return null;
        }
    }

}
