package RestPack;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class httprequest {
	
	int id;

    @Test(priority=1)
    void getUser() {
        given()
        
        .when()
            .get("https://reqres.in/api/users?page=2")
        
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .log().all();
        
        
        
    }
    
    
    @Test(priority=2)
    void createuser()
    {
    	
    	HashMap s= new HashMap();
    	s.put("Name","Shashi");
    	s.put("Job", "QA");
    	
    	id=given()
    	.contentType("application/json")
    	.body(s)
    	
    	
    	.when()
    	  .post("https://reqres.in/api/users")
    	  .jsonPath().getInt("id");
    	
    	 //.then()
    	
    	//	.statusCode(200)
          
          //  .log().all();
    	 
    }
    	
    @Test(priority=3,dependsOnMethods= {"createuser"})
   	 void updateuser()
   	    {
   	    	
   	    	HashMap s= new HashMap();
   	    	s.put("Name","Shashi");
   	    	s.put("Job", "Quality Assurance");
   	    	
   	    	given()
   	    	.contentType("application/json")
   	    	.body(s)
   	    	
   	    	
   	    	.when()
   	    	  .put("https://reqres.in/api/users/"+id)
   	    
   	    	
   	    	.then()
   	    	
   	    		.statusCode(200)
   	          
   	            .log().all();
   	    	
   	    }
   	    	
   	   void DeleteUser() {
    	            given()
    	            
    	            .when()
    	                .get("https://reqres.in/api/users/"+id)
    	            
    	            .then()
    	                .statusCode(204)
    	             
    	                .log().all();
    		
    		


    	    }
    	

     
     	    
    	    	
    	    }
    	    	
    	  
	
	

    	
    	
    	
    

	
	

	
		
	

	
		
	
	


