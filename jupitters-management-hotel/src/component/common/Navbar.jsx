import React from 'react'
import ApiService from '../../service/ApiService'
import { NavLink } from 'react-router-dom';

const Navbar = () => {
    const isAuthenticated = ApiService.isAuthenticated();
    const isAdmin = ApiService.isAdmin();
    const isUser = ApiService.isUser();

  return (
    <nav>
        <div>

        </div>
        <ul>
            <li><NavLink to="/home" activeClass="active"> Home</NavLink></li>
        </ul>
    </nav>
  )
}

export default Navbar