<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL</h1>
	<p>jstl 을 사용하려면 먼저 taglib 설정을 해야 합니다.
	<strong>prefix 속성은 </strong> 태그라이브러리 사용할 때, 태그 앞에 붙는 접두어를 설정
		c 접두어는 if, for 등 기본 문법에 사용합니다. 
		<strong>uri 속성</strong>은 c 접두어롤 사용할 태그를 해설할 uri 주소입니다. 
	  </p>
		<h3>c: 으로 시작하는 core 태그 사용</h3>
		<!--1. 변수에 값 저장하기   -->
		<c:set var="age" value="13"/>
		<%--2. 변수값 출력하기 value 속성에 출력할 값 지정 
			변수를 사용할 때에는 ${} EL 기호안에 작성 
		  --%>
		<h4>나이 :<c:out value="${age }"></c:out></h4>
		<!-- EL 기호에 작성한 변수가 없을 때 오류 발생하디 않고. 빈 문자열 출력  -->
		<h4>이름 :<c:out value="${name }"></c:out></h4>
		<!--3. if test 속성값에 조건식. 조건식은 EL 기호안에 작성.  -->
		<h4>if 연습</h4>
		<c:if test ="${age >=20 }">
			<div style="color:red">성인 입니다. </div>
		</c:if>
		<!-- else 형식이 없으므로 한번더 if  -->
		<c:if test ="${age < 20 }">
			<div style="color:red">청소년 입니다. . </div>
		</c:if>
		
		<!--4. switch  -->
		<h4>switch 연습</h4>
		<c:set var="age" value="25" />  <!-- age 변수값 변경  -->
		<!-- 회원 가입 나이 조건을 15~60세  -->
		<c:choose>
			<%--조건을 여거개 검사해야 할 때 c: when 은 여러번 작성 가능  --%>
			<c:when test="${age>= 15 && age <=60}">
			   <div style = "color:green">회원 가입 가능한 아이 입니다.</div>
			   </c:when>
			   <c:otherwise>
			   <div style = "color:red">회원 가입 조건에 맞지 않습니다..</div>
			   </c:otherwise>
			   </c:choose>
		
		<!--5. for  -->
		<h4>forEach 연습</h4>
		<c:forEach begin="10" end="20">
			<h4><c:out value="${i }"/></h4>
		
		
		
		</c:forEach>		
		
</body>
</html>