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
    }
};

function sendTheModal(o){

	myRequest.open('GET', o);

	myRequest.send();
}

