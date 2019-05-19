$(function () {
    findAllStudents();

    // 查询数据
    $("#query").click(function () {
        var id = $("#id").val();
        if (id != null){
            getStudentById(id);
        }else {
            findAllStudents();
        }
    });

    // 事件委托，删除数据
    $("#tbody").on("click",".btn-info",function () {
        var flag =confirm("是否删除本条数据？");
        if (flag){
            deleteData(this);
        }
    });

    $("#add").click(function () {
        $(location).attr("href","/Pages/addStudent.html");
    })


});

function findAllStudents() {
    $.ajax({
        url: "/Student/getStudents",
        type: "get",
        dataType: "JSON",
        success: function (result) {
            var dataTR = "";
            $.each(result, function (index, value) {
                dataTR += "<tr>" +
                    "<td>" + value.id + "</td>" +
                    "<td>" + value.name + "</td>" +
                    "<td>" + value.age + "</td>" +
                    "<td>" + value.sex + "</td>" +
                    "<td>" + value.grade + "</td>" +
                    "<td>" + value.course_id + "</td>" +
                    "<td>" + value.score + "</td>" +
                    "<td>" +
                    "<button type='button' class='btn btn-sm btn-info' >删除</button>" +
                    "<button type='button' class='btn btn-sm btn-warning' >修改</button>" +
                    "</td>" + "</tr>"
            });
            $("tbody").html(dataTR);
        }
    })
}

function getStudentById(studentID) {
    $.ajax({
        url: "/Student/getStudent/" + studentID,
        type: "get",
        dataType: "JSON",
        success: function (result) {
            var dataTR = "";
            console.log(result);
            $.each(result,function (index,value) {
                dataTR += "<tr>"+
                    "<td>"+value.id+"</td>"+
                    "<td>"+value.name+"</td>"+
                    "<td>"+value.age+"</td>"+
                    "<td>"+value.sex+"</td>"+
                    "<td>"+value.grade+"</td>"+
                    "<td>"+value.course_id+"</td>"+
                    "<td>"+value.score+"</td>"+
                    "<td>" +
                    "<button type='button' class='btn btn-sm btn-info' >删除</button>" +
                    "<button type='button' class='btn btn-sm btn-warning' >修改</button>" +
                    "</td>" + "</tr>"
            });
            $("tbody").html(dataTR);
        }
    })
}

function deleteData(obj) {
    var studentID = obj.parentNode.parentNode.firstChild.innerHTML;
    console.log(studentID);
    $.ajax({
        url:"/Student/student/"+studentID,
        type:"delete",
        dataType:"JSON",
        success:function (result) {
            if (result === "success") {
                findAllStudents();
                $("#msg").html("<p class=\"alert alert-info\" role=\"alert\">删除成功!</p>");
                setTimeout(function () {
                    $("#msg").empty();
                },2000);
            }else {
                $("#msg").html("<p class=\"alert alert-warning\" role=\"alert\">删除失败!</p>")
                setTimeout(function () {
                    $("#msg").empty();
                },2000);
            }
        }
    })
}