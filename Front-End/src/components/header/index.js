import React from 'react'
import img1 from '../images/abclogo.svg';
import img2 from '../images/hrclogo.svg';

export const Header = () => {
return(
  <div className="head">
      <img  src={img1} />
      <img  style={{marginLeft:"25rem"}} src={img2}/>
      <p style={{ color: "#db4437", fontWeight: "700" }}>Invoice List</p>
  </div>
  )
}