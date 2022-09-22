package taskJAKSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import onlineShop.taskJAXB.EmployeeJAXB;
import onlineShop.taskJAXB.EmployeesJAXB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Posts {
    private List<Post> posts = new ArrayList<Post>();
    private static final Logger logger = LogManager.getLogger(Posts.class);

    public Posts() {
    }

    public Posts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void readPost(){
        for(Post post: posts){
            logger.info(post.toString());
        }
    }

}
