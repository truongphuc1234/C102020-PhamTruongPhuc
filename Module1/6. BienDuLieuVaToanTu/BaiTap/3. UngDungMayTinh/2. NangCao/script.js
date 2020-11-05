
$(".input-button").click(addSymbol());
function addSymbol() {
    $("#input").text += $(this).value;
}
;