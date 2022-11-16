import React from 'react'
import Card from 'react-bootstrap/Card'

function Child(props) {
   
  return (
    <div>
        <input onChange={(e)=>props.setInput(e.target.value)}/>
        {props.data.splice(0,11).map(item=>{

        return(
               
            <div key={item.id}>
                <Card>
                    <Card.Img src={item.url} />
                </Card>
            </div>
        )
    })}</div>
  )
}

export default Child