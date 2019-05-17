package com.testAway.testAway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
@SpringBootApplication
public class TestAwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAwayApplication.class, args);
	}

	@RequestMapping("/doctor/{incarnation}")
	@ResponseBody
	public Doctor myArrayListDoctor(@PathVariable int incarnation, boolean details){



		ArrayList<Doctor> listDoctor = new ArrayList<>();


		Doctor doctor9 = new Doctor ("9" , "Christopher Eccleston");
		Doctor doctor10 = new Doctor ("10" , "David Tennant");
		Doctor doctor11 = new Doctor ("11" , "Matt Smith");
		Doctor doctor12 = new Doctor ("12" , "Peter Capaldi");
		Doctor doctor13 = new Doctor ("13" , "Jodie Whittaker");


		listDoctor.add(doctor9);
		listDoctor.add(doctor10);
		listDoctor.add(doctor11);
		listDoctor.add(doctor12);
		listDoctor.add(doctor13);

		if(incarnation <= 8 && incarnation >= 1) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "303 not found");

		}

		if(incarnation > 13 || incarnation < 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation <numéro de l'incarnation>");

		}

		if(details == true){

			return myArrayListExtendDoctor(incarnation -9) ;
		}

		return listDoctor.get(incarnation -9);
	}

	public ExtendedDoctor myArrayListExtendDoctor(int incarnation){

		ArrayList<ExtendedDoctor> listExtendDoctor = new ArrayList<>();

		ExtendedDoctor extendDoctor9 = new ExtendedDoctor("9" , "Christopher Eccleston", "13", "41");
		ExtendedDoctor extendDoctor10 = new ExtendedDoctor("10" , "David Tennant", "47", "34");
		ExtendedDoctor extendDoctor11 = new ExtendedDoctor("11" , "Matt Smith", "44", "27");
		ExtendedDoctor extendDoctor12 = new ExtendedDoctor("12" , "Peter Capaldi", "40", "55");
		ExtendedDoctor extendDoctor13 = new ExtendedDoctor("13" , "Jodie Wittaker", "11", "35");

		listExtendDoctor.add(extendDoctor9);
		listExtendDoctor.add(extendDoctor10);
		listExtendDoctor.add(extendDoctor11);
		listExtendDoctor.add(extendDoctor12);
		listExtendDoctor.add(extendDoctor13);


		return listExtendDoctor.get(incarnation);
	}




	class Doctor {

		private String name;
		private String number;

		public Doctor(String number, String name) {
			this.name = name;
			this.number = number;
		}

		public String getName() {
			return name;
		}

		public String getNumber() {
			return number;
		}
	}
	class ExtendedDoctor extends Doctor {

		private String numberEpisode;
		private String ageStart;

		public ExtendedDoctor(String number, String name , String numberEpisode, String ageStart ) {
			super(name, number);
			this.numberEpisode = numberEpisode;
			this.ageStart = ageStart;
		}


		public String getNumberEpisode() {
			return numberEpisode;
		}

		public String getAgeStart() {
			return ageStart;
		}
	}



}
