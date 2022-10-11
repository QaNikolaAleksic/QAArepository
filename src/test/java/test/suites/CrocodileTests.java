package test.suites;

import calls.CrocodilesAPI;
import data.models.CreateCrocodileRequest;
import data.models.CreateCrocodileResponse;
import data.models.GetPublicCrocodileResponse;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Nikola", "M", "2020-12-12");

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, createCrocodileRequest);

    }

    @Test
    @Description("Get crocodile list")
    public void getListOfPublicCrocodiles() {
        GetPublicCrocodileResponse[] getPublicCrocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();

        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
    }

    @Test
    @Description("Get crocodile by ID")
    public void getCrocodile() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Nikola", "M", "2020-12-12");

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        GetPublicCrocodileResponse getCrocodileResponse = CrocodilesAPI.getCrocodile(accessToken, createCrocodileResponse.getId());

        crocodileAsserts.assertGetCrocodile(getCrocodileResponse, createCrocodileResponse);
    }

    @Test
    @Description("verify crocodile is updated")
    public void putCrocodile() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Nikola", "M", "2020-12-12");

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        CreateCrocodileRequest putCrocodileRequest = new CreateCrocodileRequest("Test1", "M", "2021-12-12");

        CreateCrocodileResponse putCrocodileResponse = CrocodilesAPI.putCrocodile(accessToken, createCrocodileResponse.getId(), putCrocodileRequest);

        crocodileAsserts.assertPutCrocodile(createCrocodileResponse, putCrocodileResponse);
    }

    @Test
    @Description("verify crocodile's birth date is patched")
    public void patchCrocodile() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Nikola", "M", "2020-12-12");

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        CreateCrocodileRequest patchCrocodileRequest = new CreateCrocodileRequest("Nikola", "M", "2020-10-10");

        CreateCrocodileResponse patchCrocodileResponse = CrocodilesAPI.patchCrocodile(accessToken, createCrocodileResponse.getId(), patchCrocodileRequest);

        crocodileAsserts.assertPatchCrocodile(createCrocodileResponse, patchCrocodileResponse);
    }

    @Test
    @Description("verify if crocodile is deleted")
    public void deleteCrocodile() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Nikola", "M", "2020-12-12");

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);
        
        CrocodilesAPI.deleteCrocodile(accessToken, createCrocodileResponse.getId());

        GetPublicCrocodileResponse getCrocodileResponse = CrocodilesAPI.getCrocodile(accessToken, createCrocodileResponse.getId());

        crocodileAsserts.assertDeleteCrocodile(getCrocodileResponse);
    }

}
