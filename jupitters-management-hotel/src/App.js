import logo from './logo.svg';
import './App.css';
import Navbar from './component/common/Navbar'/;
import { BrowserRouter } from 'react-router-dom';
import HomePage from './component/home/HomePage';

function App() {
  return (
    <BrowserRouter>
      <div className='App'>
        <Navbar />
        <div className='content'>
          <Route exact path='/home' element={<HomePage />} />
        </div>
        <Footer />
      </div>
    </BrowserRouter>
  );
}

export default App;
