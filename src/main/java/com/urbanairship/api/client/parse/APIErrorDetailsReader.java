package com.urbanairship.api.client.parse;

import com.urbanairship.api.client.APIErrorDetails;
import com.urbanairship.api.common.parse.JsonObjectReader;
import org.codehaus.jackson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/*
Readers are the part of the deserialization process that actually builds and
return an object.
 */
public class APIErrorDetailsReader implements JsonObjectReader<APIErrorDetails>{

    private final APIErrorDetails.Builder builder;

    public APIErrorDetailsReader(){
        this.builder = APIErrorDetails.newBuilder();
    }

    public void readPath(JsonParser parser) throws IOException {
        builder.setPath(parser.readValueAs(String.class));
    }

    public void readError(JsonParser parser) throws IOException {
        builder.setError(parser.readValueAs(String.class));
    }

    public void readLocation(JsonParser parser) throws IOException {
        builder.setLocation(parser.readValueAs(APIErrorDetails.Location.class));
    }

    @Override
    public APIErrorDetails validateAndBuild() throws IOException {
        try {
            return builder.build();
        }
        catch (Exception ex){
            throw new APIParsingException(ex.getMessage());
        }
    }
}
