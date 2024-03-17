//15821093
//山岡優希

class DailyAllowanceModel {
    constructor(name, travelHours) {
        this.name = name;
        this.travelHours = travelHours;
        this.dailyAllowance = 0;
    }
}

document.addEventListener("DOMContentLoaded", () => {
    var daily_money = 0;
    var unchin = 0;
    var accommodation_fee = 0;
    // 駅名入力パーツ初期化
    const stationApp1 = new expGuiStation(document.getElementById("station1"));
    const stationApp2 = new expGuiStation(document.getElementById("station2"));
    const dateTimeApp = new expGuiDateTime(document.getElementById("dateTime"));
    dateTimeApp.dispDateTime();
    stationApp1.dispStation();
    stationApp2.dispStation();

    // 経路表示パーツ初期化
    const resultApp = new expGuiCourse(document.getElementById("result"));

    async function calcDailyAllowance(model) {
        const params = {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify(model)
        };

        try {
            const response = await fetch("/calc_daily_allowance2", params);
            const data = await response.json();

            console.log(data);
            daily_money = data.dailyAllowance;
            accommodation_fee = 12000 * (data.travelHours / 24);
            console.log(data.travelHours);
        } catch (error) {
            console.log(error);
        }
    }

    function makeExcel(model) {
        const params = {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify(model)
        };

        fetch("/make_excel", params)
            .then((response) => {
                // handle the response if needed
            })
            .catch((error) => {
                console.log(error);
            });
    }

    document.getElementById("calc_daily_allowance_button").addEventListener("click", async () => {
        console.log("js");

        const Ddatetime = document.getElementById("Ddatetime").value;
        const Adatetime = document.getElementById("Adatetime").value;
        const name = sessionStorage.getItem("name");

        const DdatetimeObj = new Date(Ddatetime);
        const AdatetimeObj = new Date(Adatetime);

        const Dms = DdatetimeObj.getTime();
        const Ams = AdatetimeObj.getTime();

        const msDiff = Ams - Dms;
        const travelHours = msDiff / (1000 * 60 * 60);

        const model = new DailyAllowanceModel(name, travelHours);
        await calcDailyAllowance(model);

        const station1 = stationApp1.getStation();
        const station2 = stationApp2.getStation();

        let searchWord = "viaList=" + stationApp1.getStation() + ":" + stationApp2.getStation();
        searchWord += "&date=" + dateTimeApp.getDate();
        searchWord += "&time=" + dateTimeApp.getTime();
        searchWord += "&answerCount=" + String(3);

        function result(isSuccess) {
            if (isSuccess) {
                unchin = resultApp.getFarePrice();
                console.log(unchin);
                const formattedDepartureDate = formatTime(resultApp.getDepartureDate());
                const formattedArrivalDate = formatTime(resultApp.getArrivalDate());

                console.log("出発日時：" + resultApp.getDepartureDate());
                console.log("到着日時：" + resultApp.getArrivalDate());
                console.log(resultApp.getResultString());

                const data_set = {
                            Syozoku: sessionStorage.getItem("syozoku"),
                            Gakubu: sessionStorage.getItem("gakubu"),
                            Gakka: sessionStorage.getItem("gakka"),
                            Syokumei: sessionStorage.getItem("job_title"),
                            Shimei: sessionStorage.getItem("name"),
                            Syozoku_2: document.getElementById("Syozoku_2").value,
                            Syokumei_2: document.getElementById("Syokumei_2").value,
                            Shimei_2: document.getElementById("Shimei_2").value,
                            Mokuteki: document.getElementById("Mokuteki").value,
                            Youmuchi: document.getElementById("Youmuchi").value,
                            Youmusaki: document.getElementById("Youmusaki").value,
                            Nittei_1: document.getElementById("Ddatetime").value,
                            Nittei_2: document.getElementById("Adatetime").value,
                            Syuttyouzikan: document.getElementById("Syuttyouzikan").value,
                            Nittou: daily_money + "",
                            Unchin: unchin + "",
                            Syukuhakuhi: accommodation_fee + "",
                        };
                        console.log(data_set);
                        makeExcel(data_set);
            } else {
                alert("探索結果が取得できませんでした");
            }
        }
        document.getElementById("select_button").addEventListener("click", () => {
            const departure_time = formatTime(resultApp.getDepartureDate().getTime());
            const route = resultApp.getLineList().split(",");
            const route_station = resultApp.getPointList().split(",");
            const arrival_time = formatTime(resultApp.getArrivalDate().getTime());

            let select_route = `${departure_time}発 `;

            for (let i = 0; i < route.length; i++) {
                select_route += `${route_station[i]}--${route[i]}--`;
            }

            select_route += `${route_station[route_station.length - 1]} ${arrival_time}`;
            document.getElementById("select").innerText = select_route;
        });




//              一ページフォームの名残
//            const syozoku = document.getElementById("syozoku").value;
//            sessionStorage.setItem("syozoku", syozoku);
//            const gakubu = document.getElementById("gakubu").value;
//            sessionStorage.setItem("gakubu", gakubu);
//            const gakka = document.getElementById("gakka").value;
//            sessionStorage.setItem("gakka", gakka);
//            const syokumei = document.getElementById("Syokumei").value;
//            sessionStorage.setItem("syokumei", syokumei);
//            const shimei = document.getElementById("Shimei").value;
//            sessionStorage.setItem("shimei", shimei);

            //このページのデータを読み取る 一応sessionStorageにも入れてみる
            const syozoku_2 = document.getElementById("Syozoku_2").value;
            sessionStorage.setItem("syozoku_2", syozoku_2);
            const syokumei_2 = document.getElementById("Syokumei_2").value;
            sessionStorage.setItem("syokumei_2", syokumei_2);
            const shimei_2 = document.getElementById("Shimei_2").value;
            sessionStorage.setItem("shimei_2", shimei_2);
            const mokuteki = document.getElementById("Mokuteki").value;
            sessionStorage.setItem("mokuteki", mokuteki);
            const youmuchi = document.getElementById("Youmuchi").value;
            sessionStorage.setItem("youmuchi", youmuchi);
            const youmusaki = document.getElementById("Youmusaki").value;
            sessionStorage.setItem("youmusaki", youmusaki);
            const nittei_1 = document.getElementById("Ddatetime").value;
            const nittei_2 = document.getElementById("Adatetime").value;
            const nittei_1_date = new Date(nittei_1);
            const nittei_2_date = new Date(nittei_2);

            // 年月日の部分を取得
            const nittei_1_formatted = `${nittei_1_date.getFullYear()}-${(nittei_1_date.getMonth() + 1).toString().padStart(2, '0')}-${nittei_1_date.getDate().toString().padStart(2, '0')}`;
            const nittei_2_formatted = `${nittei_2_date.getFullYear()}-${(nittei_2_date.getMonth() + 1).toString().padStart(2, '0')}-${nittei_2_date.getDate().toString().padStart(2, '0')}`;

            sessionStorage.setItem("nittei_1", nittei_1_formatted);
            sessionStorage.setItem("nittei_2", nittei_2_formatted);
            console.log(nittei_1_formatted);
            console.log(nittei_2_formatted);
//            sessionStorage.setItem("nittei_1", nittei_1);
//            const nittei_2 = document.getElementById("Adatetime").value;
//            sessionStorage.setItem("nittei_2", nittei_2);
            const syuttyouzikan = document.getElementById("Syuttyouzikan").value;
            sessionStorage.setItem("Syuttyozikan", syuttyouzikan);




        //console.log("セッションストレージ"+sessionStorage.getItem("syozoku"));

        //データセットに入れる（申請者のほうはsessionStorageから、このページのはgetElementById）
//        const data_set = {
//            Syozoku: sessionStorage.getItem("syozoku"),
//            Gakubu: sessionStorage.getItem("gakubu"),
//            Gakka: sessionStorage.getItem("gakka"),
//            Syokumei: sessionStorage.getItem("job_title"),
//            Shimei: sessionStorage.getItem("name"),
//            Syozoku_2: document.getElementById("Syozoku_2").value,
//            Syokumei_2: document.getElementById("Syokumei_2").value,
//            Shimei_2: document.getElementById("Shimei_2").value,
//            Mokuteki: document.getElementById("Mokuteki").value,
//            Youmuchi: document.getElementById("Youmuchi").value,
//            Youmusaki: document.getElementById("Youmusaki").value,
//            Nittei_1: document.getElementById("Ddatetime").value,
//            Nittei_2: document.getElementById("Adatetime").value,
//            Syuttyouzikan: document.getElementById("Syuttyouzikan").value,
//            Nittou: daily_money + "",
//            Unchin: unchin + "",
//            Syukuhakuhi: accommodation_fee + "",
//        };
//        console.log(data_set);
//        console.log(daily_money);
//        console.log(data_set.Unchin);
//        console.log(accommodation_fee);
//        makeExcel(data_set);

        let price = resultApp.PRICE_ONEWAY;
        resultApp.search(searchWord, price, result);
    });

    function formatTime(dateTimeString) {
        const date = new Date(dateTimeString);
        const hours = date.getHours();
        const minutes = date.getMinutes();
        return `${hours}時${minutes}分`;
    }
});

























// 15821093 山岡優希
//
//class DailyAllowanceModel {
//    constructor(name, travelHours) {
//        this.name = name;
//        this.travelHours = travelHours;
//        this.dailyAllowance = 0;
//    }
//}
//
//document.addEventListener("DOMContentLoaded", () => {
//    var daily_money = 0;
//    var unchin = 0;
//    var accommodation_fee = 0;
//    // 駅名入力パーツ初期化
//    const stationApp1 = new expGuiStation(document.getElementById("station1"));
//    const stationApp2 = new expGuiStation(document.getElementById("station2"));
//    const dateTimeApp = new expGuiDateTime(document.getElementById("dateTime"));
//    dateTimeApp.dispDateTime();
//    stationApp1.dispStation();
//    stationApp2.dispStation();
//
//    // 経路表示パーツ初期化
//    const resultApp = new expGuiCourse(document.getElementById("result"));
//
//    async function calcDailyAllowance(model) {
//        const params = {
//            method: "POST",
//            headers: {
//                "Content-Type": "application/json; charset=utf-8"
//            },
//            body: JSON.stringify(model)
//        };
//
//        try {
//            const response = await fetch("/calc_daily_allowance2", params);
//            const data = await response.json();
//
//            console.log(data);
//            daily_money = data.dailyAllowance;
//            accommodation_fee = 12000 * (data.travelHours / 24);
//        } catch (error) {
//            console.log(error);
//        }
//    }
//
//    function makeExcel(model) {
//        const params = {
//            method: "POST",
//            headers: {
//                "Content-Type": "application/json; charset=utf-8"
//            },
//            body: JSON.stringify(model)
//        };
//
//        fetch("/make_excel", params)
//            .then((response) => {
//                // handle the response if needed
//            })
//            .catch((error) => {
//                console.log(error);
//            });
//    }
//
//    document.getElementById("calc_daily_allowance_button").addEventListener("click", async () => {
//        console.log("js");
//
//        const Ddatetime = document.getElementById("Ddatetime").value;
//        const Adatetime = document.getElementById("Adatetime").value;
//        const name = sessionStorage.getItem("name");
//
//        const DdatetimeObj = new Date(Ddatetime);
//        const AdatetimeObj = new Date(Adatetime);
//
//        const Dms = DdatetimeObj.getTime();
//        const Ams = AdatetimeObj.getTime();
//
//        const msDiff = Ams - Dms;
//        const travelHours = msDiff / (1000 * 60 * 60);
//
//        const model = new DailyAllowanceModel(name, travelHours);
//        // 修正：calcDailyAllowanceが完了するまで待つ
//        await calcDailyAllowance(model);
//
//        const station1 = stationApp1.getStation();
//        const station2 = stationApp2.getStation();
//
//        // 修正：calcDailyAllowanceが完了するまで待ってからログを出力
//        console.log(daily_money);
//        console.log(unchin);
//        console.log(accommodation_fee);
//
//        let searchWord = "viaList=" + stationApp1.getStation() + ":" + stationApp2.getStation();
//        searchWord += "&date=" + dateTimeApp.getDate();
//        searchWord += "&time=" + dateTimeApp.getTime();
//        searchWord += "&answerCount=" + String(3);
//
//        function result(isSuccess) {
//            if (isSuccess) {
//                unchin = resultApp.getFarePrice();
//                const formattedDepartureDate = formatTime(resultApp.getDepartureDate());
//                const formattedArrivalDate = formatTime(resultApp.getArrivalDate());
//
//                console.log("出発日時：" + resultApp.getDepartureDate());
//                console.log("到着日時：" + resultApp.getArrivalDate());
//                console.log(resultApp.getResultString());
//            } else {
//                alert("探索結果が取得できませんでした");
//            }
//        }
//        document.getElementById("calc_daily_allowance_button").addEventListener("click", () => {
//            const departure_time = formatTime(resultApp.getDepartureDate().getTime());
//            const route = resultApp.getLineList().split(",");
//            const route_station = resultApp.getPointList().split(",");
//            const arrival_time = formatTime(resultApp.getArrivalDate().getTime());
//
//            let select_route = `${departure_time}発 `;
//
//            for (let i = 0; i < route.length; i++) {
//                select_route += `${route_station[i]}--${route[i]}--`;
//            }
//
//            select_route += `${route_station[route_station.length - 1]} ${arrival_time}`;
//            document.getElementById("select").innerText = select_route;
//        });
//
//        // 以下省略
//        const data_set = {
//            Syozoku: sessionStorage.getItem("syozoku"),
//            Gakubu: sessionStorage.getItem("gakubu"),
//            Gakka: sessionStorage.getItem("gakka"),
//            Syokumei: sessionStorage.getItem("job_title"),
//            Shimei: sessionStorage.getItem("name"),
//            // 以下省略
//            Nittou: daily_money + "",
//            Unchin: unchin + "",
//            Syukuhakuhi: accommodation_fee + "",
//        };
//        console.log(data_set);
//        makeExcel(data_set);
//
//        let price = resultApp.PRICE_ONEWAY;
//        resultApp.search(searchWord, price, result);
//    });
//
//    function formatTime(dateTimeString) {
//        const date = new Date(dateTimeString);
//        const hours = date.getHours();
//        const minutes = date.getMinutes();
//        return `${hours}時${minutes}分`;
//    }
//});
