package onlineShop.taskJAKSON;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JacksonJsonToPojo {

    private static final Logger logger = (Logger) LogManager.getLogger(JacksonJsonToPojo.class);

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON file and convert to java object
        InputStream fileInputStream = new FileInputStream("posts.json");
        Posts posts = mapper.readValue(fileInputStream, Posts.class);
        posts.readPost();
    }
}
