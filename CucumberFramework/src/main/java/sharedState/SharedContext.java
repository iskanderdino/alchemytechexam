package sharedState;

import io.restassured.response.Response;

import java.util.Map;

public class SharedContext {

    public int id;
    public Response response;
    public Map<Object, Object> requestMap;
}
