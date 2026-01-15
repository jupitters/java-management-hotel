import './App.css';
import Navbar from './component/common/Navbar';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomePage from './component/home/HomePage';
import Footer from './component/common/Footer';


function App() {
  return (
    <BrowserRouter>
      <div className='App'>
        <Navbar />
        <div className='content'>
          <Routes >
            <Route exact path='/home' element={<HomePage />} />
          </Routes>
        </div>
        <Footer />
      </div>
    </BrowserRouter>
  );
}

export default App;
