package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.*;
import io.restassured.response.Response;

public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.LOGIN, loginRequest), LoginResponse.class);
    }

    public static CreateCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.USERS, accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.PUBLIC), GetPublicCrocodileResponse[].class);
    }

    public static GetPublicCrocodileResponse getCrocodile(String accessToken, Integer id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_USER(id), accessToken), GetPublicCrocodileResponse.class);
    }

    public static CreateCrocodileResponse putCrocodile(String accessToken, Integer id, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(ApiEndpoints.SINGLE_USER(id), accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static CreateCrocodileResponse patchCrocodile(String accessToken, Integer id, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(ApiEndpoints.SINGLE_USER(id), accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse deleteCrocodile(String accessToken, Integer id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.SINGLE_USER(id), accessToken), GetPublicCrocodileResponse.class);
    }
}
