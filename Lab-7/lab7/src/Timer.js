import React, { useEffect, useState } from 'react'

function Timer() {
    const [timeLeft, setTimeLeft] = useState(6);

    useEffect(() => {
        if(timeLeft===0){
           console.log("TIME LEFT IS 0");
           setTimeLeft(null)
        }
    
       
        if (!timeLeft) return;
    

        const intervalId = setInterval(() => {
    
          setTimeLeft(timeLeft - 1);
        }, 1000);
    
       
        return () => clearInterval(intervalId);
       
      }, [timeLeft]);

    return (
      <React.Fragment>
        {timeLeft}
        <button onClick={()=>setTimeLeft(5)} >
                Stop
        </button>
      </React.Fragment>
     )
    
}

export default Timer