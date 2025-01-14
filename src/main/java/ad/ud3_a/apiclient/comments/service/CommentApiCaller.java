package ad.ud3_a.apiclient.comments.service;



import ad.ud3_a.apiclient.comments.domain.Comment;
import ad.ud3_a.apiclient.comments.domain.CommentPage;
import ad.ud3_a.apiclient.comments.domain.NewCommentDto;

import java.io.IOException;


public interface CommentApiCaller {

	CommentPage getAllComments() throws IOException, InterruptedException, ApiCallException;

	Comment getComment(int id) throws IOException, InterruptedException, ApiCallException;

	CommentPage getCommentsByPostId(int postId) throws IOException, InterruptedException, ApiCallException;

	Comment addComment(NewCommentDto comment) throws IOException, InterruptedException, ApiCallException;

	Comment updateComment(int id, Comment updatedComment) throws IOException, InterruptedException, ApiCallException;

	Comment deleteComment(int id) throws IOException, InterruptedException, ApiCallException;

	CommentPage getComments(int limit, int skip, String selection) throws ApiCallException, IOException, InterruptedException;
}
