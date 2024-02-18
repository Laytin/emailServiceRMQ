package com.laytin.emailService.service;

import com.laytin.emailService.models.TripOrder;
import com.laytin.emailService.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripOrderNotificationService {
    private final TripRepository tripRepository;
    @Autowired
    public TripOrderNotificationService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }
    public void notifyOwner(TripOrder o){
        //TODO: Some notification logic
    }
    public void notifyJoiner(TripOrder o){
        //TODO: Some notification logic
    }
}
