import './App.css';
import Navbar from './component/common/Navbar';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomePage from './component/home/HomePage';
import Footer from './component/common/Footer';
import AllRoomsPage from './component/booking_rooms/AllRoomsPage';
import FindBookingPage from './component/booking_rooms/FindBookingPage';
import RoomDetailsPage from './component/booking_rooms/RoomDetailsPage';
import LoginPage from './component/auth/LoginPage';
import RegisterPage from './component/auth/RegisterPage';


function App() {
  return (
    <BrowserRouter>
      <div className='App'>
        <Navbar />
        <div className='content'>
          <Routes >
            <Route exact path='/' element={<HomePage />} />
            <Route exact path='/home' element={<HomePage />} />
            <Route exact path='/rooms' element={<AllRoomsPage />} />
            <Route path='/find-booking' element={<FindBookingPage />} />
            <Route path='/room-details/:roomId' element={<RoomDetailsPage />} />
            <Route path='/login' element={<LoginPage />} />
            <Route path='/register' element={<RegisterPage />} />
          </Routes>
        </div>
        <Footer />
      </div>
    </BrowserRouter>
  );
}

export default App;
