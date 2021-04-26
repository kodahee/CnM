/**
 * 
 */

$(".adult").on("click", function() {
	console.log($(this).val());
});

$(".kids").on("click", function() {
	console.log($(this).val());
});

$(".seatName").on("click", function() {
	let row = $(".row").html();
	console.log(row + $(this).val());
});

