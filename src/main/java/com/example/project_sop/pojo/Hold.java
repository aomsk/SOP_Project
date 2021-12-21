package com.example.project_sop.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("holdbook")
public class Hold {

    @Id
    private String _id;
    private String username;
    private String idUser;
    private List<String> holdBook;
    private String title;

    public Hold() {}
    public Hold(String _id, String idUser, String username, List<String> holdBook) {
        this._id = _id;
        this.idUser = idUser;
        this.username = username;
        this.holdBook = holdBook;
    }
}
