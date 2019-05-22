$(document).ready(function() {
	 $("#tableCar").DataTable({searching: false, paging: false, info: false});
	 $("#tableHotel").DataTable({searching: false, paging: false, info: false});
});

$( "a[id^='infoModal']").click(function(){
	var url = this.href;
	$.ajax(
		url
	).done(function(data){

			var content = jQuery.parseJSON(JSON.stringify(data));

			$('#modalDni').html(content.person.dni);
			$('#modalName').html(content.person.name);
			$('#modalAge').html(content.person.age);
			$('#modalLastName').html(content.person.lastname);
			$('#modalGender').html(content.person.gender);
			$('#modalBirthday').html(content.person.birthday);
			$('#modalEmail').html(content.person.email);

			carDataTable(content.carList);
			hotelDataTable(content.hotelList);

	}).fail(function(e){
	});
});

function carDataTable(data) {

	$("#tableCar").DataTable().clear();
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

	$("#tableHotel").DataTable().clear();
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
