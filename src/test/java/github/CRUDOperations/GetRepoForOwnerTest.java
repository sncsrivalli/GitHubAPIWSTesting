package github.CRUDOperations;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.IEndPointsAndPaths;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class GetRepoForOwnerTest extends BaseClass {

	@Test
	public void getRepoForOwnerTest() {
		Response resp = given()
							.pathParam("owner", property.fetchParameter("owner"))
							.pathParam("repo", property.fetchParameter("repo"))
						.when()
							.get(IEndPointsAndPaths.getRepoForOwner);
		resp.then()
				.log().all()
				.assertThat().statusCode(200);
		String reponame = resp.jsonPath().get("name");
		String ownerName = resp.jsonPath().get("owner.login");
		Assert.assertEquals(reponame, property.fetchParameter("repo"));
		Assert.assertEquals(ownerName, property.fetchParameter("owner"));
	}
}
