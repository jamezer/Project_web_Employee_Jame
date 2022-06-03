/**
 * 
 */
$(document).ready(function() {
	
	$( "#btnHRLogin" ).click(function() {
		$('#logintype').val('HR');
		$('#formLogin').submit();
	});
	
	$( "#btnCLLSLogin" ).click(function() {
		$('#logintype').val('CLLS');
		$('#formLogin').submit();
	});
	
});