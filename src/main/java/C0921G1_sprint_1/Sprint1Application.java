package C0921G1_sprint_1;

import C0921G1_sprint_1.dto.film.ValidateStartAndEndDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sprint1Application {

    public static void main(String[] args) {
        SpringApplication.run(Sprint1Application.class, args);


        System.out.println(ValidateStartAndEndDate.checkNgay("2022-03-11","2022-04-01"));
    }

}
