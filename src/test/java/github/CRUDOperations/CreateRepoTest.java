package github.CRUDOperations;

import org.testng.annotations.Test;

import genericLibraries.IEndPointsAndPaths;
import io.restassured.http.ContentType;
import pojoClasses.RepositoryLib;

import static io.restassured.RestAssured.*;
 

public class CreateRepoTest extends BaseClass {
	
	@Test
	public void createRepoTest() {
		repoName = property.fetchParameter("repoName")+javaUtil.generateRandomNumber(100);
		RepositoryLib repoObj = new RepositoryLib(repoName, 
					property.fetchParameter("description"), 
					property.fetchParameter("homepage"),false);
		
		given()
			.auth()
				.oauth2(property.fetchParameter("token"))
			.body(repoObj)
			.contentType(ContentType.JSON)
		.when()
			.post(IEndPointsAndPaths.postforAuthUser)
		.then()
			.log().all()
			.assertThat()
				.statusCode(201);
				
	}
}
