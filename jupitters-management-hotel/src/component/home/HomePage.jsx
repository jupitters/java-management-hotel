import React from 'react'

const HomePage = () => {
  return (
    <div>
        <section>
            <header className="header-banner">
                <img src="./assets/images/hotel.webp" alt="Phegon Hotel" className="header-image" />
                <div className="overlay"></div>
                <div className="animated-texts overlay-content">
                    <h1>
                        Welcome to <span className="phegon-color">Phegon Hotel</span>
                    </h1><br />
                    <h3>Step into a haven of comfort and care</h3>
                </div>
            </header>
        </section>
    </div>
  )
}

export default HomePage