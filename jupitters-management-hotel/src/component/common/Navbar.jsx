import React from 'react'
import ApiService from '../../service/ApiService'
import { NavLink } from 'react-router-dom';

const Navbar = () => {
    const isAuthenticated = ApiService.isAuthenticated();
    const isAdmin = ApiService.isAdmin();
    const isUser = ApiService.isUser();

  return (
    <nav className='navbar'>
        <div className='navbar-brand'>
            <NavLink to="/home"> Hotel</NavLink>
        </div>
        <ul>
            <li><NavLink to="/home" activeClass="active"> Home</NavLink></li>
            <li><NavLink to="/rooms" activeClass="active"> Rooms</NavLink></li>
            <li><NavLink to="/find-booking" activeClass="active"> Find My Bookings</NavLink></li>

            <li><NavLink to="/profile" activeClass="active"> Profile</NavLink></li>
            <li><NavLink to="/admin" activeClass="active"> Admin</NavLink></li>
            
            <li><NavLink to="/login" activeClass="active"> Login</NavLink></li>
            <li><NavLink to="/register" activeClass="active"> Register</NavLink></li>

            <li> Logout</li>
        </ul>
    </nav>
  )
}

export default Navbar