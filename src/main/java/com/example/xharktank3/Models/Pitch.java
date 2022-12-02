package com.example.xharktank3.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

/*Pitch Model contains:
entrepreneur : string,
pitchTitle : string,
pitchIdea : string,
askAmount : float,
equity : float
 We will also have a list of offers for each pitch idea */
@Entity
public class Pitch {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;


    @NotNull
    @Column(name = "entrepreneur"  ,nullable=false)
    private String entrepreneur;


    @NotNull
    @Column(name = "pitch_title",nullable=false)
    private String pitchTitle;


    @NotNull
    @Column(name = "pitch_idea",nullable=false)
    private String pitchIdea;

    @NotNull
    @Column(name = "ask_amount",nullable=false)
    private float askAmount;

    @NotNull
    @Column(name = "equity",nullable=false)
    private float equity;

    /* Credits to Sushil Singh on the Crio Slack for the idea for one to many mapping*/
    @OneToMany(mappedBy = "pitchId")
    private List<Offer> offers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(String entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    public String getPitchTitle() {
        return pitchTitle;
    }

    public void setPitchTitle(String pitchTitle) {
        this.pitchTitle = pitchTitle;
    }

    public String getPitchIdea() {
        return pitchIdea;
    }

    public void setPitchIdea(String pitchIdea) {
        this.pitchIdea = pitchIdea;
    }

    public float getAskAmount() {
        return askAmount;
    }

    public void setAskAmount(float askAmount) {
        this.askAmount = askAmount;
    }

    public float getEquity() {
        return equity;
    }

    public void setEquity(float equity) {
        this.equity = equity;
    }


    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }



}
