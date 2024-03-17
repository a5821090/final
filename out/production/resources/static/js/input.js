//15821093
//山岡優希

//submitのボタンが押されたときにsettion strageに情報を入れる
document.getElementById("submit").addEventListener("click", () => {
    const syozoku = document.getElementById("syozoku").value;
    sessionStorage.setItem("syozoku", syozoku);
    const gakubu = document.getElementById("gakubu").value;
    sessionStorage.setItem("gakubu", gakubu);
    const gakka = document.getElementById("gakka").value;
    sessionStorage.setItem("gakka", gakka);
    const job_title = document.getElementById("job_title").value;
    sessionStorage.setItem("job_title", job_title);
    const name = document.getElementById("name").value;
    sessionStorage.setItem("name", name);
});