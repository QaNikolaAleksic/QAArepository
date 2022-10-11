package test.asserts;

import data.models.CreateCrocodileRequest;
import data.models.CreateCrocodileResponse;
import data.models.GetPublicCrocodileResponse;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();

    public void assertCreateNewCrocodile(CreateCrocodileResponse createCrocodileResponse, CreateCrocodileRequest createCrocodileRequest) {
        softAssert.assertEquals(createCrocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "date of birth didn't match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfPublicCrocodiles(GetPublicCrocodileResponse[] getPublicCrocodileResponse) {
        for(int i = 0; i < getPublicCrocodileResponse.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponse[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertGetCrocodile(GetPublicCrocodileResponse getPublicCrocodileResponse, CreateCrocodileResponse createCrocodileResponse) {
        softAssert.assertEquals(getPublicCrocodileResponse.getName(), createCrocodileResponse.getName(), "Name didn't match");
        softAssert.assertEquals(getPublicCrocodileResponse.getDateOfBirth(), createCrocodileResponse.getDateOfBirth(), "date of birth didn't match");
        softAssert.assertEquals(getPublicCrocodileResponse.getId(), createCrocodileResponse.getId(), "Crocodile ID didn't match");
        softAssert.assertAll();
    }

    public void assertPutCrocodile(CreateCrocodileResponse createCrocodileResponse, CreateCrocodileResponse putCrocodileResponse) {
        softAssert.assertNotEquals(createCrocodileResponse.getName(), putCrocodileResponse.getName(), "Name match");
        softAssert.assertNotEquals(createCrocodileResponse.getDateOfBirth(), putCrocodileResponse.getDateOfBirth(), "date of birth match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), putCrocodileResponse.getSex(), "Sex doesn't match");
        softAssert.assertAll();
    }

    public void assertPatchCrocodile(CreateCrocodileResponse createCrocodileResponse, CreateCrocodileResponse patchCrocodileResponse) {
        softAssert.assertNotEquals(createCrocodileResponse.getDateOfBirth(), patchCrocodileResponse.getDateOfBirth(), "date of birth match");
        softAssert.assertAll();
    }

    public void assertDeleteCrocodile(GetPublicCrocodileResponse getCrocodileResponse) {
        softAssert.assertNull(getCrocodileResponse, "Crocodile not deleted");
        softAssert.assertAll();
    }

}
