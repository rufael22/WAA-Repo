
import React from 'react'
import './Post.css'

function Post(props) {
  return (
    <div className="Content" onClick={props.setSelected}>
            Id: {props.id}
            <h3>Title: {props.title}</h3>
            Author: {props.author}
           Content: {props.content}
        </div>
  )
}

export default Post