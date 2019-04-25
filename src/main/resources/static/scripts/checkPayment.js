function checkPayment() {
    var card = $("#pan_visible").val();

    var ccv = $("#iCVC").val();

    var cardArray = [];
    var i;

    for (i = 0; i < 4; i++) {
        if (i !== 3)
            cardArray[i] = card.slice(0, card.indexOf(" "));
        else cardArray[i] = card;
        card = card.substring(card.indexOf(" ") + 1, card.length);
    }

    var answer = 0;
    i = 0;
    while (answer === 0 && i < 4) {
        answer = parseInt(cardArray[i]) % parseInt(ccv);
        i++;
    }

    $.ajax({
        url: 'verificationAnswer',
        type: 'GET',
        data: ({
            myAnswer: answer
        }),
        success: function (data) {
            alert(data + "!");
            if (data === "Success") {
                alert("Sending you a ticket. Redirecting to main page...")
            }
            alert("Redirecting to main page...");
            window.location.replace("http://localhost:8090");
        }
    })
}