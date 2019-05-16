var myRequest = new XMLHttpRequest();

myRequest.onreadystatechange = function () {
    if (myRequest.readyState === 4) {

    	var data = myRequest.responseText;
    	var content = JSON.parse(data);

        document.getElementById('modalDni').innerHTML = content.person.dni;
        document.getElementById('modalName').innerHTML = content.person.name;
        document.getElementById('modalAge').innerHTML = content.person.age;
        document.getElementById('modalLastName').innerHTML = content.person.lastname;
        document.getElementById('modalGender').innerHTML = content.person.gender;
        document.getElementById('modalBirthday').innerHTML = content.person.birthday;

        carDataTable(content.carList);
        hotelDataTable(content.hotelList);

        };
};

function sendTheModal(o){

	myRequest.open('GET', o);

	myRequest.send();
}

function carDataTable(data) {

	var dt;
	if ( $.fn.dataTable.isDataTable( '#tableCar' ) ) {
		dt = $("#tableCar").DataTable();
	}
	else{
		dt = $("#tableCar").DataTable({searching: false, paging: false, info: false});
	}

    dt.clear();
    var length = Object.keys(data).length;
    for(var i = 0; i < length; i++) {
      var car = data[i];


      $('#tableCar').dataTable().fnAddData( [
    	 car.license,
    	 car.colour,
    	 car.startCarReserve,
    	 car.finishCarReserve
      ]);
    }
  }

function hotelDataTable(data) {

	var dt;
	if ( $.fn.dataTable.isDataTable( '#tableHotel' ) ) {
		dt = $("#tableHotel").DataTable();
	}
	else{
		dt = $("#tableHotel").DataTable({searching: false, paging: false, info: false});
	}
    dt.clear();
    var length = Object.keys(data).length;
    for(var i = 0; i < length; i++) {
      var hotel = data[i];


      $('#tableHotel').dataTable().fnAddData( [
    	 hotel.name,
    	 hotel.location,
    	 hotel.startHotelReserve,
    	 hotel.finishHotelReserve
      ]);
    }

  }
