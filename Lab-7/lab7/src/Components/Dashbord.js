import { useState } from "react";
import PostDetails from "./PostDetails";
import Posts from './Posts'

const Dashbord = () => {

    const [posts, setPosts] = useState([
        { id: 111, title: 'Happiness', author: 'John' },
        { id: 112, title: 'MIU', author: 'Dean' },
        { id: 113, title: 'Enjoy Life', author: 'Jasmine' },
    ]);

    const [title, setTitle] = useState("");
    const [showDetail, setSohwDetail] = useState(false)
    const [postDetail, setPostDetail] = useState({
        id: "", title: "", author: ''
    })

    const changeTitle = () => {
        const copyPosts = [...posts]
        copyPosts[1].title = title
        setPosts(copyPosts)
        // setPosts()
    }

    const displayDetails = (id) => {
        const SelectedPost = posts.find(x=>x.id === id)
        setPostDetail(SelectedPost)
        setSohwDetail(true)
    }

    return (
        <div>
            <Posts data={posts} displayDetails={displayDetails}/>
            <div className="label">
                <input type="text" id="text" title="title" onChange={(e) => setTitle(e.target.value)} /><br />
                <button className="button" onClick={changeTitle}>Change Title</button>
            </div>
            {showDetail && <PostDetails post={postDetail}/>}

        </div>
    );
}

export default Dashbord;