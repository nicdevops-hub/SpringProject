<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<style type="text/css">
div.blueTable {
  font-family: Tahoma, Geneva, sans-serif;
  border: 1px solid #1C6EA4;
  background-color: #EEEEEE;
  width: 100%;
  text-align: right;
  border-collapse: collapse;
}
.divTable.blueTable .divTableCell, .divTable.blueTable .divTableHead {
  border: 1px solid #AAAAAA;
  padding: 3px 2px;
}
.divTable.blueTable .divTableBody .divTableCell {
  font-size: 13px;
  font-weight: bold;
}
.divTable.blueTable .divTableRow:nth-child(even) {
  background: #D0E4F5;
}
.divTable.blueTable .divTableHeading {
  background: #1C6EA4;
  background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
  background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
  background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);
  border-bottom: 2px solid #444444;
}
.divTable.blueTable .divTableHeading .divTableHead {
  font-size: 15px;
  font-weight: bold;
  color: #FFFFFF;
  text-align: center;
  border-left: 2px solid #D0E4F5;
}
.divTable.blueTable .divTableHeading .divTableHead:first-child {
  border-left: none;
}

.blueTable .tableFootStyle {
  font-size: 14px;
  font-weight: bold;
  color: #FFFFFF;
  background: #D0E4F5;
  background: -moz-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
  background: -webkit-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
  background: linear-gradient(to bottom, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);
  border-top: 2px solid #444444;
}
.blueTable .tableFootStyle {
  font-size: 14px;
}
.blueTable .tableFootStyle .links {
	 text-align: right;
}
.blueTable .tableFootStyle .links a{
  display: inline-block;
  background: #1C6EA4;
  color: #FFFFFF;
  padding: 2px 8px;
  border-radius: 5px;
}
.blueTable.outerTableFooter {
  border-top: none;
}
.blueTable.outerTableFooter .tableFootStyle {
  padding: 3px 5px; 
}
/* DivTable.com */
.divTable{ display: table; }
.divTableRow { display: table-row; }
.divTableHeading { display: table-header-group;}
.divTableCell, .divTableHead { display: table-cell;}
.divTableHeading { display: table-header-group;}
.divTableFoot { display: table-footer-group;}
.divTableBody { display: table-row-group;}
	</style>
	
	<script>
$(document).ready(function(){
        $.ajax({
            url: "https://kdsgst.smportkolkata.in/koptnicws/v1nic_irn_report/REV&15-11-2020",
            //url: "http://localhost:8080/koptnicws/v1nic_irn_report/REV&15-112020",
            dataType: 'html',
            success: function (data) {
                $("#report_rev").html(data);
            }});
        
        $.ajax({
            url: "https://kdsgst.smportkolkata.in/koptnicws/v1nic_irn_report/PMS&15-11-2020",
            //url: "http://localhost:8080/koptnicws/v1nic_irn_report/PMS&15-112020",
            dataType: 'html',
            success: function (data) {
                $("#report_pms").html(data);
            }});
        
        $.ajax({
            url: "https://kdsgst.smportkolkata.in/koptnicws/v1nic_irn_report/REV_CRN&15-11-2020",
            //url: "http://localhost:8080/koptnicws/v1nic_irn_report/REV_CRN&15-112020",
            dataType: 'html',
            success: function (data) {
                $("#report_rev_crn").html(data);
            }});
        
        $.ajax({
            url: "https://kdsgst.smportkolkata.in/koptnicws/v1nic_irn_report/PMS_CRN&15-11-2020",
            //url: "http://localhost:8080/koptnicws/v1nic_irn_report/PMS_CRN&15-11-2020",
            dataType: 'html',
            success: function (data) {
                $("#report_pms_crn").html(data);
            }});
});
</script>
</head>
<body>
<div style="width:100%; display: flex; ">
<div style="flex:50% ; float: left; padding: 10px;">
<div ><h1>REV INV</h1></div>
<div id="report_rev" >Wait we are fetching data...</div>
</div>


<div style="flex:50% ; float: left; padding: 10px;">
<div><h1>PMS INV</h1></div>
<div id="report_pms">Wait we are fetching data...</div>
</div>
</div>

<div style="width:100%; display: flex; ">
<div style="flex:50% ; float: left; padding: 10px;">
<div ><h1>REV CRN</h1></div>
<div id="report_rev_crn" >Wait we are fetching data...</div>
</div>


<div style="flex:50% ; float: left; padding: 10px;">
<div><h1>PMS CRN</h1></div>
<div id="report_pms_crn">Wait we are fetching data...</div>
</div>
</div>


<!-- 
<div class="blueTable outerTableFooter">
<div class="tableFootStyle">
<div class="links"><a href="#">&laquo;</a> <a class="active" href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">&raquo;</a></div>
</div>
</div>
 -->
</body>
</html>
