package data.provider;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.CreateCrocodileRequest;
import java.time.LocalDate;

public class CrocodileProvider {
    public static CreateCrocodileRequest prepareCrocodileRequest() {
        LocalDate date = LocalDate.now();
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest();
        createCrocodileRequest.setName(Faker.instance().funnyName().name());
        createCrocodileRequest.setSex(ValueChoosers.getRandomSex());
        createCrocodileRequest.setDateOfBirth(date.toString());
        return createCrocodileRequest;
    }
}
