package ad.ud3_a.apiclient.comments.utils;


import ad.ud3_a.apiclient.comments.domain.Comment;
import ad.ud3_a.apiclient.comments.domain.NewCommentDto;
import ad.ud3_a.apiclient.comments.domain.User;

public class MockUtils {

    public static Comment getMockComment() {
        User user1 = new User(105, "emmac", "Emma Wilson");
        // Crear comentarios
        Comment comment = new Comment(1, "This is some awesome thinking!", 242, 3, user1);
        return comment;
    }

    public static Comment getMockCommentWithoutId() {
        Comment comment = getMockComment();
        comment.setId(null);
        return comment;
    }

    public static NewCommentDto getMockNewComment() {
        NewCommentDto commentDto = new NewCommentDto();
        commentDto.setPostId(3);
        commentDto.setUserId(5);
        commentDto.setBody("This makes all sense to me!");
        return commentDto;
    }
}
