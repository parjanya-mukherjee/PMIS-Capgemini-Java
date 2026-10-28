
package com.parjanya.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return "Hello, my name is " + name + " and I am " + age + " years old.";
    }
}
@RestController
public class BasicProgramsController {

    @GetMapping("/basics/even-or-odd")//http://localhost:8080/basics/even-or-odd?number=22
    public String evenOrOdd(@RequestParam("number") int number) {
        if (number % 2 == 0) {
            return number + " is even.";
        }
        return number + " is odd.";
    }

    @GetMapping("/basics/grade")//http://localhost:8080/basics/grade?marks=99
    public String grade(@RequestParam("marks") int marks) {
        if (marks < 0 || marks > 100) {
            return "Marks must be between 0 and 100.";
        } else if (marks >= 90) {
            return "Grade A";
        } else if (marks >= 75) {
            return "Grade B";
        } else if (marks >= 50) {
            return "Grade C";
        } else if (marks >= 35) {
            return "Grade D";
        } else {
            return "Fail";
        }
    }
    @GetMapping("/basics/person")
    public String person(@RequestParam String name, @RequestParam int age) {
        Person person = new Person(name, age);
        return person.introduce();
    }
}
