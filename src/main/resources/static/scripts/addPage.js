function eventSend(num) {
    var msg = "event" + num;
    $.ajax({
        url: 'getPageTitle',
        type: 'GET',
        data: ({
            myString: msg
        }),
        success: function (data) {
            // alert("yes");
        }
    });
}

function makePayment() {

    var arrayData = [];

    arrayData[0] = document.title.substring(document.title.indexOf("vent") + 4);

    var style = document.getElementsByClassName("place ticket selected").item(0).getAttribute("style");
    arrayData[1] = (parseInt(style.substring(style.indexOf(":") + 1, style.indexOf(":") + 4)) - 60) / 50;
    var rowStr = String(arrayData[1]);

    arrayData[2] = (parseInt(style.substring(style.lastIndexOf(":") + 1, style.lastIndexOf(":") + 4)) - 390) / 30;
    var placeStr = String(arrayData[2]);

    arrayData[3] = localStorage.getItem(rowStr + "." + placeStr);

    $.ajax({
        url: 'makePayment',
        type: 'GET',
        data: ({
            myArray: arrayData
        }),
        success: function (data) {
            // alert("yep");
        }
    })
}