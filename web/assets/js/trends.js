var map;
var marker;
function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: -34.397, lng: 150.644},
        zoom: 10
    });
    var infoWindow = new google.maps.InfoWindow({map: map});

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var pos = {
                lat: position.coords.latitude,
                lng: position.coords.longitude
            };
            marker = new google.maps.Marker({
                position: pos,
                map: map,
            });


            handleTrendRequest(pos.lat, pos.lng);
            map.setCenter(pos);
        }, function () {
            handleLocationError(true, infoWindow, map.getCenter());
        });
    } else {
        handleLocationError(false, infoWindow, map.getCenter());
    }


    map.addListener('click', function (e) {
        marker.setMap(null);
        handleTrendRequest(e.latLng.lat, e.latLng.lng);
        marker = new google.maps.Marker({
            position: e.latLng,
            map: map,
        });
    });


}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
}
function handleTrendRequest(lat, lon) {
    $.ajax("trends", {
        "type": "GET",
        "data": {
            "lat": lat,
            "lon": lon
        },
        "beforeSend": handleBefore,
        "error": handleFail,
        "success": handleSuccess,
        "done": handleDone
    })

}
function handleBefore() {

    $("#trends").empty();
    $("#trends").append('<img src="/TwitterBarProject/assets/img/small_loading.gif" /> Loading ...')

}
function handleSuccess(data) {
    $("#trends").empty();
    $("#trends").append(data);
}
function handleDone() {
}
function handleFail(jqXHR, textStatus, errorThrown) {
    alert(jqXHR);
    alert(textStatus);
    alert(errorThrown)
}
