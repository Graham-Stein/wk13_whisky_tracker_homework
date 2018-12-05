package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> findAllWhiskyForYear(int year);

}


//   1) get all the whiskies for a particular year
//   2)     get all the whisky from a particular region
//   4) get all the whisky from a particular distillery that's a specific age (if the whisky has a specific age