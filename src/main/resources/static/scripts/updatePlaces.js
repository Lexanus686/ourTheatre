function updatePlaces() {
    localStorage.clear();
    localStorage.setItem("shown", "0");
    $.ajax({
        url: 'updatePlaces',
        type: 'GET',

        success: function (data) {

            var i, j;
            var str = "";
            var row, place, cost;
            for (i = 0; i < data.length; i++) {
                str = "";
                pair = "";
                row = "";
                place = "";
                cost = "";
                for (j = 0; j < data[i].length; j++) {
                    str += data[i][j];
                }

                row = str.slice(0, str.indexOf(" "));
                place = str.slice(str.indexOf(" ") + 1, str.lastIndexOf(" "));
                cost = str.slice(str.lastIndexOf(" ") + 1, str.length);

                var pair = row + "." + place;

                localStorage.setItem(pair, cost);
                $('.place').eq((parseInt(row) - 1) * 4 + parseInt(place) - 1).toggleClass('ticket')
            }
        }
    });
}