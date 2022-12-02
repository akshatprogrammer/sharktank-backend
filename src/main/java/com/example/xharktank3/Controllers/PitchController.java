package com.example.xharktank3.Controllers;

import com.example.xharktank3.Models.Pitch;
import com.example.xharktank3.Services.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PitchController {

    @Autowired
    private PitchService pitchService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Map<String,String> norReply() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/favicon.ico")
    public Map<String,String> norReplyFavicon() {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pitches")
    public Map<String, String> savePitch(@RequestBody Map<String, Object> pitch, HttpServletResponse response) {
        HashMap<String, String> map = new HashMap<>();



        try {
            if (pitch.containsKey("entrepreneur") && pitch.containsKey("pitchTitle") && pitch.containsKey("pitchIdea")
                    && pitch.containsKey("askAmount") && pitch.containsKey("equity") && pitch.get("entrepreneur") != null
                    && pitch.get("pitchTitle") != null && pitch.get("pitchIdea") != null
                    && pitch.get("askAmount") != null && pitch.get("equity") != null
                    && Float.parseFloat(pitch.get("askAmount").toString()) >= 0
                    && Float.parseFloat(pitch.get("equity").toString()) <= 100
                    && Float.parseFloat(pitch.get("equity").toString()) >= 0) {

                Pitch p = new Pitch();
                p.setEntrepreneur(pitch.get("entrepreneur").toString());
                p.setPitchTitle(pitch.get("pitchTitle").toString());
                p.setPitchIdea(pitch.get("pitchIdea").toString());
                p.setAskAmount(Float.parseFloat(pitch.get("askAmount").toString()));
                p.setEquity(Float.parseFloat(pitch.get("equity").toString()));

                Pitch pitch1 = pitchService.savePitch(p);

                map.put("id", pitch1.getId());

                response.setStatus(201);

                return map;
            } else {
                response.setStatus(400);
                return null;

            }}catch(Exception e) {
            response.setStatus(400);
            return null;

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pitches")
    public List<Pitch> getPitch(HttpServletResponse response) {
        response.setStatus(200);
        return pitchService.getAllPitches();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pitches/{pitchId}")
    public Pitch getPitchById(@PathVariable("pitchId") String pitchId, HttpServletResponse response) {
        Pitch pitch = pitchService.getPitchById(pitchId);
        if(pitch ==null) {
            response.setStatus(404);
            return null;
        }
        response.setStatus(200);
        return pitchService.getPitchById(pitchId);
    }

}
