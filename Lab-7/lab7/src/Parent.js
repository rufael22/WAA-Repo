import React, { useEffect } from 'react'
import axios from'axios'
import Child from './Child'

export default function Parent() {
    const [state, setState] = React.useState([])
    const [input, setInput] = React.useState("")

    useEffect(()=>{
        
        axios.get('https://jsonplaceholder.typicode.com/photos')
        .then(res=>{
            setState(res.data)
        })
    },[])

  return (
    <div>
        <h2>{input}</h2>
        <Child data={state} setInput={setInput}/>
    </div>
  )
}
