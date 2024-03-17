//15821093
//山岡優希
document.addEventListener("DOMContentLoaded", () => {

    function calcAccommodationFee(model) {
        const params = {
            method: "POST",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify(model)
        };
        fetch("/calc_accommodation_fee", params)
            .then((response) => {
                return response.json();
            })
            .then((model) => {
                console.log(model);
                document.getElementById("accommodation_fee").innerText = model.accommodationFee;
                sessionStorage.setItem("accommodation_fee", model.accommodationFee);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    document.getElementById("calc_accommodation_fee_button").addEventListener("click", () => {
        const name = document.getElementById("name").value;
        sessionStorage.setItem("name", name);
        const jobTitle = document.getElementById("job_title").value;
        sessionStorage.setItem("job_title", jobTitle);
        const travelCategory = document.getElementById("travel_category").value;
        sessionStorage.setItem("travel_category", travelCategory);
        const numberOgNights = parseInt(document.getElementById("number_of_nights").value);
        sessionStorage.setItem("number_of_nights", numberOgNights);
        const cityType = document.getElementById("city_type").value;
        sessionStorage.setItem("city_type", cityType);
//        console.log(name);
//        console.log(jobTitle);
//        console.log(travelCategory);
//        console.log(numberOgNights);
//        console.log(cityType);
        //const jsonData = {"name": name, "travelHours": travelHours};
        //calcDailyAllowance(jsonData);
        const model = new AccommodationFeeModel(name, jobTitle, travelCategory, numberOgNights, cityType);
        calcAccommodationFee(model);

    });
});