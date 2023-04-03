package github.CRUDOperations;

import org.testng.annotations.Test;

import genericLibraries.IEndPointsAndPaths;


import static io.restassured.RestAssured.*;

public class DeleteRepoTest extends BaseClass {

	@Test
	public void deleteRepoTest() {
		given()
			.auth()
				.oauth2(property.fetchParameter("token"))
			.pathParam("owner", property.fetchParameter("owner"))
			.pathParam("repo", property.fetchParameter("repo"))
		.when()
			.delete(IEndPointsAndPaths.deleteRepo)
		.then()
			.log().all()
			.assertThat().statusCode(204);
	}
	
}
