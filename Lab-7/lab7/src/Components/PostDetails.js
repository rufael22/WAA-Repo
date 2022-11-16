import React from 'react'

function PostDetails(props) {

  return (
    <div>
        {console.log(props)}
        <h4>{props.post.title}</h4>
        <h6>{props.post.author}</h6>
        <p>This is the content in the post ....</p>

        <button>Edit</button>
        <button>Delete</button>  
    </div>
  )
}

export default PostDetails