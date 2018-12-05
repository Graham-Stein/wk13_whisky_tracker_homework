package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface DistilleryRepositoryCustom {
    List<Whisky> findAllWhiskyFromRegion(String region);
    List<Distillery> findAllDistilleriesInRegion(String region);
    List<Whisky> findAllWhiskyFromDistilleryOfAge(String distillery, int age);
}
