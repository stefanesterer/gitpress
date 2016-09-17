package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping(value = "/notification", method = RequestMethod.POST)
    public ResponseEntity<Boolean> update(@RequestBody Object value){
    	System.out.println(value);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    	
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}