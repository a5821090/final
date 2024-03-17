function generateForm() {
    var planInput = document.getElementById("plan");
    var days = parseInt(planInput.value);

    var formHtml = "<p>用務について記入してください</p>";

    for (var i = 1; i <= days; i++) {

        formHtml += "<form><div class='text_input'><label for='day" + i + "'>" + i + "日目:</label>";
        formHtml += "<input type='text' id='day" + i + "' required><br></div></form>";
    }

    formHtml += "<div class='btn'><button class='decorated-btn click-down' id='submit_button' type='button' onclick='generateExcel()'>出力</button></div><br>";

    document.getElementById("result").innerHTML = formHtml;
}

//function calculateDuration() {
//    var resultHtml = "<p>Excelへの出力が完了しました</p>";
//    document.getElementById("result").innerHTML = resultHtml;
//}
function generateExcel(days) {
    // Fetch APIを使用してサーバーサイドのエクセル生成処理を呼び出す
    var days = $("#plan").val();
    var textData = [];

    for (var i = 1; i <= days; i++) {
        var dayText = $("#day" + i).val();
        textData.push({ day: i, text: dayText });
    }

    var requestData = { n: days, textData: textData };

    fetch("/generate-excel", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(requestData),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Network response was not ok");
        }
        return response.json();
    })
    .then(result => {
        // エクセル生成が成功した場合の処理
        var resultHtml = "<p>Excelへの出力が完了しました</p><div class='btn'><button class='decorated-btn click-down' onclick=\"location.href='http://localhost:8080/top'\" >トップに戻る</button></div><br>";
 document.getElementById("result").innerHTML = resultHtml;
    })
    .catch(error => {
        // エクセル生成が失敗した場合の処理
        alert("エクセル生成に失敗しました。");
        console.error("Fetch Error: ", error);
    });
}

//function generateExcel(days) {
//    // Ajaxを使用してサーバーサイドのエクセル生成処理を呼び出す
//    $.ajax({
//        url: "/generate-excel",
//        type: "GET",
//        data: { n: days }, // データをサーバーに送る
//        success: function(response) {
//            // エクセル生成が成功した場合の処理
//            var resultHtml = "<p>Excelへの出力が完了しました</p>";
//            document.getElementById("result").innerHTML = resultHtml;
//        },
//        error: function(xhr,status,error) {
//            // エクセル生成が失敗した場合の処理
//            alert("エクセル生成に失敗しました。");
//            console.log("XMLHttpRequest : " + xhr.status);
//                        console.log("textStatus     : " + status);
//                        console.log("errorThrown    : " + error.message);
//        }
//    });
//}