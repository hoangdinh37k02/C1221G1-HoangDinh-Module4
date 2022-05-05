<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khai báo y tế</title>
</head>
<body>
    <h2>Khai báo y tế</h2>
    <form:form method="post" modelAttribute="medical">
        <div>
            Họ và tên:
            <form:input type="text" path="name"/>
        </div>
        <div>
            Năm sinh:
            <form:input type="number" path="birth"/>
        </div>
        <div>
            Giới tính:
            <form:select  path="gender">
                <form:option value="Nam">Nam</form:option>
                <form:option value="Nữ">Nữ</form:option>
                <form:option value="Khác">Khác</form:option>
            </form:select>
        </div>
        <div>
            Quốc tịch:
            <form:input type="text" path="nation"/>
        </div>
        <div>
            Chứng minh nhân dân:
            <form:input type="text" path="id"/>
        </div>
        <div>
            Thông tin đi lại:
            <form:radiobutton path="transport" value="Tàu bay"/> Tàu bay
            <form:radiobutton path="transport" value="Tàu thuyền"/> Tàu thuyền
            <form:radiobutton path="transport" value="Ô tô"/> Ô tô
            <form:radiobutton path="transport" value="Khác"/> Khác
        </div>
        <div>
            Số hiệu phương tiện:
            <form:input type="text" path="licensePlate"/>
        </div>
        <div>
            Ngày khởi hành:
            <form:input type="date" path="startDay"/>
        </div>
        <div>
            Ngày kết thúc:
            <form:input type="date" path="endDay"/>
        </div>
        <div>
            Trong 14 ngày, anh chị đi những đâu
            <form:textarea rows="5" cols="100" path="route"/>
        </div>
        <div>
            <input type="submit" value="Gửi khai báo">
        </div>
    </form:form>
</body>
</html>
