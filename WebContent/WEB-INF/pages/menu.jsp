<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
 
    Header webshopa. U zavisnosti od toga da li je ulogovan korisnik, administrator,
    ili nije ulogovan niko, menja se prikazani meni u headeru.
--%>

<%@page import="domain.User"%>
<%@page import="util.Db"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>

<c:out value="${sessionScope.username}"></c:out>

<header>
</header>


<a href="../application/city?operation=allCities">All cities</a>
<a href="../application/city?operation=NewCity">New city</a>


<div id="prazan"></div>
<div class="header">
<div class="dropdown">
  <button class="dropbtn">Cities</button>
  <div class="dropdown-content">
    <a href="../application/city?operation=allCities">Show them all</a>
    <a href="../application/city?operation=NewCity">Add new city</a>
    <a href="#">Link 3</a>
  </div>
</div>

            
     


    </div>
  
    <div class="navdropdown" style="float:right;">
        <button class="navdropbtn">Logout</button>
        <div class="navdropdown-content">
            <a href="#"><c:out value="${sessionScope.username}"></c:out></a>
        </div>


    </div>



</div> </div> 


