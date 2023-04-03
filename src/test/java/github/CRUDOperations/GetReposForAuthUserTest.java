package github.CRUDOperations;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.IEndPointsAndPaths;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class GetReposForAuthUserTest extends BaseClass {

	@Test
	public void getReposForUserTest() {
		Response response = 
				given()
					.auth()	
						.oauth2(property.fetchParameter("token"))
				.when()
					.get(IEndPointsAndPaths.getRepoForAuthUser);
		
		response.then()
					.log().all()
					.assertThat()
						.statusCode(200)
						.contentType(ContentType.JSON);

		//Assert.assertTrue(response.body().toString().contains("JenkinsPractice2"));
				
	}
}
