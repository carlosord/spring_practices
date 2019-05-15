
myRequest.onreadystatechange = function () {

    if (myRequest.readyState === 4) {

        document.getElementById('ajax-content').innerHTML = myRequest.responseText;
    }
};

function sendTheModal(o){
	var myRequest = new XMLHttpRequest();

	myRequest.open('GET', o);

	myRequest.send();
}

