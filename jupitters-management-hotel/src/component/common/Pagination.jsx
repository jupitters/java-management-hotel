import React from 'react'

const Pagination = ({ roomsPerPage, totalRooms, currentPage, paginate }) => {
  const pageNumbers = [];
  for(let i = 1; i < Math.ceil(totalRooms / roomsPerPage); i++){
    pageNumbers.push(i);
  }

  return (
    <div>Pagination</div>
  )
}

export default Pagination