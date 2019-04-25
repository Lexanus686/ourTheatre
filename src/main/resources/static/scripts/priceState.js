function priceAndPlaceState() {
    var a = 110;
    var b = 420;
    var id = document.title.substring(document.title.indexOf("vent") + 4);
    $.ajax({
        url: 'getPrices',
        type: 'GET',
        data: ({
            myId: id
        }),
        success: function (data) {
            alert("OK");
            alert(data);
        },
        error: function (e) {
            alert(e);
        }
    })
}