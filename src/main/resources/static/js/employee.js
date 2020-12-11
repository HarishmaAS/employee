

$(document).ready(function() {

 
 //employeeList();





});




	function employeeList() {

		$.post("/employee", {}, function(result, status) {
			
			var re = JSON.parse(JSON.stringify(result))
			var html = "";

			for (var i = 0; i < re.length; i++) {
				var empId = re[i]['id'];
				
				
				html += 
				"<li><a href='@{/employeedetails(employeeId="+empId+")}' >" + re[i]['first_name'] + "</a></li>";
			}
			$('#employeeContainer').append(html);
		})
	}