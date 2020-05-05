$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
});

//SAVE ============================================
$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateHospitalForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	var type = ($("#hidHospitalIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "HospitalAPI",
		type : type,
		data : $("#formHospital").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onHospitalSaveComplete(response.responseText, status);
		}
	});
});


function onHospitalSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#hospitlDetailGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidHospitalIDSave").val("");
	$("#formHospital")[0].reset();
}

//CLIENT-MODEL================================================================
function validateHospitalForm() {

	// hospital
	if ($("#hospitalName").val().trim() == "") {
		return "Insert Hospital Name.";
	}
	// city
	if ($("#city").val().trim() == "") {
		return "Insert City.";
	}
	// address
	if ($("#address").val().trim() == "") {
		return "Insert Address.";
	}

	// email
	if ($("#email").val().trim() == "") {
		return "Insert Email.";
	}
	
	// contact number
	if ($("#contactNumber").val().trim() == "") {
		return "Insert Contact Number.";
	}

	return true;
}

//Delete-----------------------------
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "HospitalAPI",
		type : "DELETE",
		data : "id=" + $(this).data("itemid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});

function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#hospitlDetailGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

	
//UPDATE==========================================
$(document).on('click', '.btnUpdate', function(event)
{
 $('#hidHospitalIDSave').val($(this).closest('tr').find('#hidItemIDUpdate').val());
 $('#hospitalName').val($(this).closest('tr').find('td:eq(1)').text());
 $('#city').val($(this).closest('tr').find('td:eq(2)').text());
 $('#address').val($(this).closest('tr').find('td:eq(3)').text());
 $('#email').val($(this).closest('tr').find('td:eq(4)').text());
 $('#contactNumber').val($(this).closest('tr').find('td:eq(5)').text());
});










