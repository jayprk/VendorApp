<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
<img src="../Images/banner.jpg"/>
<div class="navbar">
  <a href="#home">Home</a>
  
  
  <!-- Location Start-->
  <div class="dropdown">
    <button class="dropbtn">LOCATION 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="locHome">Register</a>
      <a href="ViewAllItems">View All</a>
      <a href="itemPdfExport">PDF Format</a>
      <a href="itemExcelExport">Excel Format</a>
      <a href="itemReport">Reports</a>
    </div>
  </div> 
  <!-- Location End -->
  
  <!-- Vendor Start-->
  <div class="dropdown">
    <button class="dropbtn">VENDOR 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="venHome">Register</a>
      <a href="viewAllVendor">View All</a>
      <a href="venPdfExport">PDF Format</a>
      <a href="venExelExport">Excel Format</a>
      <a href="venReport">Reports</a>
    </div>
  </div> 
  <!-- Vendor End -->
  
  
  <!-- Customer Start -->
  <div class="dropdown">
    <button class="dropbtn">CUSTOMER 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="custReg">Register</a>
      <a href="ViewAllCust">View All</a>
      <a href="custPdfExport">PDF Format</a>
      <a href="custExcelExport">Excel Format</a>
      <a href="custReport">Reports</a>
    </div>
  </div> 
  <!-- Customer End -->
  
  <!-- Item Start -->
  <div class="dropdown">
    <button class="dropbtn">Item 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="itemHome">Register</a>
      <a href="ViewAllCust">View All</a>
      <a href="custPdfExport">PDF Format</a>
      <a href="custExcelExport">Excel Format</a>
      <a href="custReport">Reports</a>
    </div>
  </div> 
  <!-- Item End -->
  
  <!-- Docs start-->
  <!-- 	<a href="showDocs">DOCUMENTS</a> -->
  <div class="dropdown">
    <button class="dropbtn"> DOCUMENTS
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="showDocs">Show Documents</a>
    </div>
  </div> 
  <!-- Docs End -->
  
  
  
</div>
