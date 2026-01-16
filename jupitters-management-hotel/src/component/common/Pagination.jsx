import React from 'react'

const Pagination = ({ roomsPerPage, totalRooms, currentPage, paginate }) => {
  const pageNumbers = [];
  for(let i = 1; i < Math.ceil(totalRooms / roomsPerPage); i++){
    pageNumbers.push(i);
  }

  return (
    <div className='pagination-nav'>
      <ul className='pagination-ul'>
        {Pagination.map((number) => (
          <li key={number} className='pagination-li'></li>
        ))}
      </ul>
    </div>
  )
}

export default Pagination