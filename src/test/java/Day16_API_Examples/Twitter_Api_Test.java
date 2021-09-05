package Day16_API_Examples;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Twitter_Api_Test {

    String consumerKey = "86Q9FZWWBdTgvbkcqDUumQzK0";
    String consumerSecret = "PETtTmxpvUc6RuBOx1lnifkr1U2iIGMfdcqH4xhMulKnxSseEr";
    String accessToken = "1344054336758886400-jhgu5Thl4XTA0q2p96CrjrQ5SbIllD";
    String tokenSecret = "Kn5qfYIEOemKQp0quX5RgFSwRwUJk1yHS29pagXhKQoxw";
    String id = "";

    @BeforeClass
    public void setup(){
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
    }//end of set up

    @Test(priority = 1)
    public void postAStatus(){
        Response response =
                given()
                .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                queryParam("status", "My fourth post through api automation")
                .when().post("update.json")
                .then().extract().response();

        if(response.statusCode() == 200){
            System.out.println("Status code is 200 as expected");
        } else {
            System.out.println("Actual status code is " + response.statusCode());
        }

        //verify the id and the text after posting
        String resp = response.asString();
        JsonPath json = new JsonPath(resp);
        //id
        id = json.getString("id");
        //text
        String actualText = json.getString("text");

        System.out.println("My id is " + id + " and text is " + actualText);

    }//end of post a status method

    @Test(priority = 2)
    public void deleteRecentPost(){
        Response response =
                given()
                        .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                        queryParam("id",id)
                        .when().post("destroy.json")
                        .then().extract().response();
        if(response.statusCode() == 200){
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Actual status code is " + response.statusCode());
        }

    }//end of delete recent post











}//end of class
