package io.github.pactstart.weixin.mp.response.comment;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.github.pactstart.weixin.common.response.JsonResponse;
import io.github.pactstart.weixin.mp.vo.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Di.Lei on 2017/8/6.
 */
public class CommentListResponse extends JsonResponse {

    private int total;

    private List<Comment> commentList;

    @Override
    public void parseJSON(JSONObject jsonObject) {
        this.total = jsonObject.getInteger("total");
        JSONArray jsonArray = jsonObject.getJSONArray("comment");
        if (jsonArray != null && jsonArray.size() > 0) {
            commentList = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject commentObject = jsonArray.getJSONObject(i);
                Comment comment = commentObject.toJavaObject(Comment.class);
                JSONObject replyObject = commentObject.getJSONObject("reply");
                if (replyObject != null) {
                    comment.setReplyContent(replyObject.getString("content"));
                    comment.setReplyCreateTime(replyObject.getLong("create_time"));
                }
                commentList.add(comment);
            }
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
