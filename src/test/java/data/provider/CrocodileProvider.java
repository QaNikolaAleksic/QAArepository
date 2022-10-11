package data.provider;

import com.github.javafaker.Faker;
import data.models.CreateCrocodileRequest;

public class CrocodileProvider {
    public static CreateCrocodileRequest prepareCrocodileRequest() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest();
        createCrocodileRequest.setName(Faker.instance().funnyName().name());
        createCrocodileRequest.setSex("M");
        createCrocodileRequest.setDateOfBirth("2020-12-12");
        return createCrocodileRequest;
    }
}
