import { useEffect, useState } from "react";
import Posts from "./posts/Posts";
import axios from "axios";
import PostDetails from "./../components/postDetails/PostDetails";
import NewPost from "./../components/newPost/NewPost"

const Dashboard = () => {


    const [postState, setPostState] = useState([]);    // datas

    const [flag, setFlag] = useState(true);  // preview

    const [selectedId, setSelectedId] = useState(null);





    const fetchData = () => {
        axios.get('http://localhost:8080/api/v1/posts')
            .then(response => {
                setPostState(response.data)
            })
            .catch(error => {
                console.log(error.message)
            })
    }

    useEffect(() => { fetchData() }, [flag])

const selectHandler = (id)=>{
    setSelectedId(id)
    console.log(id);
}

// Delete posts by id

const deleteHandler = (id)=>{
    axios.delete(`http://localhost:8080/api/v1/posts/delete/${id}`)
    .then(()=>{
        setPostState(postState.filter(p=>p.id !== id))
        setSelectedId(null)
    })
}
const updateFlag = () => {
    setFlag(!flag);
}







    return (<div>

        <div className="Post">
            <Posts
                data={postState}
                setSelected={selectHandler}
                deletePost={deleteHandler}
            />
        </div>

        <div>
            <PostDetails 
             id={selectedId}
             title={{ ...postState[selectedId - 1] }.title}
             author={{ ...postState[selectedId - 1] }.author}
             content={{ ...postState[selectedId - 1] }.content}
             deletePost={deleteHandler}
            />
        </div>
        <div>
        < NewPost
                    id={postState.id}
                    title={postState.title}
                    author={postState.author}
                    content={postState.content}
                    updateFlag={updateFlag}
                    />
        </div>


    </div>);
}

export default Dashboard;