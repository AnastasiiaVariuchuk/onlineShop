package onlineShop.taskJAKSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonPojoToJson {
    public static void main(String[] args) throws IOException {
        // Create ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // create a post1
        Post post1 = new Post();
        post1.setTitle("Makeup Post");
        post1.setId(100);
        post1.setDescription("About new production in our shop!");
        post1.setContent("Sale -30%");

        // create a post2
        Post post2 = new Post();
        post2.setTitle("Apple Post");
        post2.setId(101);
        post2.setDescription("New IPhones in our shop!");
        post2.setContent("IPhone 14");

        List<Post> postsList = new ArrayList<>();
        postsList.add(post1);
        postsList.add(post2);
        Posts posts = new Posts(postsList);

        // Convert object to JSON string
        String postJson = mapper.writeValueAsString(posts);
        System.out.println(postJson);

        // Save JSON string to file
        FileOutputStream fileOutputStream = new FileOutputStream("posts.json");
        mapper.writeValue(fileOutputStream, posts);
        fileOutputStream.close();
    }
}
