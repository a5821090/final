//15821093
//山岡優希
document.addEventListener("DOMContentLoaded", () => {

    function calcDailyAllowance(model) {
        const params = {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify(model)
        };
        fetch("/calc_daily_allowance", params)
            .then((response) => {
                return response.json();
            })
            .then((model) => {
                console.log(model);
                document.getElementById("daily_allowance").innerText = model.dailyAllowance;
                sessionStorage.setItem("daily_allowance", model.dailyAllowance);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    document.getElementById("calc_daily_allowance_button").addEventListener("click", () => {
        const name = document.getElementById("name").value;
        sessionStorage.setItem("name", name);
        const travelHours = parseInt(document.getElementById("travel_hours").value);
        sessionStorage.setItem("travel_hours", travelHours);
        //const jsonData = {"name": name, "travelHours": travelHours};
        //calcDailyAllowance(jsonData);
        const model = new DailyAllowanceModel(name, travelHours);
        calcDailyAllowance(model);
        //modelから名前と出張時間を持ってくる
        document.getElementById("name_out").innerText = model.name;
        document.getElementById("travel_hours_out").innerText = model.travelHours;
    });
});