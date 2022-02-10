async function login() {
    // Serialiser formen til js-objekt
    let loginform = document.getElementById("loginform");
    const formData = new FormData(loginform);
    const object = Object.fromEntries(formData);
    console.log(object)
    //Bruger fetch-API til at sende data - POST. JSON.stringify for at serialisere objekt til string.
    const res = await fetch("api/login", {
        method: "POST",
        body: JSON.stringify(object),
        headers: {
            "content-type": "application/json"
        }
    })
    // hvis vi får en token, gemmer vi den i browserens localstorage
    const token = await res.text();
    localStorage.setItem("token",token);
    //For ekstra krymmel fisker vi en bruger ud af tokenen
    const payload = window.atob(token.split(".")[1]);
    const payloadJson = JSON.parse(payload);
    localStorage.setItem("user",payloadJson.username);
    //Viderestil til den rigtige side!
    window.location.href="main.html"

}