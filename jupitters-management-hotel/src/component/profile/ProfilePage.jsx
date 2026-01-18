import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const ProfilePage = () => {
    const [user, setUser] = useState(null);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

  return (
    <div>ProfilePage</div>
  )
}

export default ProfilePage