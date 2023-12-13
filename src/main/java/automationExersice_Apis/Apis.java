package automationExersice_Apis;

import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import java.util.Arrays;
import java.util.List;

public class Apis {
    SHAFT.API api;
    public static String baseUrl = System.getProperty("baseUrl");
    // Status Codes
    public static final int success_statusCode = 200;
    public static final String createAcc_serviceName = "/createAccount";

    @Step("Login Using User Name:{username} | Password:{password}")
    public static void createUser(SHAFT.API api,String name,String email, String password,String title,String birth_date,
                                  String birth_month,String birth_year,String firstname,String lastname,String company,
                                  String address1,String address2,String country,String zipcode,String state,
                                  String city,String mobile_number) {


           List <List<Object>> formInputs = Arrays.asList(
                    Arrays.asList("name", name),
                    Arrays.asList("email", email),
                    Arrays.asList("password", password),
                    Arrays.asList("title", title),
                    Arrays.asList("birth_date", birth_date),
                    Arrays.asList("birth_month", birth_month),
                    Arrays.asList("birth_year", birth_year),
                    Arrays.asList("firstname", firstname),
                    Arrays.asList("lastname", lastname),
                    Arrays.asList("company", company),
                    Arrays.asList("address1", address1),
                    Arrays.asList("address2", address2),
                    Arrays.asList("country", country),
                    Arrays.asList("zipcode", zipcode),
                    Arrays.asList("state", state),
                    Arrays.asList("city", city),
                    Arrays.asList("mobile_number", mobile_number)
            );

           api.post(createAcc_serviceName)
                    .setParameters(formInputs, RestActions.ParametersType.FORM)
                    .setContentType(ContentType.URLENC)
                    .setTargetStatusCode(success_statusCode)
                    .perform();



    }

    //        String createAccBody = """
//                {
//                    "name" : "{USERNAME}",
//                    "email" : "{email}",
//                    "password" : "{PASSWORD}",
//                    "title" : "{title}",
//                    "birth_date" : "{birth_date}",
//                    "birth_month" : "{birth_month}",
//                    "birth_year" : "{birth_year}",
//                    "firstname" : "{firstname}",
//                    "lastname" : "{lastname}",
//                    "company" : "{company}",
//                    "address1" : "{address1}",
//                    "address2" : "{address2}",
//                    "country" : "{country}"
//                    "zipcode" : "{zipcode}",
//                    "state" : "{state}",
//                    "city" : "{city}",
//                    "mobile_number" : "{mobile_number}"
//
//                }
//                """
//                .replace("{USERNAME}", name)
//                .replace("{email}", email)
//                .replace("{PASSWORD}", password)
//                .replace("{title}", title)
//                .replace("{birth_date}", birth_date)
//                .replace("{birth_month}", birth_month)
//                .replace("{birth_year}", birth_year)
//                .replace("{firstname}", firstname)
//                .replace("{lastname}", lastname)
//                .replace("{company}", company)
//                .replace("{address1}", address1)
//                .replace("{address2}", address2)
//                .replace("{country}", country)
//                .replace("{zipcode}", zipcode)
//                .replace("{state}", state)
//                .replace("{city}", city)
//                .replace("{mobile_number}


}
