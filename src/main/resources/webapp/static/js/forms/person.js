$('#name').change(function(){
	loadFullName();
});

$('#lastname').change(function(){
	loadFullName();
});

$('#birthdayday').change(function(){
	loadAge();
});
$('#birthdaymonth').change(function(){
	loadAge();
});
$('#birthdayyear').change(function(){
	loadAge();
});

function loadFullName(){
	$('#fullname').val($('#name').val().concat(' ').concat($('#lastname').val()));
}

function loadAge(){
	var birthday_date = new Date($('#birthdayyear').val(), $('#birthdaymonth').val()-1, $('#birthdayday').val());
	var ageDifMs = Date.now() - birthday_date.getTime();
    var ageDate = new Date(ageDifMs);
	$('#age').val(Math.abs(ageDate.getUTCFullYear() - 1970));
}