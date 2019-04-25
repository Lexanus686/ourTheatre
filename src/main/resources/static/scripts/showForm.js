function showForm() {
    var shown = localStorage.getItem("shown");

    if (shown === "1") {
        $("#signIn-form").css({"visibility": "hidden"});
        $("#signIn-form").css({"display": "none"});
        localStorage.setItem("shown", "0");
    }

    if (shown === "0") {
        $("#signIn-form").css({"visibility": "visible"});
        $("#signIn-form").css({"display": "block"});
        localStorage.setItem("shown", "1");
    }

}