/**
 * 
 */
package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

/**
 * @author anili
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchJeepTest extends FetchJeepTestSupport{

  @Test
  void testThatJeepsAreReturnedWhenAVaildModleAndTrimAreSupplied() {
    // Given: a valid model, trim and  URI
    JeepModel model = JeepModel.WRANGLER;
     String trim =  "sport";
      String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim); 
    
      System.out.println(uri);
        //When : a connection is made to the URI
          ResponseEntity<Jeep>  response = 
              getRestTemplate().getForEntity(uri, Jeep.class);
          
    // Then:  a success ( OK - 200) status code is  returned
          assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
          
  }

}
