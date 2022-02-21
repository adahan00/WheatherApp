package kg.geektech.newsapplite.models;

import java.io.Serializable;

public class News  implements Serializable {
    private String title;
    private String createdAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public News(String title, String createdAt) {
        this.title = title;
        this.createdAt = createdAt;
    }
}
