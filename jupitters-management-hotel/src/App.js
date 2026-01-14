import logo from './logo.svg';
import './App.css';
import Navbar from './component/common/Navbar'/;
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <div className='App'>
        <Navbar />
        <div className='content'>
          <Route />
        </div>
        <Footer />
      </div>
    </BrowserRouter>
  );
}

export default App;
