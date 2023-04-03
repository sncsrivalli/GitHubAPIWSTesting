package github.CRUDOperations;

import org.testng.annotations.Test;

import genericLibraries.IEndPointsAndPaths;

import static io.restassured.RestAssured.*;
public class GetReposForUserTest extends BaseClass {

	@Test
	public void getReposForUserTest() {
		given()
			.pathParam("username", property.fetchParameter("username"))
		.when()
		 	.get(IEndPointsAndPaths.getAllUserRepo)
		 .then()
		 	.log().all()
		 	.assertThat().statusCode(200);
	}
}
