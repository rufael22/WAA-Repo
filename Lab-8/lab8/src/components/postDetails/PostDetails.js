import './PostDetails.css'

const PostDetails = (props) => {
    return (
        <div className="PostDetails">
            <h2><u>{props.title}</u></h2>
            <h3>{props.author}</h3>
            <div className='text'>
                <p>{props.content}</p>
            </div>
            <br />
            <br />
           
            <button onClick={() => { props.deletePost(props.id) }}>delete</button>


        </div>
    );
}

export default PostDetails;