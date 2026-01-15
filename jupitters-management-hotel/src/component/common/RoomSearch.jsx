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

    const showError = (message, timeOut = 5000) => {
        setError(message);
        setTimeout(() => {
            setError('');
        }, timeOut)
    };

  return (
    <section>
        <div className='search-container'>
            <div className='search-field'>
                <label>Check-In Date</label>
                <DatePicker 
                    selected={startDate}
                    onChange={(date) => setStartDate(date)}
                    dateFormat="dd/MM/yyyy"
                    placeholderText="Select Check-In Date"/>
            </div>
        </div>
    </section>
  )
}

export default RoomSearch