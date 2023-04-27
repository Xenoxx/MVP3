import React from "react";
import { Link } from "react-router-dom";

function NavBar() {
  return (
    <div className="header-container">
      <div className="header-left">
        <Link to="/">Home</Link>
      </div>
      <div className="header-center">
        <Link to="/page1">Page 1</Link>
        <Link to="/page2">Page 2</Link>
        <Link to="/page3">Page 3</Link>
      </div>
    </div>
  );
}

export default NavBar;
