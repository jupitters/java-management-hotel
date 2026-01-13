import React from 'react'
import ApiService from '../../service/ApiService'

const Navbar = () => {
    const isAuthenticated = ApiService.isAuthenticated();
    const isAdmin = ApiService.isAdmin();
    const isUser = ApiService.isUser();

  return (
    <div>Navbar</div>
  )
}

export default Navbar