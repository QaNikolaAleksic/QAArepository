package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.*;

public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static CreateCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("my/crocodiles/", accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"), GetPublicCrocodileResponse[].class);
    }

    public static GetPublicCrocodileResponse getCrocodile(String accessToken, Integer id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/" + id, accessToken), GetPublicCrocodileResponse.class);
    }

    public static CreateCrocodileResponse putCrocodile(String accessToken, Integer id, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/" + id, accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static CreateCrocodileResponse patchCrocodile(String accessToken, Integer id, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/" + id, accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse deleteCrocodile(String accessToken, Integer id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("my/crocodiles/" + id, accessToken), GetPublicCrocodileResponse.class);
    }
}
