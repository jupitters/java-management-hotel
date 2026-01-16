import React, { useState } from 'react'
import ApiService from '../../service/ApiService';

const FindBookingPage = () => {
    const [confirmationCode, setConfirmationCode] = useState('');
    const [bookingDetails, setBookingDetails] = useState(null);
    const [error, setError] = useState(null);

    const handleSearch = async () => {
        if (!confirmationCode.trim()) {
            setError("Please Enter a booking confirmation code");
            setTimeout(() => setError(''), 5000);
            return;
        }
        try {
            // Call API to get booking details
            const response = await ApiService.getBookingByConfirmationCode(confirmationCode);
            setBookingDetails(response.booking);
            setError(null); // Clear error if successful
        } catch (error) {
            setError(error.response?.data?.message || error.message);
            setTimeout(() => setError(''), 5000);
        }
    };
    
  return (
    <div className="find-booking-page">
        <h2>Find Booking</h2>
        <div className="search-container">
            <input
                required
                type="text"
                placeholder="Enter your booking confirmation code"
                value={confirmationCode}
                onChange={(e) => setConfirmationCode(e.target.value)}
            />
            <button onClick={handleSearch}>Find</button>
        </div>
    </div>
  )
}

export default FindBookingPage