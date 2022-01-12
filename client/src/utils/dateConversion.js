


function convertDateToFrenchFormat(date){
    const dateFormated = new Date(date)
    const dd = String(dateFormated.getDate()).padStart(2, '0');
    const mm = String(dateFormated.getMonth() + 1).padStart(2, '0'); //January is 0!
    const yyyy = dateFormated.getFullYear();
    return mm + '/' + dd + '/' + yyyy;
}

export { convertDateToFrenchFormat}
