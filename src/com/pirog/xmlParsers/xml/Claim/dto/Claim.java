package com.pirog.xmlParsers.xml.Claim.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Claim {
    private long id;
    private Map<String, List<Person>> persons = new HashMap<>();
    private Policy policy;
    private LossDetails lossDetails;

    public Claim(long id, Policy policy, LossDetails lossDetails, Person claimant) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(claimant);
        this.id = id;
        this.policy = policy;
        this.lossDetails = lossDetails;
        this.persons.put("claimant", personList);
    }

    public long getId() {
        return id;
    }

    public Map<String, List<Person>> getPersons() {
        return persons;
    }

    public Policy getPolicy() {
        return policy;
    }

    public LossDetails getLossDetails() {
        return lossDetails;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public void setLossDetails(LossDetails lossDetails) {
        this.lossDetails = lossDetails;
    }

    @Override
    public String toString() {
        return "Claim nr:" + id;
    }
}
