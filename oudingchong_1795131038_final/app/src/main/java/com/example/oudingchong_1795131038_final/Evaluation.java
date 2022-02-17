package com.example.oudingchong_1795131038_final;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Evaluation {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "comment_id")
    private long commentId;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "star_num")
    private String starnum;
    @ColumnInfo(name = "comment")
    private String comment;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getStarnum() {
        return starnum;
    }

    public void setStarnum(String starnum) {
        this.starnum = starnum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Evaluation(String userName,String starnum, String comment){
        this.userName = userName;
        this.starnum = starnum;
        this.comment = comment;
    }
}
