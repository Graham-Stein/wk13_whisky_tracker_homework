package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetAllDistilleries(){ List<Distillery> results = distilleryRepository.findAll();
	}

	@Test
	public void canGetAllWhisky(){ List<Whisky> results = whiskyRepository.findAll();
	}

	@Test
	public void canFindWhiskyByYear(){ List<Whisky> results = whiskyRepository.findAllWhiskyForYear(1991);
	}

	@Test
	public void canFindWhiskyByRegion(){
		List<Whisky> results = distilleryRepository.findAllWhiskyFromRegion("Speyside");
	}

	@Test
	public void canFindWHiskyByDistilleryAndAge(){
		List<Whisky> results = distilleryRepository.findAllWhiskyFromDistilleryOfAge("Glendronach", 15);
	}

}
