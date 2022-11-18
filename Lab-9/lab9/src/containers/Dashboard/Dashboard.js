import React, { useEffect, useState } from "react";

import "./Dashboard.css";
import axios from "axios";
import NewPost from "../../components/NewPost/NewPost";
import FullPost from "../../components/FullPost/FullPost";
import Post from "../../components/Post/Post";
import { GlobalContext } from "../../context/Global";

const Blog = () => {
  const [posts, setPosts] = useState([]);

  const [selectedId, setSelectedId] = useState(null);
  const [flag, setFlag] = useState(false);
  //const [deFlag, setDeFlag] = useState(false);
  const [selectedPost, setSelectedPost] = useState({
    title: "",
    author: "",
    content: "",
  });
  // GETTING all the POSTS
  useEffect(() => {
    axios.get("http://localhost:8080/api/v1/posts").then((response) => {
      setPosts([...response.data]); // if you don't want to limit
    });
  }, [flag]);

  // useEffect( () => {} , [] )
  const postSelectedHandler = (id) => {
    setSelectedId(id);
    setFlag(!flag);
  };
  const flagHandler = () => {
    setFlag(!flag);
  };

  // We can do this rather than this :: <Post title={{...posts[1]}.title} />
  const rposts = posts.map((post) => {
    return (
      <Post
        key={post.id}
        title={post.title}
        author={post.author}
        clicked={() => {
          postSelectedHandler(post.id);
        }}
      />
    );
  });

  useEffect(() => {
    if (selectedId > 0)
      axios
        .get(`http://localhost:8080/api/v1/posts/${selectedId}`)
        .then((response) => {
          setSelectedPost(response.data);
        });
  }, [selectedId]);

  const deleteHandler = () => {
    axios
      .delete(`http://localhost:8080/api/v1/posts/${selectedId}`)
      .then((res) => {
        setPosts(posts.filter((p) => p.id !== selectedId));
        setSelectedId(null);
      });
  };

  return (
    <React.Fragment>
      <GlobalContext.Provider value={selectedId}>
        <section className="Posts">
          {rposts.length === 0 ? "loading" : rposts}
        </section>
        <section>
          <FullPost
            id={selectedId}
            title={selectedPost.title}
            author={selectedPost.author}
            detail={selectedPost}
            deleter={deleteHandler}
          />
        </section>
        <section>
          <NewPost execute={flagHandler} />
        </section>
      </GlobalContext.Provider>
    </React.Fragment>
  );
};

export default Blog;
