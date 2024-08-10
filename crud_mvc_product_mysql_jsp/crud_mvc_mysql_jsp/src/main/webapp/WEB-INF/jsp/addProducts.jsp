<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }
        form {
            width: 80%;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h3 {
            color: #555;
        }
        label {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
        }
        input[type="text"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h2>Add Products</h2>
   <form action="${pageContext.request.contextPath}/saveProducts" method="post">
		<c:forEach var="i" begin="1" end="${numberOfProducts}">
		       <h3>Product ${i}</h3>
		       <label for="itemNumber${i}">Item Number:</label>
		       <input type="text" id="itemNumber${i}" name="products[${i - 1}].itemNumber" readonly><br>
		       
		       <label for="itemName${i}">Item Name:</label>
		       <input type="text" id="itemName${i}" name="products[${i - 1}].itemName" required><br>
		       
		       <label for="price${i}">Price:</label>
		       <input type="text" id="price${i}" name="products[${i - 1}].price" required><br>
		       
		       <label for="availability${i}">Availability:</label>
		       <input type="text" id="availability${i}" name="products[${i - 1}].availability" required><br>
		   </c:forEach>
		   <button type="submit">Save Products</button>
    </form>
</body>
</html>
