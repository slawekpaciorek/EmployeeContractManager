$(document).ready(function(){
    if (window.location.pathname == "/dodaj-nowa") {
    $(".form-button").find("button:last-of-type").hide();
}
else {
    $(".form-button").find("button:first-of-type").hide();
}
});