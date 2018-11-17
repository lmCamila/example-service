package com.example.restservice;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
public class RestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}
}

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
class City{
    
    private Long id;
    private String name;
    private State state;
}

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
class State{
    
    private Long id;
    private String name;
}

@RestController
class CityDAO{
    @PostMapping("/cidade")
    public City create(@RequestBody City city){
        return city;
    }

    @GetMapping("/cidade")
    public List<City> read(){
        List<City> cities = new ArrayList<>();
        cities.add( new City(new Long(1),"Cornélio Procópio",new State(new Long(1),"Paraná")));
        cities.add( new City(new Long(2),"Balneário Camburiú",new State(new Long(2),"Santa Catarina")));
        cities.add( new City(new Long(3),"Salvador",new State(new Long(3),"Bahia")));
        cities.add( new City(new Long(4),"Recife",new State(new Long(4),"Pernambuco")));
        return cities;
    }

    @PutMapping("/cidade")
    public City update(@RequestBody City city){
        return city;
    }

    @DeleteMapping("/cidade/{id}")
    public int delete(@PathVariable int id){
        return 200;
    }

}
