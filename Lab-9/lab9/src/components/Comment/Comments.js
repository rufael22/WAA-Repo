import React from "react";
import Comment from "./Comment";
const Comments = (props) => {
  const comments = props.comments.map((comment) => {
    return <Comment id={comment.id} name={comment.name} />;
  });
  return comments;
};

export default Comments;
