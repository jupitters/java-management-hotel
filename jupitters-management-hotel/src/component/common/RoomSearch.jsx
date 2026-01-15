import React, { useEffect, useState } from 'react'
import ApiService from '../../service/ApiService';

const RoomSearch = ({ handleSearchResult }) => {
    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);
    const [roomType, setRoomType] = useState('');
    const [roomTypes, setRoomTypes] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchRoomTypes = async () => {
            try{
                const types = await ApiService.getRoomTypes();
                setRoomTypes(types);
            }catch(err){
                console.error(err.message);
            }
        }
        fetchRoomTypes(); 
    }, [])

  return (
    <div>RoomSearch</div>
  )
}

export default RoomSearch