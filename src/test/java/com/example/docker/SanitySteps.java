package com.example.docker;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@ContextConfiguration(classes = {AppConfig.class})
public class SanitySteps {
    public static final String USERS_ENDPOINT = "http://localhost:8080/users";
    private List<User> actualUsers;

    @Autowired
    private RestTemplate restTemplate;

    @When("^endpoint '\\/users' has been called$")
    public void endpoint_users_has_been_called() throws Throwable {
        final HttpHeaders headers = new HttpHeaders();

        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        final HttpEntity<?> entity = new HttpEntity<>(headers);

        actualUsers = restTemplate.exchange(
                USERS_ENDPOINT, HttpMethod.GET, entity, new ParameterizedTypeReference<List<User>>() {
                }).getBody();
    }

    @Then("^the users should be as follows$")
    public void the_user_id_should_be(final List<User> expectedUsers) throws Throwable {
        for (int i = 0; i < expectedUsers.size(); i++) {
            assertUser(expectedUsers.get(i), actualUsers.get(i));
        }
    }

    private void assertUser(User expectedUser, User actualUser) {
        Assert.assertEquals(expectedUser.getId(), actualUser.getId());
        Assert.assertEquals(expectedUser.getName(), actualUser.getName());
        Assert.assertEquals(expectedUser.getDepartmentName(), actualUser.getDepartmentName());
        Assert.assertEquals(expectedUser.getCollegeName(), actualUser.getCollegeName());
        Assert.assertEquals(expectedUser.getAge(), actualUser.getAge());
    }
}
