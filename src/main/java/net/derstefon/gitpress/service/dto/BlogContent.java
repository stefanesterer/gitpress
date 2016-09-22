package net.derstefon.gitpress.service.dto;

/**
 * Represents the information needed to upldate the blog content
 */
public class BlogContent {

    private final String fileName;
    private final String content;

    public BlogContent(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "BlogContent{" +
                "fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
