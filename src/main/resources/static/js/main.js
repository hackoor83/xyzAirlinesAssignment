$(document).ready(function() {
    $("#amsterdamButton").click(listPlanes);
    $("#londonButton").click();
    $("#parisButton").click();
    $("#stockholmButton").click();
    $("#berlinButton").click();

});

//Listing available airplanes at the location
function listPlanes() {

    let airplanesTable = $("#listAirplanesTable").DataTable({
        ajax: {
            url: 'api/airplane',
            dataSrc: ''
        },
        columns: [
            { data: 'airplaneId' },
            { data: 'fuelAmount' },
            { data: 'airport.location' },
            {
                data: null,
                render: function(data, type, row) {
                    // return '<td><button class="delete btn btn-warning" onclick="flyAirplane(' + data.airplaneId + "," + data.airport.airportId + ')" planeId="' + data.airplaneId + '">Fly to..</button></td>';
                    return '<td><button class="delete btn btn-warning" onclick="flyAirplane(' + data.airplaneId + "," + data.airport.airportId + "," + 34 + ')" planeId="' + data.airplaneId + '">Fly to..</button></td>';
                }
            },
            {
                data: null,
                render: function(data, type, row) {
                    return '<td><button class="btn btn-success" planeId="' + data.airplaneId + '">Refuel</button></td>';
                }
            }
        ]
    });

}

//To change airplane location
function flyAirplane(airplaneId, currentAirportId, newAirportId) {
    console.log('airplane id: ' + airplaneId);
    console.log('current airport id: ' + currentAirportId);
    console.log('new airport id: ' + newAirportId);
    let relocatedAirplane = {
        airplaneId: airplaneId,
        fuelAmount: 5,
        airport: newAirportId
    }

    let jsonObject = JSON.stringify(relocatedAirplane);

    $.ajax({
        url: 'api/airplane/update/' + airplaneId + '/' + currentAirportId,
        contentType: 'json/application',
        data: jsonObject,
        success: function() {
            alert('Airplane gone!')
        },
        error: function() {
            alert('ERROR');
        }
    });

}