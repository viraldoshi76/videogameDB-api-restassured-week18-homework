package com.videogamedb.videogame;

import com.videogamedb.VideoGamePojo;
import com.videogamedb.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class VideoGameTest extends TestBase {

    @Test
    public void getAllVideoGamesInfo(){

        Response response=
                given()
                .header("Accept","application/json")
                .when()
                .get("/videogames");
                response.then().statusCode(200);
                response.prettyPrint();
    }

    @Test
    public void getSingleIdInfo(){
        Response response=
                given()
                .header("Accept","application/json")
                .pathParam("id",15)
                .when()
                .get("/videogames/{id}");
                response.then().statusCode(200);
                response.prettyPrint();

    }

    @Test
    public void postNewData(){
        VideoGamePojo videoGamePojo = new VideoGamePojo();
        videoGamePojo.setId(15);
        videoGamePojo.setName("resort");
        videoGamePojo.setReleaseDate("1997-10-01");
        videoGamePojo.setReviewScore(97);
        videoGamePojo.setCategory("Platform1");
        videoGamePojo.setRating("Mature1");

        Response response=
                given()
                .header("Content-Type","application/json")
                .body(videoGamePojo)
                .when()
                .post("/videogames");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void upDateVideoGameData(){
        VideoGamePojo videoGamePojo = new VideoGamePojo();
            videoGamePojo.setName("Bolywoodcity 2019");
            videoGamePojo.setReleaseDate("1997-09-11");
            videoGamePojo.setReviewScore(94);
            videoGamePojo.setCategory("Driving");
            videoGamePojo.setRating("Mature");

            Response response=
                    given()
                    .header("Content-Type","application/json")
                    .pathParam("id",15)
                    .body(videoGamePojo)
                    .when()
                    .put("/videogames/{id}");
            response.then().statusCode(200);
            response.prettyPrint();
    }

    @Test
    public void upDateVideoGameWithSingleFieldValueChange(){
            VideoGamePojo videoGamePojo = new VideoGamePojo();
            videoGamePojo.setCategory("Puzzle");

            Response response=
                    given()
                    .header("Content-Type","application/json")
                    .pathParam("id",6)
                    .body(videoGamePojo)
                    .when()
                    .put("/videogames/{id}");
            response.then().statusCode(200);
            response.prettyPrint();
    }

    @Test
    public void deleteDataFromRecord(){

        Response response =
                given()
                .pathParam("id",0)
                .when()
                .delete("/videogames/{id}");
        response.then().statusCode(200);
        response.prettyPrint();


    }


}
