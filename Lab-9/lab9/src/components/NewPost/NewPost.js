import axios from "axios";
import React, { useRef } from "react";

import "./NewPost.css";

const NewPost = (props) => {
  const formRef = useRef({});
  // const [post, setPost] = useState({
  //   title: "",
  //   content: "",
  //   author: "",
  // });

  const addPostHandler = (event) => {
    event.preventDefault();
    const data = {
      title: formRef.current["title"].value,
      content: formRef.current["content"].value,
      author: formRef.current["author"].value,
    };
    console.log("data" + data.title);
    axios
      .post("http://localhost:8080/api/v1/posts", data)
      .then((data2) => {
        props.execute();
        console.log("success", data2);
      })
      .catch((error) => console.log(error.message));
  };
  console.log("Added");
  return (
    <div className="NewPost">
      <h1>Add a Post</h1>
      <form ref={formRef}>
        <label>Title</label>
        <input
          type="text"
          name="title"
          //value={post.title}
          //onChange={(event) => setPost({ ...post, title: event.target.value })}
        />
        <label>Content</label>
        <textarea
          rows="4"
          name="content"
          //value={post.content}
          // onChange={(event) =>
          //   setPost({ ...post, content: event.target.value })
          //}
        />
        <label>Author</label>
        <select
          name="author"
          //value={post.author}
          //onChange={(event) => setPost({ ...post, author: event.target.value })}
        >
          <option value="James" defaultValue>
            James
          </option>
          <option value="Sara">Sara</option>
          <option value="Daniel">Daniel</option>
        </select>
        <button onClick={addPostHandler}>Add Post</button>
      </form>
    </div>
  );
};

export default NewPost;
