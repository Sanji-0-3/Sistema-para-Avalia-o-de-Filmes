// Carregar tema do cookie
function loadTheme() {
    const themeLink = document.getElementById("themeStylesheet");
    if (!themeLink) return;

    const cookies = document.cookie.split(";").map(c => c.trim());
    const themeCookie = cookies.find(c => c.startsWith("theme="));
    const theme = themeCookie ? themeCookie.split("=")[1] : "light";
    themeLink.href = "css/" + theme + ".css";
}

// Alternar tema
function toggleTheme() {
    const themeLink = document.getElementById("themeStylesheet");
    if (!themeLink) return;

    const currentTheme = themeLink.href.includes("light.css") ? "light" : "dark";
    const newTheme = currentTheme === "light" ? "dark" : "light";
    themeLink.href = "css/" + newTheme + ".css";
    document.cookie = "theme=" + newTheme + ";path=/;max-age=" + (7*24*60*60); // 7 dias
}

// Garantir que o tema seja aplicado após o carregamento do DOM
document.addEventListener("DOMContentLoaded", loadTheme);
