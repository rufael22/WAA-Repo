import Post from "./Post";


const Posts = (props) => {


    return (
        <div>
            {props.data.map(p => {
                return <Post
                    id={p.id}
                    title={p.title}
                    author={p.author}
                    key={p.id}
                    displayDetails={props.displayDetails}
                    />
            })}
        </div>
    )

}

export default Posts;